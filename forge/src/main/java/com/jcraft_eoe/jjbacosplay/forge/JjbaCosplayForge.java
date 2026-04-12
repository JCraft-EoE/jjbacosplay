package com.jcraft_eoe.jjbacosplay.forge;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.forge.loot.JCForgeLootModifiers;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JjbaCosplay.MOD_ID)
public final class JjbaCosplayForge {
    public JjbaCosplayForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(JjbaCosplay.MOD_ID, modBus);
        // Run our common setup.
        JjbaCosplay.init();
        JCForgeLootModifiers.register(modBus);
    }
}
