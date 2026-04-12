package com.jcraft_eoe.jjbacosplay;

import net.minecraft.resources.ResourceLocation;

public final class JjbaCosplay {
    public static final String MOD_ID = "jjbacosplay";

    public static void init() {
        JCItemRegistry.ITEM_REGISTRY.register();
        JCLootTableHelper.registerMusicDiscLootTables();
        JCCreativeMenuTabRegistry.register();
        JCCreativeMenuTabRegistry.CREATIVE_TAB_REGISTRY.register();
    }

    public static ResourceLocation id(String location) {
        return new ResourceLocation(MOD_ID, location);
    }
}
