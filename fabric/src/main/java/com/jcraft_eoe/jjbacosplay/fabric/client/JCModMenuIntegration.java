package com.jcraft_eoe.jjbacosplay.fabric.client;

import com.jcraft_eoe.jjbacosplay.client.JCClientConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;

public class JCModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(JCClientConfig.class, parent).get();
    }
}

