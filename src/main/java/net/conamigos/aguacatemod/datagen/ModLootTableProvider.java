package net.conamigos.aguacatemod.datagen;

import net.conamigos.aguacatemod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //BLOCKS
        //addDrop(ModBlocks.BLOCK);

        //ORE
        //addDrop(ModBlocks.ORE, oreDrops(ModBlocks.ORE, ModItems.ITEMS));
    }
}
