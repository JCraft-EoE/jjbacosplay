package com.jcraft_eoe.jjbacosplay.forge.client;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.client.JCClientConfig;
import com.jcraft_eoe.jjbacosplay.client.JjbaCosplayClient;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = JjbaCosplay.MOD_ID)
public class JjbaCosplayForgeClient {

    @SubscribeEvent
    public static void handleClientSetup(final FMLClientSetupEvent event) {
        JjbaCosplayClient.init();
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(
                (minecraft, screen) -> AutoConfig.getConfigScreen(JCClientConfig.class, screen).get()));
    }

}
