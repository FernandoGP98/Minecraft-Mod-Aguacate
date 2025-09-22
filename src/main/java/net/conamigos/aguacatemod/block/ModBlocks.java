package net.conamigos.aguacatemod.block;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.block.Bushes.AvocadoBush;
import net.conamigos.aguacatemod.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AguacateMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AguacateMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static final Block AVOCADO_BUSH = registerBlockWithoutBlockItem(
            "avocado_bush",
            new AvocadoBush(
                    AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                            .noCollision()
                            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                            .pistonBehavior(PistonBehavior.DESTROY))
    );

    public static final Block AVOCADO_LEAVES = registerBlock("avocado_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block AVOCADO_SAPLING = registerBlock("avocado_sapling",
            new SaplingBlock(ModSaplingGenerators.AVOCADO, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static void registerModBlocks() {

        AguacateMod.LOGGER.info("Registering Mod Blocks for " + AguacateMod.MOD_ID);
    }
}
