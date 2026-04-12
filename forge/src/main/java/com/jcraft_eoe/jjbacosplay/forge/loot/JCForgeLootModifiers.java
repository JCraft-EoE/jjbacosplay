package com.jcraft_eoe.jjbacosplay.forge.loot;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public interface JCForgeLootModifiers {
    DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, JjbaCosplay.MOD_ID);

    RegistryObject<Codec<? extends IGlobalLootModifier>> FORGE_LOOT_ADAPTER =
            LOOT_MODIFIER_SERIALIZERS.register("loot_adapter", JCForgeLootAdapter.CODEC);

    static void register(final IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
