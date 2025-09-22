package net.conamigos.aguacatemod.block;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.block.Bushes.AvocadoBush;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    private static Identifier id(String path) {
        return Identifier.of(AguacateMod.MOD_ID, path);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, id(name), block);
    }

    public static final Block AVOCADO_BUSH = registerBlockWithoutBlockItem(
            "avocado_bush",
            new AvocadoBush(
                    AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                            .noCollision()
                            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                            .pistonBehavior(PistonBehavior.DESTROY))
    );

    public static void registerModBlocks() {

        AguacateMod.LOGGER.info("Registering Mod Blocks for " + AguacateMod.MOD_ID);
    }
}
