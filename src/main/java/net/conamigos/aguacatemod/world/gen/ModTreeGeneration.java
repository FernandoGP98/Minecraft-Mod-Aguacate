package net.conamigos.aguacatemod.world.gen;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.Map;

public class ModTreeGeneration {
    public static void generateTrees(){

        for (Map.Entry<RegistryKey<Biome>, Integer> entry : ModPlacedFeatures.BIOME_RARITY.entrySet()) {
            RegistryKey<Biome> biomeKey = entry.getKey();
            String biomeName = biomeKey.getValue().getPath();
            RegistryKey<PlacedFeature> placedKey = ModPlacedFeatures.registerKey("avocado_placed_" + biomeName);

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(biomeKey),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    placedKey
            );
        }
    }

    private static RegistryKey<PlacedFeature> registerKeyForBiome(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AguacateMod.MOD_ID, name));
    }
}
