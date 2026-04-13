package com.jcraft_eoe.jjbacosplay.client;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCItemRegistry;
import com.jcraft_eoe.jjbacosplay.client.renderer.ArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.AvdolOutfitRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.AvdolWigRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.CowboyGunbeltRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.DIOCapeRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.DIOtardRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FinalKiraArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.FinalKiraJacketRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.GiornoArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.GiornoJacketRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.GyroBottomRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroArmorP4Renderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroArmorP6Renderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroCoatP4Renderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroCoatP6Renderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.JotaroCoatRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KakyoinCoatRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KiraArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KosakuArmorRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.KosakuJacketRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.MountainTimCoatRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.MountainTimPantsRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.OhDIOtardRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.OkuyasuOutfitRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.PucciRobeRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.RingoOutfitRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.RisottoBottomRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.RisottoCapRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.ValentineBottomRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.ValentineTopRenderer;
import com.jcraft_eoe.jjbacosplay.client.renderer.ValentineWigRenderer;
import dev.architectury.registry.registries.RegistrySupplier;
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
        initCosplay();
    }

    private static void initCosplay() {
        initCosplay(JCItemRegistry.AVDOL_WIG, AvdolWigRenderer::new);
        initCosplay(JCItemRegistry.AVDOL_COAT, ArmorRenderer.simple("avdolcoat"));
        initCosplay(JCItemRegistry.AVDOL_PANTS, AvdolOutfitRenderer::new);
        initCosplay(JCItemRegistry.AVDOL_BOOTS, ArmorRenderer.simple("avdoloutfit"));
        initCosplay(JCItemRegistry.COWBOY_HAT, ArmorRenderer.simple("cowboy_outfit"));
        initCosplay(JCItemRegistry.COWBOY_PONCHO, ArmorRenderer.simple("cowboy_poncho"));
        initCosplay(JCItemRegistry.COWBOY_GUNBELT_SPURS, CowboyGunbeltRenderer::new);
        initCosplay(JCItemRegistry.DIAVOLO_WIG, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIAVOLO_SHIRT, ArmorRenderer.flutter("diavoloshirt"));
        initCosplay(JCItemRegistry.DIAVOLO_PANTS, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIAVOLO_BOOTS, ArmorRenderer.simple("diavoloclothes"));
        initCosplay(JCItemRegistry.DIEGO_HAT, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIEGO_SHIRT, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIEGO_PANTS, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIEGO_BOOTS, ArmorRenderer.simple("diegooutfit"));
        initCosplay(JCItemRegistry.DIO_HEADBAND, ArmorRenderer.flutter("diojacket"));
        initCosplay(JCItemRegistry.DIO_JACKET, ArmorRenderer.flutter("diojacket"));
        initCosplay(JCItemRegistry.DIO_PANTS, DIOtardRenderer::new);
        initCosplay(JCItemRegistry.DIO_BOOTS, DIOtardRenderer::new);
        initCosplay(JCItemRegistry.DIO_CAPE, DIOCapeRenderer::new);
        initCosplay(JCItemRegistry.DIO_P1_WIG, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.DIO_P1_JACKET, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.DIO_P1_PANTS, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.DIO_P1_BOOTS, ArmorRenderer.simple("diooutfit"));
        initCosplay(JCItemRegistry.OH_DIO_WIG, ArmorRenderer.simple("oh_diojacket"));
        initCosplay(JCItemRegistry.OH_DIO_JACKET, ArmorRenderer.simple("oh_diojacket"));
        initCosplay(JCItemRegistry.OH_DIO_PANTS, OhDIOtardRenderer::new);
        initCosplay(JCItemRegistry.OH_DIO_BOOTS, OhDIOtardRenderer::new);
        initCosplay(JCItemRegistry.OKUYASU_WIG, OkuyasuOutfitRenderer::new);
        initCosplay(JCItemRegistry.OKUYASU_JACKET, ArmorRenderer.simple("okuyasujacket"));
        initCosplay(JCItemRegistry.OKUYASU_PANTS, OkuyasuOutfitRenderer::new);
        initCosplay(JCItemRegistry.OKUYASU_BOOTS, OkuyasuOutfitRenderer::new);
        initCosplay(JCItemRegistry.DOPPIO_WIG, ArmorRenderer.simple("doppiotop"));
        initCosplay(JCItemRegistry.DOPPIO_SHIRT, ArmorRenderer.simple("doppiotop"));
        initCosplay(JCItemRegistry.FINAL_KIRA_WIG, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_JACKET, FinalKiraJacketRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_PANTS, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.FINAL_KIRA_BOOTS, FinalKiraArmorRenderer::new);
        initCosplay(JCItemRegistry.GIORNO_WIG, GiornoArmorRenderer::new);
        initCosplay(JCItemRegistry.GIORNO_JACKET, GiornoJacketRenderer::new);
        initCosplay(JCItemRegistry.GIORNO_PANTS, GiornoArmorRenderer::new);
        initCosplay(JCItemRegistry.GIORNO_BOOTS, GiornoArmorRenderer::new);
        initCosplay(JCItemRegistry.GYRO_HAT, ArmorRenderer.simple("gyrotop"));
        initCosplay(JCItemRegistry.GYRO_SHIRT, ArmorRenderer.simple("gyrotop"));
        initCosplay(JCItemRegistry.GYRO_PANTS, GyroBottomRenderer::new);
        initCosplay(JCItemRegistry.GYRO_BOOTS, GyroBottomRenderer::new);
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_WIG, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_SHIRT, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_PANTS, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.HEAVEN_ATTAINED_BOOTS, ArmorRenderer.simple("heavenattainedoutfit"));
        initCosplay(JCItemRegistry.JOHNNY_CAP, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JOHNNY_JACKET, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JOHNNY_PANTS, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JOHNNY_BOOTS, ArmorRenderer.simple("johnnyclothes"));
        initCosplay(JCItemRegistry.JOTARO_CAP, JotaroArmorRenderer::new);
        initCosplay(JCItemRegistry.JOTARO_JACKET, JotaroCoatRenderer::new);
        initCosplay(JCItemRegistry.JOTARO_PANTS, JotaroArmorRenderer::new);
        initCosplay(JCItemRegistry.JOTARO_BOOTS, JotaroArmorRenderer::new);
        initCosplay(JCItemRegistry.JOTARO_P4_CAP, JotaroArmorP4Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P4_JACKET, JotaroCoatP4Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P4_PANTS, JotaroArmorP4Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P4_BOOTS, JotaroArmorP4Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P6_CAP, JotaroArmorP6Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P6_JACKET, JotaroCoatP6Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P6_PANTS, JotaroArmorP6Renderer::new);
        initCosplay(JCItemRegistry.JOTARO_P6_BOOTS, JotaroArmorP6Renderer::new);
        initCosplay(JCItemRegistry.KAKYOIN_WIG, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.KAKYOIN_COAT, KakyoinCoatRenderer::new);
        initCosplay(JCItemRegistry.KAKYOIN_PANTS, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.KAKYOIN_BOOTS, ArmorRenderer.simple("kakyoinclothes"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_HAT, ArmorRenderer.simple("mountain_tim_clothes"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_SHIRT, ArmorRenderer.simple("mountain_tim_top"));
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_COAT, MountainTimCoatRenderer::new);
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_PANTS, MountainTimPantsRenderer::new);
        initCosplay(JCItemRegistry.MOUNTAIN_TIM_BOOTS, ArmorRenderer.simple("mountain_tim_clothes"));
        initCosplay(JCItemRegistry.POLNAREFF_WIG, ArmorRenderer.simple("polnareffoutfit"));
        initCosplay(JCItemRegistry.POLNAREFF_SHIRT, ArmorRenderer.simple("polnareffoutfit"));
        initCosplay(JCItemRegistry.POLNAREFF_PANTS, ArmorRenderer.simple("polnareffoutfit"));
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
        initCosplay(JCItemRegistry.PUCCI_ROBE, PucciRobeRenderer::new);
        initCosplay(JCItemRegistry.PUCCI_PANTS, ArmorRenderer.simple("puccibottom"));
        initCosplay(JCItemRegistry.PUCCI_BOOTS, ArmorRenderer.simple("puccibottom"));
        initCosplay(JCItemRegistry.RINGO_OUTFIT, RingoOutfitRenderer::new);
        initCosplay(JCItemRegistry.RINGO_BOOTS, RingoOutfitRenderer::new);
        initCosplay(JCItemRegistry.RISOTTO_CAP, RisottoCapRenderer::new);
        initCosplay(JCItemRegistry.RISOTTO_JACKET, ArmorRenderer.simple("risottotop"));
        initCosplay(JCItemRegistry.RISOTTO_PANTS, RisottoBottomRenderer::new);
        initCosplay(JCItemRegistry.RISOTTO_BOOTS, RisottoBottomRenderer::new);
        initCosplay(JCItemRegistry.STRAIZO_PONCHO, ArmorRenderer.simple("straizoponcho"));
        initCosplay(JCItemRegistry.VALENTINE_WIG, ValentineWigRenderer::new);
        initCosplay(JCItemRegistry.VALENTINE_JACKET, ValentineTopRenderer::new);
        initCosplay(JCItemRegistry.VALENTINE_PANTS, ValentineBottomRenderer::new);
        initCosplay(JCItemRegistry.VALENTINE_BOOTS, ValentineBottomRenderer::new);
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
