package net.conamigos.aguacatemod.datagen;

import net.conamigos.aguacatemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        /*List<ItemConvertible> ITEM_SMELTABLES = List.of(ModItems.ITEM, ModBlocks.ORE,
                ModBlocks.ORE2);

        offerSmelting(recipeExporter, ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.ITEMS, 0.25f, 200, "avocado");
        offerBlasting(recipeExporter, ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.ITEMS, 0.25f, 200, "avocado");*/
    }
}
