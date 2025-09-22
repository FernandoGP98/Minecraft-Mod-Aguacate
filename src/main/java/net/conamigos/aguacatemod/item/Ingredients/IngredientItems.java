package net.conamigos.aguacatemod.item.Ingredients;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.item.Ingredients.AvocadoItem.AvocadoItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class IngredientItems {

    protected static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(AguacateMod.MOD_ID, name), item);
    }

    public static void registerAllIngredients() {
        // 1) Registrar TODOS los items aquí (mientras los registries no están congelados)
        AvocadoItem.register();
        // Si luego hay más: SalsaRojaItem.register(); CarneAsadaItem.register(); ...

        // 2) Ahora sí podemos agregarlos al creative tab (solo lectura)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(AvocadoItem.AVOCADO);
        });
    }
}
