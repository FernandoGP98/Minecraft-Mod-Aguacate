package net.conamigos.aguacatemod.util;

import net.conamigos.aguacatemod.AguacateMod;
import net.minecraft.util.Identifier;

public class ModIds {
    private ModIds() {}
    public static final String AVOCADO = "avocado";

    public static Identifier id(String path) {
        return Identifier.of(AguacateMod.MOD_ID, path);
    }
    public static Identifier itemModel(String name) {
        return id("item/" + name);
    }
    public static Identifier itemTex(String name) {
        return id("item/" + name);
    }
}
