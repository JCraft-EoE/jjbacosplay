package com.jcraft_eoe.jjbacosplay;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;

public interface JCCreativeMenuTabRegistry {

    DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.CREATIVE_MODE_TAB);

    static void register() {
        CREATIVE_TAB_REGISTRY.register("cosplay", JCCreativeMenuTabRegistry::createCosplayItemGroup);
    }

    static CreativeModeTab createCosplayItemGroup() {
        return CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.jjbacosplay.cosplay"))
                .icon(() -> JCItemRegistry.DIO_CAPE.get(ArmorMaterials.NETHERITE).get().getDefaultInstance())
                // order of the creative tab
                .displayItems((displayContext, entries) -> {
                    // cosplay
                    for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
                        for (final RegistrySupplier<? extends ArmorItem> item : cosplayItem) {
                            entries.accept(item.get());
                        }
                    }
                })
                .build();
    }
}
