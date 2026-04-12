package com.jcraft_eoe.jjbacosplay;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;

public interface JCSoundRegistry {

    DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.SOUND_EVENT);

    RegistrySupplier<SoundEvent> JANGLE = register("jangle");

    static RegistrySupplier<SoundEvent> register(String name) {
        var event = SoundEvent.createVariableRangeEvent(JjbaCosplay.id(name));
        return SOUNDS.register(event.getLocation().getPath(), () -> event);
    }

    static void register() {
        SOUNDS.register();
    }
}
