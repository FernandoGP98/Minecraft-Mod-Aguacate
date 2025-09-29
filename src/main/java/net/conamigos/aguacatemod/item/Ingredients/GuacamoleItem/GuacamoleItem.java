package net.conamigos.aguacatemod.item.Ingredients.GuacamoleItem;

import net.conamigos.aguacatemod.item.Ingredients.IngredientItems;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class GuacamoleItem extends IngredientItems {
    public static final FoodComponent GUACAMOLE_CONFIG = new FoodComponent.Builder()
            .nutrition(4)                 // 2 muslitos
            .saturationModifier(0.6f)  // saturación moderada
            .snack()                   // se consume rápido
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 8 * 20, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20 * 20, 0), 0.30f)
            .build();

    public static Item GUACAMOLE;

    public static void register() {
        if (GUACAMOLE == null) {
            GUACAMOLE = IngredientItems.register(
                    "guacamole",
                    new Item(new Item.Settings().food(GUACAMOLE_CONFIG))
            );
        }
    }

    private GuacamoleItem() {}
}
