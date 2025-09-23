package net.conamigos.aguacatemod.world;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModPlacedFeatures {

    public static final Map<RegistryKey<Biome>, Integer> BIOME_RARITY = Map.of(
            BiomeKeys.SPARSE_JUNGLE, 50,
            BiomeKeys.JUNGLE, 50,
            BiomeKeys.FOREST, 100
    );

    public static final List<RegistryKey<PlacedFeature>> AVOCADO_PLACED_KEYS = new ArrayList<>();

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        var avocadoConfig = configuredFeatures.getOrThrow(ModConfiguredFeatures.AVOCADO_KEY);

        for (Map.Entry<RegistryKey<Biome>, Integer> entry : BIOME_RARITY.entrySet()) {
            RegistryKey<Biome> biomeKey = entry.getKey();
            int rarity = entry.getValue();

            String biomeName = biomeKey.getValue().getPath();
            RegistryKey<PlacedFeature> placedKey = registerKey("avocado_placed_" + biomeName);

            register(context, placedKey, avocadoConfig,
                    List.of(
                            RarityFilterPlacementModifier.of(rarity),
                            SquarePlacementModifier.of(),
                            PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                            BiomePlacementModifier.of(),
                            BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(ModBlocks.AVOCADO_SAPLING.getDefaultState(), BlockPos.ORIGIN))
                    ));

            AVOCADO_PLACED_KEYS.add(placedKey);
        }
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AguacateMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> config, List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?,?>> configuration, PlacementModifier... modifiers){
        register(context, key, configuration, List.of(modifiers));
    }

}
