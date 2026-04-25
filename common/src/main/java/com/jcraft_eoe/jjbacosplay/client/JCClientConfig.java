package com.jcraft_eoe.jjbacosplay.client;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import lombok.Getter;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Getter
@Config(name = JjbaCosplay.MOD_ID)
public class JCClientConfig implements ConfigData {

    @Getter
    @ConfigEntry.Gui.Excluded
    private static JCClientConfig instance;

    private boolean showingAllTiers = true;

    public static void load() {
        instance = AutoConfig.getConfigHolder(JCClientConfig.class).getConfig();
    }

}
