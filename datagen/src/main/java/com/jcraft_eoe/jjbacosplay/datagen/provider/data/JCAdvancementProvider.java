package com.jcraft_eoe.jjbacosplay.datagen.provider.data;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCItemRegistry;
import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import lombok.NonNull;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class JCAdvancementProvider extends FabricAdvancementProvider {

    public JCAdvancementProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(final Consumer<Advancement> consumer) {
        // obtain any cosplay
        final Advancement obtainCosplay = Advancement.Builder.advancement()
                .display(JCItemRegistry.DIO_CAPE.get(ArmorMaterials.NETHERITE).get(),
                        Component.translatable("advancements.jjbacosplay.obtain_cosplay.title"),
                        Component.translatable("advancements.jjbacosplay.obtain_cosplay.description"),
                        new ResourceLocation("textures/block/pink_wool.png"),
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_cosplay", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(JCTagRegistry.COSPLAY).build()))
                .build(JjbaCosplay.id("obtain_cosplay"));
        consumer.accept(obtainCosplay);
        // obtain sun protections
        final Advancement obtainSunProtection = generateCosplayAdvancement(
                "sun_protection",
                JCItemRegistry.KARS_HEADWRAP.get(ArmorMaterials.IRON).get(),
                FrameType.GOAL,
                obtainCosplay,
                JCItemRegistry.KARS_HEADWRAP,
                JCItemRegistry.PUCCIS_HAT,
                JCItemRegistry.RISOTTO_CAP,
                JCItemRegistry.DIEGO_HAT,
                JCItemRegistry.COWBOY_HAT,
                JCItemRegistry.MOUNTAIN_TIM_HAT);
        consumer.accept(obtainSunProtection);
        // obtain Dio P1 outfit
        final Advancement obtainDioP1Outfit = generateCosplayAdvancement(
                "dio_p1_outfit",
                JCItemRegistry.DIO_P1_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.DIO_P1_WIG,
                JCItemRegistry.DIO_P1_JACKET,
                JCItemRegistry.DIO_P1_PANTS,
                JCItemRegistry.DIO_P1_BOOTS
        );
        consumer.accept(obtainDioP1Outfit);
        // obtain Jotaro P3 outfit
        final Advancement obtainJotaroOutfit = generateCosplayAdvancement(
                "jotaro_outfit",
                JCItemRegistry.JOTARO_CAP.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.JOTARO_CAP,
                JCItemRegistry.JOTARO_JACKET,
                JCItemRegistry.JOTARO_PANTS,
                JCItemRegistry.JOTARO_BOOTS
        );
        consumer.accept(obtainJotaroOutfit);
        // obtain Jotaro P4 outfit
        final Advancement obtainJotaroP4Outfit = generateCosplayAdvancement(
                "jotaro_p4_outfit",
                JCItemRegistry.JOTARO_P4_CAP.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainJotaroOutfit,
                JCItemRegistry.JOTARO_P4_CAP,
                JCItemRegistry.JOTARO_P4_JACKET,
                JCItemRegistry.JOTARO_P4_PANTS,
                JCItemRegistry.JOTARO_P4_BOOTS
        );
        consumer.accept(obtainJotaroP4Outfit);
        // obtain Jotaro P6 outfit
        final Advancement obtainJotaroP6Outfit = generateCosplayAdvancement(
                "jotaro_p6_outfit",
                JCItemRegistry.JOTARO_P6_CAP.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainJotaroP4Outfit,
                JCItemRegistry.JOTARO_P6_CAP,
                JCItemRegistry.JOTARO_P6_JACKET,
                JCItemRegistry.JOTARO_P6_PANTS,
                JCItemRegistry.JOTARO_P6_BOOTS
        );
        consumer.accept(obtainJotaroP6Outfit);
        // obtain Avdol outfit
        final Advancement obtainAvdolOutfit = generateCosplayAdvancement(
                "avdol_outfit",
                JCItemRegistry.AVDOL_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.AVDOL_WIG,
                JCItemRegistry.AVDOL_COAT,
                JCItemRegistry.AVDOL_PANTS,
                JCItemRegistry.AVDOL_BOOTS
        );
        consumer.accept(obtainAvdolOutfit);
        // obtain Kakyoin outfit
        final Advancement obtainKakyoinOutfit = generateCosplayAdvancement(
                "kakyoin_outfit",
                JCItemRegistry.KAKYOIN_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.KAKYOIN_WIG,
                JCItemRegistry.KAKYOIN_COAT,
                JCItemRegistry.KAKYOIN_PANTS,
                JCItemRegistry.KAKYOIN_BOOTS
        );
        consumer.accept(obtainKakyoinOutfit);
        // obtain Polnareff outfit
        final Advancement obtainPolnareffOutfit = generateCosplayAdvancement(
                "polnareff_outfit",
                JCItemRegistry.POLNAREFF_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.POLNAREFF_WIG,
                JCItemRegistry.POLNAREFF_SHIRT,
                JCItemRegistry.POLNAREFF_PANTS,
                JCItemRegistry.POLNAREFF_BOOTS
        );
        consumer.accept(obtainPolnareffOutfit);
        // obtain Vanilla Ice outfit
        final Advancement obtainViceOutfit = generateCosplayAdvancement(
                "vice_outfit",
                JCItemRegistry.VICE_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.GOAL,
                obtainCosplay,
                JCItemRegistry.VICE_WIG,
                JCItemRegistry.VICE_JACKET,
                JCItemRegistry.VICE_BOOTS
        );
        consumer.accept(obtainViceOutfit);
        // obtain Okuyasu outfit
        final Advancement obtainOkuyasuOutfit = generateCosplayAdvancement(
                "okuyasu_outfit",
                JCItemRegistry.OKUYASU_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.OKUYASU_WIG,
                JCItemRegistry.OKUYASU_JACKET,
                JCItemRegistry.OKUYASU_PANTS,
                JCItemRegistry.OKUYASU_BOOTS
        );
        consumer.accept(obtainOkuyasuOutfit);
        // obtain Kira outfit
        final Advancement obtainKiraOutfit = generateCosplayAdvancement(
                "kira_outfit",
                JCItemRegistry.KIRA_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.KIRA_WIG,
                JCItemRegistry.KIRA_JACKET,
                JCItemRegistry.KIRA_PANTS,
                JCItemRegistry.KIRA_BOOTS
        );
        consumer.accept(obtainKiraOutfit);
        // obtain Kosaku outfit
        final Advancement obtainKosakuOutfit = generateCosplayAdvancement(
                "kosaku_outfit",
                JCItemRegistry.KOSAKU_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainKiraOutfit,
                JCItemRegistry.KOSAKU_WIG,
                JCItemRegistry.KOSAKU_JACKET,
                JCItemRegistry.KOSAKU_PANTS,
                JCItemRegistry.KOSAKU_BOOTS
        );
        consumer.accept(obtainKosakuOutfit);
        // obtain Final Kira outfit
        final Advancement obtainFinalKiraOutfit = generateCosplayAdvancement(
                "final_kira_outfit",
                JCItemRegistry.FINAL_KIRA_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainKiraOutfit,
                JCItemRegistry.FINAL_KIRA_WIG,
                JCItemRegistry.FINAL_KIRA_JACKET,
                JCItemRegistry.FINAL_KIRA_PANTS,
                JCItemRegistry.FINAL_KIRA_BOOTS
        );
        consumer.accept(obtainFinalKiraOutfit);
        // obtain Giorno outfit
        final Advancement obtainGiornoOutfit = generateCosplayAdvancement(
                "giorno_outfit",
                JCItemRegistry.GIORNO_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.GIORNO_WIG,
                JCItemRegistry.GIORNO_JACKET,
                JCItemRegistry.GIORNO_PANTS,
                JCItemRegistry.GIORNO_BOOTS
        );
        consumer.accept(obtainGiornoOutfit);
        // obtain Risotto outfit
        final Advancement obtainRisottoOutfit = generateCosplayAdvancement(
                "risotto_outfit",
                JCItemRegistry.RISOTTO_CAP.get(ArmorMaterials.IRON).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.RISOTTO_CAP,
                JCItemRegistry.RISOTTO_JACKET,
                JCItemRegistry.RISOTTO_PANTS,
                JCItemRegistry.RISOTTO_BOOTS
        );
        consumer.accept(obtainRisottoOutfit);
        // obtain Doppio outfit
        final Advancement obtainDoppioOutfit = generateCosplayAdvancement(
                "doppio_outfit",
                JCItemRegistry.DOPPIO_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.GOAL,
                obtainCosplay,
                JCItemRegistry.DOPPIO_WIG,
                JCItemRegistry.DOPPIO_SHIRT
        );
        consumer.accept(obtainDoppioOutfit);
        // obtain Diavolo outfit
        final Advancement obtainDiavoloOutfit = generateCosplayAdvancement(
                "diavolo_outfit",
                JCItemRegistry.DIAVOLO_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainDoppioOutfit,
                JCItemRegistry.DIAVOLO_WIG,
                JCItemRegistry.DIAVOLO_SHIRT,
                JCItemRegistry.DIAVOLO_PANTS,
                JCItemRegistry.DIAVOLO_BOOTS
        );
        consumer.accept(obtainDiavoloOutfit);
        // obtain Johnny outfit
        final Advancement obtainJohnnyOutfit = generateCosplayAdvancement(
                "johnny_outfit",
                JCItemRegistry.JOHNNY_CAP.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.JOHNNY_CAP,
                JCItemRegistry.JOHNNY_JACKET,
                JCItemRegistry.JOHNNY_PANTS,
                JCItemRegistry.JOHNNY_BOOTS
        );
        consumer.accept(obtainJohnnyOutfit);
        // obtain Gyro outfit
        final Advancement obtainGyroOutfit = generateCosplayAdvancement(
                "gyro_outfit",
                JCItemRegistry.GYRO_HAT.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.GYRO_HAT,
                JCItemRegistry.GYRO_SHIRT,
                JCItemRegistry.GYRO_PANTS,
                JCItemRegistry.GYRO_BOOTS
        );
        consumer.accept(obtainGyroOutfit);
        // obtain Cowboy outfit
        final Advancement obtainCowboyOutfit = generateCosplayAdvancement(
                "cowboy_outfit",
                JCItemRegistry.COWBOY_HAT.get(ArmorMaterials.IRON).get(),
                FrameType.GOAL,
                obtainCosplay,
                JCItemRegistry.COWBOY_HAT,
                JCItemRegistry.COWBOY_PONCHO,
                JCItemRegistry.COWBOY_GUNBELT_SPURS
        );
        consumer.accept(obtainCowboyOutfit);
        // obtain Diego outfit
        final Advancement obtainDiegoOutfit = generateCosplayAdvancement(
                "diego_outfit",
                JCItemRegistry.DIEGO_HAT.get(ArmorMaterials.IRON).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.DIEGO_HAT,
                JCItemRegistry.DIEGO_SHIRT,
                JCItemRegistry.DIEGO_PANTS,
                JCItemRegistry.DIEGO_BOOTS
        );
        consumer.accept(obtainDiegoOutfit);
        // obtain Ringo outfit
        final Advancement obtainRingoOutfit = generateCosplayAdvancement(
                "ringo_outfit",
                JCItemRegistry.RINGO_OUTFIT.get(ArmorMaterials.NETHERITE).get(),
                FrameType.GOAL,
                obtainCosplay,
                JCItemRegistry.RINGO_OUTFIT,
                JCItemRegistry.RINGO_BOOTS
        );
        consumer.accept(obtainRingoOutfit);
        // obtain Valentine outfit
        final Advancement obtainValentineOutfit = generateCosplayAdvancement(
                "valentine_outfit",
                JCItemRegistry.VALENTINE_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.VALENTINE_WIG,
                JCItemRegistry.VALENTINE_JACKET,
                JCItemRegistry.VALENTINE_PANTS,
                JCItemRegistry.VALENTINE_BOOTS
        );
        consumer.accept(obtainValentineOutfit);
        // obtain Pucci outfit
        final Advancement obtainPucciOutfit = generateCosplayAdvancement(
                "pucci_outfit",
                JCItemRegistry.PUCCIS_HAT.get(ArmorMaterials.IRON).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.PUCCIS_HAT,
                JCItemRegistry.PUCCI_ROBE,
                JCItemRegistry.PUCCI_PANTS,
                JCItemRegistry.PUCCI_BOOTS
        );
        consumer.accept(obtainPucciOutfit);
        // obtain DIO outfit
        final Advancement obtainDioOutfit = generateCosplayAdvancement(
                "dio_outfit",
                JCItemRegistry.DIO_HEADBAND.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainDioP1Outfit,
                JCItemRegistry.DIO_HEADBAND,
                JCItemRegistry.DIO_JACKET,
                JCItemRegistry.DIO_CAPE,
                JCItemRegistry.DIO_PANTS,
                JCItemRegistry.DIO_BOOTS
        );
        consumer.accept(obtainDioOutfit);
        // obtain OH DIO outfit
        final Advancement obtainOhDioOutfit = generateCosplayAdvancement(
                "oh_dio_outfit",
                JCItemRegistry.OH_DIO_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainDioOutfit,
                JCItemRegistry.OH_DIO_WIG,
                JCItemRegistry.OH_DIO_JACKET,
                JCItemRegistry.OH_DIO_PANTS,
                JCItemRegistry.OH_DIO_BOOTS
        );
        consumer.accept(obtainOhDioOutfit);
        // obtain Heaven Attained outfit
        final Advancement obtainHeavenAttainedOutfit = generateCosplayAdvancement(
                "heaven_attained_outfit",
                JCItemRegistry.HEAVEN_ATTAINED_WIG.get(ArmorMaterials.NETHERITE).get(),
                FrameType.CHALLENGE,
                obtainOhDioOutfit,
                JCItemRegistry.HEAVEN_ATTAINED_WIG,
                JCItemRegistry.HEAVEN_ATTAINED_SHIRT,
                JCItemRegistry.HEAVEN_ATTAINED_PANTS,
                JCItemRegistry.HEAVEN_ATTAINED_BOOTS
        );
        consumer.accept(obtainHeavenAttainedOutfit);
        // obtain DIO outfit
        final Advancement obtainMountainTimOutfit = generateCosplayAdvancement(
                "mountain_tim_outfit",
                JCItemRegistry.MOUNTAIN_TIM_HAT.get(ArmorMaterials.IRON).get(),
                FrameType.CHALLENGE,
                obtainCosplay,
                JCItemRegistry.MOUNTAIN_TIM_HAT,
                JCItemRegistry.MOUNTAIN_TIM_SHIRT,
                JCItemRegistry.MOUNTAIN_TIM_COAT,
                JCItemRegistry.MOUNTAIN_TIM_PANTS,
                JCItemRegistry.MOUNTAIN_TIM_BOOTS
        );
        consumer.accept(obtainMountainTimOutfit);
    }



    protected Advancement generateCosplayAdvancement(final @NonNull String name, final @NonNull Item display, final @NonNull FrameType frame, final @NonNull Advancement parent, final @NonNull CosplayItem<?>... pieces) {
        if (pieces.length == 0) {
            throw new IllegalArgumentException("At least one cosplay piece must be specified!");
        }
        final String keyBase = "advancements." + JjbaCosplay.MOD_ID + ".obtain_" + name;
        var builder = Advancement.Builder.advancement()
                .display(display,
                        Component.translatable(keyBase + ".title"),
                        Component.translatable(keyBase + ".description"),
                        null,
                        frame,
                        true,
                        true,
                        false)
                .parent(parent);
        if (frame == FrameType.CHALLENGE) {
            builder = builder.rewards(AdvancementRewards.Builder.experience(200));
        }
        for (final CosplayItem<?> piece : pieces) {
            builder.addCriterion("has_" + piece.getName(),
                    InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(piece.getTag()).build()));
        }
        return builder.build(JjbaCosplay.id("obtain_" + name));
    }
}
