package com.jcraft_eoe.jjbacosplay.forge.client;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.client.JjbaCosplayClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = JjbaCosplay.MOD_ID)
public class JjbaCosplayForgeClient {

    @SubscribeEvent
    public static void handleClientSetup(final FMLClientSetupEvent event) {
        JjbaCosplayClient.init();
    }

}
