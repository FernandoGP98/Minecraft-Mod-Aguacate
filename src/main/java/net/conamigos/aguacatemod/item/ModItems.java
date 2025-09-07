package net.conamigos.aguacatemod.item;

import net.conamigos.aguacatemod.AguacateMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item AVOCADO = registerItem("avocado",new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(AguacateMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        AguacateMod.LOGGER.info("Registering Mod Items for " + AguacateMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{
            entries.add(AVOCADO);
        });
    }
}
