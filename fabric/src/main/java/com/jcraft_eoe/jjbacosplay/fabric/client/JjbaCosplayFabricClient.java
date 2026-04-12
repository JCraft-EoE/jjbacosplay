package com.jcraft_eoe.jjbacosplay.fabric.client;

import com.jcraft_eoe.jjbacosplay.client.JjbaCosplayClient;
import net.fabricmc.api.ClientModInitializer;

public final class JjbaCosplayFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        JjbaCosplayClient.init();
    }
}
