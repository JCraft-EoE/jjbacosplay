package com.jcraft_eoe.jjbacosplay.client;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCItemRegistry;
import com.jcraft_eoe.jjbacosplay.client.renderer.ArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FlutteringChestRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.ExtendedHeadRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.ExtendedLeggingsRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FinalKiraArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FinalKiraJacketRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FugoShoesRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KiraArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KosakuArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KosakuJacketRenderer;
import dev.architectury.registry.registries.RegistrySupplier;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.ArmorItem;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class JjbaCosplayClient {

    public static void init() {
        JCClientEventsRegistry.registerClientEvents();
        AutoConfig.register(JCClientConfig.class, JanksonConfigSerializer::new);
        JCClientConfig.load();
        initCosplay();
    }

    private static void initCosplay() {
        initCosplay(JCItemRegistry.AVDOL_WIG, ExtendedHeadRenderer.of("avdolwig"));
        initCosplay(JCItemRegistry.AVDOL_COAT, ArmorRenderer.flutter("avdolcoat"));
        initCosplay(JCItemRegistry.AVDOL_PANTS, ExtendedLeggingsRenderer.of("avdoloutfit"));
        initCosplay(JCItemRegistry.AVDOL_BOOTS, ArmorRenderer.simple("avdoloutfit"));
        initCosplay(JCItemRegistry.COWBOY_HAT, ArmorRenderer.simple("cowboy_outfit"));
        initCosplay(JCItemRegistry.COWBOY_PONCHO, ArmorRenderer.simple("cowboy_poncho"));
        initCosplay(JCItemRegistry.COWBOY_GUNBELT_SPURS, ExtendedLeggingsRenderer.of("cowboy_outfit"));
        initCosplay(JCItemRegistry.DIAVOLO_WIG, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIAVOLO_SHIRT, ArmorRenderer.flutter("diavoloshirt"));
        initCosplay(JCItemRegistry.DIAVOLO_PANTS, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIAVOLO_BOOTS, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIEGO_HAT, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIEGO_SHIRT, ArmorRenderer.simple("diegotop"));
        initCosplay(JCItemRegistry.DIEGO_PANTS, ExtendedLeggingsRenderer.of("diegooutfit"));
        initCosplay(JCItemRegistry.DIEGO_BOOTS, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIO_HEADBAND, ArmorRenderer.simple("diojacket"));
        initCosplay(JCItemRegistry.DIO_JACKET, ArmorRenderer.flutter("diojacket"));
        initCosplay(JCItemRegistry.DIO_PANTS, ExtendedLeggingsRenderer.of("diotard"));
        initCosplay(JCItemRegistry.DIO_BOOTS, ArmorRenderer.simple("diotard"));
        initCosplay(JCItemRegistry.DIO_CAPE, FlutteringChestRenderer.of("diocape"));
        initCosplay(JCItemRegistry.DIO_P1_WIG, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.DIO_P1_JACKET, ArmorRenderer.simple("diotop"));
        initCosplay(JCItemRegistry.DIO_P1_PANTS, ExtendedLeggingsRenderer.of("diooutfit"));
        initCosplay(JCItemRegistry.DIO_P1_BOOTS, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.OH_DIO_WIG, ArmorRenderer.simple("oh_diojacket"));
        initCosplay(JCItemRegistry.OH_DIO_JACKET, ArmorRenderer.simple("oh_diojacket"));
        initCosplay(JCItemRegistry.OH_DIO_PANTS, ExtendedLeggingsRenderer.of("oh_diotard"));
        initCosplay(JCItemRegistry.OH_DIO_BOOTS, ArmorRenderer.simple("oh_diotard"));
        initCosplay(JCItemRegistry.DOPPIO_WIG, ArmorRenderer.simple("doppiotop"));
        initCosplay(JCItemRegistry.DOPPIO_SHIRT, ArmorRenderer.simple("doppiotop"));
        initCosplay(JCItemRegistry.FINAL_KIRA_WIG, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_JACKET, FinalKiraJacketRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_PANTS, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_BOOTS, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.FUGO_WIG, ArmorRenderer.simple("fugoextras"));
        initCosplay(JCItemRegistry.FUGO_JACKET, ArmorRenderer.simple("fugojacket"));
        initCosplay(JCItemRegistry.FUGO_PANTS, ExtendedLeggingsRenderer.of("fugooutfit"));
        initCosplay(JCItemRegistry.FUGO_BOOTS, FugoShoesRenderer::new);
        initCosplay(JCItemRegistry.GIORNO_WIG, ArmorRenderer.simple("giornoclothes"));
        initCosplay(JCItemRegistry.GIORNO_JACKET, FlutteringChestRenderer.of("giornojacket"));
        initCosplay(JCItemRegistry.GIORNO_PANTS, ExtendedLeggingsRenderer.of("giornoclothes"));
        initCosplay(JCItemRegistry.GIORNO_BOOTS, ArmorRenderer.simple("giornoclothes"));
        initCosplay(JCItemRegistry.GYRO_HAT, ArmorRenderer.simple("gyrotop"));
        initCosplay(JCItemRegistry.GYRO_SHIRT, ArmorRenderer.simple("gyrotop"));
        initCosplay(JCItemRegistry.GYRO_PANTS, ExtendedLeggingsRenderer.of("gyrobottom"));
        initCosplay(JCItemRegistry.GYRO_BOOTS, ArmorRenderer.simple("gyrobottom"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_WIG, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_SHIRT, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_PANTS, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_BOOTS, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.JOHNNY_CAP, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JOHNNY_JACKET, ArmorRenderer.simple("johnnytop"));
        initCosplay(JCItemRegistry.JOHNNY_PANTS, ExtendedLeggingsRenderer.of("johnnyclothes"));
        initCosplay(JCItemRegistry.JOHNNY_BOOTS, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JONATHAN_WIG, ArmorRenderer.simple("johnathan_outfit"));
        initCosplay(JCItemRegistry.JONATHAN_GEAR, ArmorRenderer.simple("johnathan_gear"));
        initCosplay(JCItemRegistry.JONATHAN_PANTS, ExtendedLeggingsRenderer.of("johnathan_outfit"));
        initCosplay(JCItemRegistry.JONATHAN_BOOTS, ArmorRenderer.simple("johnathan_outfit"));
        initCosplay(JCItemRegistry.JOSEPH_WIG, ArmorRenderer.simple("josephoutfit"));
        initCosplay(JCItemRegistry.JOSEPH_SCARF, ArmorRenderer.flutter("josephscarf"));
        initCosplay(JCItemRegistry.JOSEPH_PANTS, ExtendedLeggingsRenderer.of("josephoutfit"));
        initCosplay(JCItemRegistry.JOSEPH_BOOTS, ArmorRenderer.simple("josephoutfit"));
        initCosplay(JCItemRegistry.JOTARO_CAP, ArmorRenderer.simple("jotaroclothes"));
        initCosplay(JCItemRegistry.JOTARO_JACKET, FlutteringChestRenderer.of("jotarocoat"));
        initCosplay(JCItemRegistry.JOTARO_PANTS, ExtendedLeggingsRenderer.of("jotaroclothes"));
        initCosplay(JCItemRegistry.JOTARO_BOOTS, ArmorRenderer.simple("jotaroclothes"));
        initCosplay(JCItemRegistry.JOTARO_P4_CAP, ArmorRenderer.simple("jotaroclothesp4"));
        initCosplay(JCItemRegistry.JOTARO_P4_JACKET, FlutteringChestRenderer.of("jotarocoatp4"));
        initCosplay(JCItemRegistry.JOTARO_P4_PANTS, ExtendedLeggingsRenderer.of("jotaroclothesp4"));
        initCosplay(JCItemRegistry.JOTARO_P4_BOOTS, ArmorRenderer.simple("jotaroclothesp4"));
        initCosplay(JCItemRegistry.JOTARO_P6_CAP, ArmorRenderer.simple("jotaroclothesp6"));
        initCosplay(JCItemRegistry.JOTARO_P6_JACKET, FlutteringChestRenderer.of("jotarocoatp6"));
        initCosplay(JCItemRegistry.JOTARO_P6_PANTS, ExtendedLeggingsRenderer.of("jotaroclothesp6"));
        initCosplay(JCItemRegistry.JOTARO_P6_BOOTS, ArmorRenderer.simple("jotaroclothesp6"));
        initCosplay(JCItemRegistry.KAKYOIN_WIG, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.KAKYOIN_COAT, FlutteringChestRenderer.of("kakyoinshirt"));
        initCosplay(JCItemRegistry.KAKYOIN_PANTS, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.KAKYOIN_BOOTS, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_HAT, ArmorRenderer.simple("mountain_tim_clothes"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_SHIRT, ArmorRenderer.simple("mountain_tim_top"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_COAT, FlutteringChestRenderer.of("mountain_tim_coat"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_PANTS, ExtendedLeggingsRenderer.of("mountain_tim_clothes"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_BOOTS, ArmorRenderer.simple("mountain_tim_clothes"));
        initCosplay(JCItemRegistry.OKUYASU_WIG, ArmorRenderer.simple("okuyasuoutfit"));
        initCosplay(JCItemRegistry.OKUYASU_JACKET, ArmorRenderer.simple("okuyasujacket"));
        initCosplay(JCItemRegistry.OKUYASU_PANTS, ExtendedLeggingsRenderer.of("okuyasuoutfit"));
        initCosplay(JCItemRegistry.OKUYASU_BOOTS, ArmorRenderer.simple("okuyasuoutfit"));
        initCosplay(JCItemRegistry.POLNAREFF_WIG, ArmorRenderer.simple("polnareffoutfit"));
        initCosplay(JCItemRegistry.POLNAREFF_SHIRT, ArmorRenderer.simple("polnarefftop"));
        initCosplay(JCItemRegistry.POLNAREFF_PANTS, ExtendedLeggingsRenderer.of("polnareffoutfit"));
        initCosplay(JCItemRegistry.POLNAREFF_BOOTS, ArmorRenderer.simple("polnareffoutfit"));
        initCosplay(JCItemRegistry.KARS_HEADWRAP, ArmorRenderer.simple("karsoutfit"));
        initCosplay(JCItemRegistry.KIRA_WIG, KiraArmorRenderer::new);
        initCosplay(JCItemRegistry.KIRA_JACKET, ArmorRenderer.simple("kirajacket"));
        initCosplay(JCItemRegistry.KIRA_PANTS, KiraArmorRenderer::new);
        initCosplay(JCItemRegistry.KIRA_BOOTS, KiraArmorRenderer::new);
        initCosplay(JCItemRegistry.KOSAKU_WIG, KosakuArmorRenderer::new);
        initCosplay(JCItemRegistry.KOSAKU_JACKET, KosakuJacketRenderer::new);
        initCosplay(JCItemRegistry.KOSAKU_PANTS, KosakuArmorRenderer::new);
        initCosplay(JCItemRegistry.KOSAKU_BOOTS, KosakuArmorRenderer::new);
        initCosplay(JCItemRegistry.PUCCIS_HAT, ArmorRenderer.simple("puccis_hat"));
        initCosplay(JCItemRegistry.PUCCI_ROBE, FlutteringChestRenderer.of("puccirobe"));
        initCosplay(JCItemRegistry.PUCCI_PANTS, ArmorRenderer.simple("puccibottom"));
        initCosplay(JCItemRegistry.PUCCI_BOOTS, ArmorRenderer.simple("puccibottom"));
        initCosplay(JCItemRegistry.RINGO_OUTFIT, ExtendedLeggingsRenderer.of("ringooutfit"));
        initCosplay(JCItemRegistry.RINGO_BOOTS, ArmorRenderer.simple("ringooutfit"));
        initCosplay(JCItemRegistry.RISOTTO_CAP, ExtendedHeadRenderer.of("risottocap"));
        initCosplay(JCItemRegistry.RISOTTO_JACKET, ArmorRenderer.simple("risottotop"));
        initCosplay(JCItemRegistry.RISOTTO_PANTS, ExtendedLeggingsRenderer.of("risottobottom"));
        initCosplay(JCItemRegistry.RISOTTO_BOOTS, ArmorRenderer.simple("risottobottom"));
        initCosplay(JCItemRegistry.STRAIZO_PONCHO, ArmorRenderer.simple("straizoponcho"));
        initCosplay(JCItemRegistry.VALENTINE_WIG, ExtendedHeadRenderer.of("valentine_wig"));
        initCosplay(JCItemRegistry.VALENTINE_JACKET, FlutteringChestRenderer.of("valentinecoat"));
        initCosplay(JCItemRegistry.VALENTINE_PANTS, ExtendedLeggingsRenderer.of("valentinebottom"));
        initCosplay(JCItemRegistry.VALENTINE_BOOTS, ArmorRenderer.simple("valentinebottom"));
        initCosplay(JCItemRegistry.VICE_WIG, ArmorRenderer.simple("viceoutfit"));
        initCosplay(JCItemRegistry.VICE_JACKET, ArmorRenderer.simple("viceoutfit"));
        initCosplay(JCItemRegistry.VICE_BOOTS, ArmorRenderer.simple("viceoutfit"));
    }

    private static void initCosplay(CosplayItem<?> cosplay, Supplier<AzArmorRenderer> renderer) {
        for (RegistrySupplier<? extends ArmorItem> item : cosplay) {
            AzArmorRendererRegistry.register(renderer, item.get());
        }
    }
}
