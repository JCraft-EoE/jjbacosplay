package com.jcraft_eoe.jjbacosplay;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface JCItemRegistry {

    DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.ITEM);

    static <T extends Item> RegistrySupplier<T> register(String id, Supplier<? extends T> supplier) {
        return ITEM_REGISTRY.register(id, supplier);
    }

}
