package com.jcraft_eoe.jjbacosplay.client;

import dev.architectury.event.events.client.ClientTickEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public interface JCClientEventsRegistry {

    static void registerClientEvents() {
        ClientTickEvent.CLIENT_POST.register(JCClientEvents::tickClient);
    }

}
