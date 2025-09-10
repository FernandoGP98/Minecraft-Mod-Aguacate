package net.conamigos.aguacatemod.datagen;

import net.conamigos.aguacatemod.item.Ingredients.AvocadoItem.AvocadoItem;
import net.conamigos.aguacatemod.util.ModIds;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static void genSimple(ItemModelGenerator gen, String... names) {
        for (String n : names) {
            // En algunos mapeos es gen.writer(), en otros gen.writer
            Models.GENERATED.upload(
                    ModIds.itemModel(n),
                    TextureMap.layer0(ModIds.itemTex(n)),
                    gen.writer
            );
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        genSimple(itemModelGenerator, ModIds.AVOCADO);
    }
}
