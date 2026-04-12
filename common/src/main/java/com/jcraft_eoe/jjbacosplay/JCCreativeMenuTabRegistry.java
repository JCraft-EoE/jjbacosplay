package com.jcraft_eoe.jjbacosplay;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public interface JCCreativeMenuTabRegistry {

    DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.CREATIVE_MODE_TAB);

    static void register() {
        CREATIVE_TAB_REGISTRY.register("music_discs", JCCreativeMenuTabRegistry::createMusicDiscItemGroup);
    }

    static CreativeModeTab createMusicDiscItemGroup() {
        return CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.jjbacosplay.cosplay"))
//                .icon(() -> JMItemRegistry.DISC_STAND_PROUD.get().getDefaultInstance())
                // order of the creative tab
                .displayItems((displayContext, entries) -> {
//                    entries.accept(JMItemRegistry.DISC_CRUCIFIED.get());
                })
                .build();
    }
}
