package net.conamigos.aguacatemod;

import net.conamigos.aguacatemod.block.ModBlocks;
import net.conamigos.aguacatemod.item.ModItems;
import net.conamigos.aguacatemod.item.ModItemsGroups;
import net.conamigos.aguacatemod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AguacateMod implements ModInitializer {
	public static final String MOD_ID = "aguacatemod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemsGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModWorldGeneration.generateModWorldGen();

		addFlammableBlock(ModBlocks.AVOCADO_LEAVES, 30, 60);

		TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 5),
					new ItemStack(ModBlocks.AVOCADO_SAPLING.asItem(), 1), 5, 2, 0.04f
			));
		});
	}

	private void addFlammableBlock(Block block, int burn, int spread){
		FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
	}
}