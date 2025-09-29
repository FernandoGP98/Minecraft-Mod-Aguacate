package net.conamigos.aguacatemod.item.Seeds.AvocadoSeed;

import net.conamigos.aguacatemod.block.ModBlocks;
import net.conamigos.aguacatemod.item.Seeds.SeedItems;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class AvocadoSeed extends SeedItems {
    public static final FoodComponent AVOCADOSEED_CONFIG = new FoodComponent.Builder()
            .build();

    public static Item AVOCADO_SEED;

    public static void register() {
        if (AVOCADO_SEED == null) {
            AVOCADO_SEED = SeedItems.register(
                    "avocado_seed",
                    new AliasedBlockItem(ModBlocks.AVOCADO_BUSH, new Item.Settings().food(AVOCADOSEED_CONFIG))
            );
        }
    }
}
