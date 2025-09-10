package net.conamigos.aguacatemod.item.Ingredients.AvocadoItem;

import net.conamigos.aguacatemod.item.Ingredients.IngredientItems;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class AvocadoItem extends IngredientItems {
    public static final FoodComponent AVOCADO_CONFIG = new FoodComponent.Builder()
            .nutrition(4)                 // 2 muslitos
            .saturationModifier(0.4f)  // saturación moderada
            .snack()                   // se consume rápido
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 10 * 20, 0), 0.30f)
            .build();

    public static Item AVOCADO;

    public static void register() {
        if (AVOCADO == null) {
            AVOCADO = IngredientItems.register("avocado",
                    new Item(new Item.Settings().food(AVOCADO_CONFIG)));
        }
    }

    private AvocadoItem() {}
}
