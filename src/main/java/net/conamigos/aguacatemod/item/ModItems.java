package net.conamigos.aguacatemod.item;

import net.conamigos.aguacatemod.AguacateMod;
import net.conamigos.aguacatemod.item.Ingredients.IngredientItems;
import net.conamigos.aguacatemod.item.Seeds.SeedItems;

public class ModItems {
    public static void registerModItems(){
        AguacateMod.LOGGER.info("Registering Mod Items for " + AguacateMod.MOD_ID);

        IngredientItems.registerAllIngredients();
        SeedItems.registerAllSeeds();
    }
}
