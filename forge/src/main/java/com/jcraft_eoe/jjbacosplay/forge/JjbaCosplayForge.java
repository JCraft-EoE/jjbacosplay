package com.jcraft_eoe.jjbacosplay.forge;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.forge.datafixer.JCForgeMissingMappings;
import com.jcraft_eoe.jjbacosplay.forge.loot.JCForgeLootModifiers;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JjbaCosplay.MOD_ID)
public final class JjbaCosplayForge {

    public JjbaCosplayForge(final FMLJavaModLoadingContext ctx) {
        IEventBus modBus = ctx.getModEventBus();
        EventBuses.registerModEventBus(JjbaCosplay.MOD_ID, modBus);

        // Run our common setup.
        JjbaCosplay.init();
        JCForgeLootModifiers.register(modBus);
        // Remap jcraft: cosplay items in level.dat's registry snapshot to their jjbacosplay: counterparts.
        // (NBT-stored ItemStacks are handled by the common ItemStackMixin.)
        JCForgeMissingMappings.register();
    }

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        JjbaCosplay.postInit();
    }
}
