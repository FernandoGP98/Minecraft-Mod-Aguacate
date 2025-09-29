package net.conamigos.aguacatemod.item.Seeds;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.item.Seeds.AvocadoSeed.AvocadoSeed;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SeedItems {
    protected static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(AguacateMod.MOD_ID, name), item);
    }

    public static void registerAllSeeds() {

        AvocadoSeed.register();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AvocadoSeed.AVOCADO_SEED);
        });
    }
}
