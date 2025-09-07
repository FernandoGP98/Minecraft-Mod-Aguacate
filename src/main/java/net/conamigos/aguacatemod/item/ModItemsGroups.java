package net.conamigos.aguacatemod.item;

import net.conamigos.aguacatemod.AguacateMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    public static final ItemGroup AVOCADO_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AguacateMod.MOD_ID, "avocado_items"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModItems.AVOCADO))
                    .displayName(Text.translatable("item.aguacatemod.avocadoitems"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.AVOCADO);
                    }).build());

    /*public static final ItemGroup AVOCADO_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AguacateMod.MOD_ID, "avocado_blocks"),
            FabricItemGroup.builder().icon(()->new ItemStack(ModBlocks.BLOQUE))
                    .displayName(Text.translatable("item.aguacatemod.BLOQUE"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLOQUE);
                    }).build());*/

    public static void registerItemGroups(){
        AguacateMod.LOGGER.info("Registering Item Groups for " + AguacateMod.MOD_ID);
    }
}
