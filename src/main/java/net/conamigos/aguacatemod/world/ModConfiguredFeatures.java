package net.conamigos.aguacatemod.world;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> AVOCADO_KEY = registerKey("avocado");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){

        register(context, AVOCADO_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(5, 6, 8),
                BlockStateProvider.of(ModBlocks.AVOCADO_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AguacateMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC config){
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
