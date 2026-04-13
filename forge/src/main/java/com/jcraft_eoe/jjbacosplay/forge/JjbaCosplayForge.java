package com.jcraft_eoe.jjbacosplay.forge;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.forge.loot.JCForgeLootModifiers;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JjbaCosplay.MOD_ID)
public final class JjbaCosplayForge {

    public JjbaCosplayForge(final FMLJavaModLoadingContext ctx) {
        IEventBus modBus = ctx.getModEventBus();
        EventBuses.registerModEventBus(JjbaCosplay.MOD_ID, modBus);

        // Register our bus as the jcraft bus if jcraft is not installed.
        if (!ModList.get().isLoaded("jcraft"))
            EventBuses.registerModEventBus("jcraft", modBus);

        // Run our common setup.
        JjbaCosplay.init();
        JCForgeLootModifiers.register(modBus);
    }

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        JjbaCosplay.postInit();
    }
}
