package net.conamigos.aguacatemod.util;

import net.conamigos.aguacatemod.AguacateMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> aguacatemod = createTag("aguacatemod");
        public static final TagKey<Item> AVOCADO = createTag("avocado");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AguacateMod.MOD_ID, name));
        }
    }
}
