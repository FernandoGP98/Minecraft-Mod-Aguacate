package net.conamigos.aguacatemod.datagen;

import net.conamigos.aguacatemod.item.Ingredients.AvocadoItem.AvocadoItem;
import net.conamigos.aguacatemod.item.Ingredients.GuacamoleItem.GuacamoleItem;
import net.conamigos.aguacatemod.item.ModItems;
import net.conamigos.aguacatemod.item.Seeds.AvocadoSeed.AvocadoSeed;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.item.Items.BOWL;

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
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GuacamoleItem.GUACAMOLE)
                .pattern("**")
                .pattern("- ")
                .input('*', AvocadoItem.AVOCADO)
                .input('-', BOWL)
                .criterion(hasItem(AvocadoItem.AVOCADO), conditionsFromItem(AvocadoItem.AVOCADO))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, AvocadoSeed.AVOCADO_SEED, 1)
                .input(AvocadoItem.AVOCADO)
                .criterion(hasItem(AvocadoItem.AVOCADO), conditionsFromItem(AvocadoItem.AVOCADO))
                .offerTo(recipeExporter);
    }
}
