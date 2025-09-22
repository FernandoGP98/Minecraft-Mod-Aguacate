package net.conamigos.aguacatemod.world.tree;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {

    public static final SaplingGenerator AVOCADO = new SaplingGenerator(AguacateMod.MOD_ID + ":avocado",
            Optional.empty(), Optional.of(ModConfiguredFeatures.AVOCADO_KEY), Optional.empty());
}
