package com.jcraft_eoe.jjbacosplay;

import dev.architectury.registry.registries.RegistrySupplier;
import mod.azure.azurelib.animation.cache.AzIdentityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;

public final class JjbaCosplay {

    public static final String MOD_ID = "jjbacosplay";

    /**
     * String ID of the base controller.
     */
    public static final String BASE_CONTROLLER = "base_controller";

    public static void init() {
        JCSoundRegistry.register();
        JCItemRegistry.ITEM_REGISTRY.register();
        JCItemRegistry.LEGACY_ITEM_REGISTRY.register();
        JCLootTableHelper.registerMusicDiscLootTables();
        JCCreativeMenuTabRegistry.register();
        JCCreativeMenuTabRegistry.CREATIVE_TAB_REGISTRY.register();
    }

    public static void postInit() {
        registerAzArmor();
    }

    private static void registerAzArmor() {
        for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
            for (final RegistrySupplier<? extends ArmorItem> item : cosplayItem) {
                AzIdentityRegistry.register(item.get());
            }
        }
    }

    public static ResourceLocation id(String location) {
        return new ResourceLocation(MOD_ID, location);
    }
}
