package com.jcraft_eoe.jjbacosplay;

import com.jcraft_eoe.jjbacosplay.item.DIOJacketItem;
import com.jcraft_eoe.jjbacosplay.item.DIOtardItem;
import com.jcraft_eoe.jjbacosplay.item.DiavoloClothesItem;
import com.jcraft_eoe.jjbacosplay.item.DiavoloShirtItem;
import com.jcraft_eoe.jjbacosplay.item.DiegoOutfitItem;
import com.jcraft_eoe.jjbacosplay.item.DioP1ClothesItem;
import com.jcraft_eoe.jjbacosplay.item.DoppioClothesItem;
import com.jcraft_eoe.jjbacosplay.item.FinalKiraJacketItem;
import com.jcraft_eoe.jjbacosplay.item.FinalKiraOutfitItem;
import com.jcraft_eoe.jjbacosplay.item.FlutteringArmorItem;
import com.jcraft_eoe.jjbacosplay.item.GiornoClothesItem;
import com.jcraft_eoe.jjbacosplay.item.GiornoJacketItem;
import com.jcraft_eoe.jjbacosplay.item.GyroBottomItem;
import com.jcraft_eoe.jjbacosplay.item.HeavenAttainedItem;
import com.jcraft_eoe.jjbacosplay.item.JohnnyClothesItem;
import com.jcraft_eoe.jjbacosplay.item.JotaroClothesItem;
import com.jcraft_eoe.jjbacosplay.item.JotaroClothesP4Item;
import com.jcraft_eoe.jjbacosplay.item.JotaroClothesP6Item;
import com.jcraft_eoe.jjbacosplay.item.KakyoinClothesItem;
import com.jcraft_eoe.jjbacosplay.item.KakyoinCoatItem;
import com.jcraft_eoe.jjbacosplay.item.KiraJacketItem;
import com.jcraft_eoe.jjbacosplay.item.KiraOutfitItem;
import com.jcraft_eoe.jjbacosplay.item.KosakuJacketItem;
import com.jcraft_eoe.jjbacosplay.item.KosakuOutfitItem;
import com.jcraft_eoe.jjbacosplay.item.PucciBottomItem;
import com.jcraft_eoe.jjbacosplay.item.PucciRobeItem;
import com.jcraft_eoe.jjbacosplay.item.RingoOutfitItem;
import com.jcraft_eoe.jjbacosplay.item.RisottoBottomItem;
import com.jcraft_eoe.jjbacosplay.item.RisottoCapItem;
import com.jcraft_eoe.jjbacosplay.item.StraizoPonchoItem;
import com.jcraft_eoe.jjbacosplay.item.ValentineBottomItem;
import com.jcraft_eoe.jjbacosplay.item.ValentineTopItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface JCItemRegistry {

    DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.ITEM);
    DeferredRegister<Item> LEGACY_ITEM_REGISTRY = DeferredRegister.create("jcraft", Registries.ITEM);

    CosplayItem<DioP1ClothesItem> DIO_P1_WIG = registerHelmetLegacy("dio_p1_wig", DioP1ClothesItem::new);
    CosplayItem<DioP1ClothesItem> DIO_P1_JACKET = registerChestplateLegacy("dio_p1_jacket", DioP1ClothesItem::new);
    CosplayItem<DioP1ClothesItem> DIO_P1_PANTS = registerLeggingsLegacy("dio_p1_pants", DioP1ClothesItem::new);
    CosplayItem<DioP1ClothesItem> DIO_P1_BOOTS = registerBootsLegacy("dio_p1_boots", DioP1ClothesItem::new);

    CosplayItem<StraizoPonchoItem> STRAIZO_PONCHO = registerChestplateLegacy("straizo_poncho", StraizoPonchoItem::new);

    CosplayItem<ArmorItem> KARS_HEADWRAP = registerVampireHatLegacy("kars_headwrap", ArmorItem::new);

    CosplayItem<DIOJacketItem> DIO_HEADBAND = registerHelmetLegacy("dio_headband", DIOJacketItem::new);
    CosplayItem<DIOJacketItem> DIO_JACKET = registerChestplateLegacy("dio_jacket", DIOJacketItem::new);
    CosplayItem<DIOtardItem> DIO_PANTS = registerLeggingsLegacy("dio_pants", DIOtardItem::new);
    CosplayItem<DIOtardItem> DIO_BOOTS = registerBootsLegacy("dio_boots", DIOtardItem::new);
    CosplayItem<FlutteringArmorItem> DIO_CAPE = registerChestplateLegacy("dio_cape", FlutteringArmorItem::new);

    CosplayItem<ArmorItem> OH_DIO_WIG = registerHelmet("oh_dio_wig", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_JACKET = registerChestplate("oh_dio_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_PANTS = registerLeggings("oh_dio_pants", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_BOOTS = registerBoots("oh_dio_boots", ArmorItem::new);

    CosplayItem<HeavenAttainedItem> HEAVEN_ATTAINED_WIG = registerHelmetLegacy("heaven_attained_wig", HeavenAttainedItem::new);
    CosplayItem<FlutteringArmorItem> HEAVEN_ATTAINED_SHIRT = registerChestplateLegacy("heaven_attained_shirt", FlutteringArmorItem::new);
    CosplayItem<HeavenAttainedItem> HEAVEN_ATTAINED_PANTS = registerLeggingsLegacy("heaven_attained_pants", HeavenAttainedItem::new);
    CosplayItem<HeavenAttainedItem> HEAVEN_ATTAINED_BOOTS = registerBootsLegacy("heaven_attained_boots", HeavenAttainedItem::new);

    CosplayItem<JotaroClothesItem> JOTARO_CAP = registerHelmetLegacy("jotaro_cap", JotaroClothesItem::new);
    CosplayItem<FlutteringArmorItem> JOTARO_JACKET = registerChestplateLegacy("jotaro_jacket", FlutteringArmorItem::new);
    CosplayItem<JotaroClothesItem> JOTARO_PANTS = registerLeggingsLegacy("jotaro_pants", JotaroClothesItem::new);
    CosplayItem<JotaroClothesItem> JOTARO_BOOTS = registerBootsLegacy("jotaro_boots", JotaroClothesItem::new);

    CosplayItem<JotaroClothesP4Item> JOTARO_P4_CAP = registerHelmetLegacy("jotaro_p4_cap", JotaroClothesP4Item::new);
    CosplayItem<FlutteringArmorItem> JOTARO_P4_JACKET = registerChestplateLegacy("jotaro_p4_jacket", FlutteringArmorItem::new);
    CosplayItem<JotaroClothesP4Item> JOTARO_P4_PANTS = registerLeggingsLegacy("jotaro_p4_pants", JotaroClothesP4Item::new);
    CosplayItem<JotaroClothesP4Item> JOTARO_P4_BOOTS = registerBootsLegacy("jotaro_p4_boots", JotaroClothesP4Item::new);

    CosplayItem<JotaroClothesP6Item> JOTARO_P6_CAP = registerHelmetLegacy("jotaro_p6_cap", JotaroClothesP6Item::new);
    CosplayItem<FlutteringArmorItem> JOTARO_P6_JACKET = registerChestplateLegacy("jotaro_p6_jacket", FlutteringArmorItem::new);
    CosplayItem<JotaroClothesP6Item> JOTARO_P6_PANTS = registerLeggingsLegacy("jotaro_p6_pants", JotaroClothesP6Item::new);
    CosplayItem<JotaroClothesP6Item> JOTARO_P6_BOOTS = registerBootsLegacy("jotaro_p6_boots", JotaroClothesP6Item::new);

    CosplayItem<ArmorItem> AVDOL_WIG = registerHelmet("avdol_wig", ArmorItem::new);
    CosplayItem<ArmorItem> AVDOL_COAT = registerChestplate("avdol_coat", ArmorItem::new);
    CosplayItem<ArmorItem> AVDOL_PANTS = registerLeggings("avdol_pants", ArmorItem::new);
    CosplayItem<ArmorItem> AVDOL_BOOTS = registerBoots("avdol_boots", ArmorItem::new);

    CosplayItem<KakyoinClothesItem> KAKYOIN_WIG = registerHelmetLegacy("kakyoin_wig", KakyoinClothesItem::new);
    CosplayItem<KakyoinCoatItem> KAKYOIN_COAT = registerChestplateLegacy("kakyoin_coat", KakyoinCoatItem::new);
    CosplayItem<KakyoinClothesItem> KAKYOIN_PANTS = registerLeggingsLegacy("kakyoin_pants", KakyoinClothesItem::new);
    CosplayItem<KakyoinClothesItem> KAKYOIN_BOOTS = registerBootsLegacy("kakyoin_boots", KakyoinClothesItem::new);

    CosplayItem<ArmorItem> POLNAREFF_WIG = registerHelmet("polnareff_wig", ArmorItem::new);
    CosplayItem<ArmorItem> POLNAREFF_SHIRT = registerChestplate("polnareff_shirt", ArmorItem::new);
    CosplayItem<ArmorItem> POLNAREFF_PANTS = registerLeggings("polnareff_pants", ArmorItem::new);
    CosplayItem<ArmorItem> POLNAREFF_BOOTS = registerBoots("polnareff_boots", ArmorItem::new);

    CosplayItem<ArmorItem> VICE_WIG = registerHelmet("vice_wig", ArmorItem::new);
    CosplayItem<ArmorItem> VICE_JACKET = registerChestplate("vice_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> VICE_BOOTS = registerBoots("vice_boots", ArmorItem::new);

    CosplayItem<ArmorItem> OKUYASU_WIG = registerHelmet("okuyasu_wig", ArmorItem::new);
    CosplayItem<ArmorItem> OKUYASU_JACKET = registerChestplate("okuyasu_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> OKUYASU_PANTS = registerLeggings("okuyasu_pants", ArmorItem::new);
    CosplayItem<ArmorItem> OKUYASU_BOOTS = registerBoots("okuyasu_boots", ArmorItem::new);

    CosplayItem<KiraOutfitItem> KIRA_WIG = registerHelmetLegacy("kira_wig", KiraOutfitItem::new);
    CosplayItem<KiraJacketItem> KIRA_JACKET = registerChestplateLegacy("kira_jacket", KiraJacketItem::new);
    CosplayItem<KiraOutfitItem> KIRA_PANTS = registerLeggingsLegacy("kira_pants", KiraOutfitItem::new);
    CosplayItem<KiraOutfitItem> KIRA_BOOTS = registerBootsLegacy("kira_boots", KiraOutfitItem::new);
    CosplayItem<KosakuOutfitItem> KOSAKU_WIG = registerHelmetLegacy("kosaku_wig", KosakuOutfitItem::new);
    CosplayItem<KosakuJacketItem> KOSAKU_JACKET = registerChestplateLegacy("kosaku_jacket", KosakuJacketItem::new);
    CosplayItem<KosakuOutfitItem> KOSAKU_PANTS = registerLeggingsLegacy("kosaku_pants", KosakuOutfitItem::new);
    CosplayItem<KosakuOutfitItem> KOSAKU_BOOTS = registerBootsLegacy("kosaku_boots", KosakuOutfitItem::new);
    CosplayItem<FinalKiraOutfitItem> FINAL_KIRA_WIG = registerHelmetLegacy("final_kira_wig", FinalKiraOutfitItem::new);
    CosplayItem<FinalKiraJacketItem> FINAL_KIRA_JACKET = registerChestplateLegacy("final_kira_jacket", FinalKiraJacketItem::new);
    CosplayItem<FinalKiraOutfitItem> FINAL_KIRA_PANTS = registerLeggingsLegacy("final_kira_pants", FinalKiraOutfitItem::new);
    CosplayItem<FinalKiraOutfitItem> FINAL_KIRA_BOOTS = registerBootsLegacy("final_kira_boots", FinalKiraOutfitItem::new);

    CosplayItem<GiornoClothesItem> GIORNO_WIG = registerHelmetLegacy("giorno_wig", GiornoClothesItem::new);
    CosplayItem<GiornoJacketItem> GIORNO_JACKET = registerChestplateLegacy("giorno_jacket", GiornoJacketItem::new);
    CosplayItem<GiornoClothesItem> GIORNO_PANTS = registerLeggingsLegacy("giorno_pants", GiornoClothesItem::new);
    CosplayItem<GiornoClothesItem> GIORNO_BOOTS = registerBootsLegacy("giorno_boots", GiornoClothesItem::new);

    CosplayItem<RisottoCapItem> RISOTTO_CAP = registerVampireHatLegacy("risotto_cap", RisottoCapItem::new);
    CosplayItem<FlutteringArmorItem> RISOTTO_JACKET = registerChestplateLegacy("risotto_jacket", FlutteringArmorItem::new);
    CosplayItem<RisottoBottomItem> RISOTTO_PANTS = registerLeggingsLegacy("risotto_pants", RisottoBottomItem::new);
    CosplayItem<RisottoBottomItem> RISOTTO_BOOTS = registerBootsLegacy("risotto_boots", RisottoBottomItem::new);

    CosplayItem<DoppioClothesItem> DOPPIO_WIG = registerHelmetLegacy("doppio_wig", DoppioClothesItem::new);
    CosplayItem<DoppioClothesItem> DOPPIO_SHIRT = registerChestplateLegacy("doppio_shirt", DoppioClothesItem::new);

    CosplayItem<DiavoloClothesItem> DIAVOLO_WIG = registerHelmetLegacy("diavolo_wig", DiavoloClothesItem::new);
    CosplayItem<DiavoloShirtItem> DIAVOLO_SHIRT = registerChestplateLegacy("diavolo_shirt", DiavoloShirtItem::new);
    CosplayItem<DiavoloClothesItem> DIAVOLO_PANTS = registerLeggingsLegacy("diavolo_pants", DiavoloClothesItem::new);
    CosplayItem<DiavoloClothesItem> DIAVOLO_BOOTS = registerBootsLegacy("diavolo_boots", DiavoloClothesItem::new);

    CosplayItem<ArmorItem> PUCCIS_HAT = registerVampireHatLegacy("puccis_hat", ArmorItem::new);
    CosplayItem<PucciRobeItem> PUCCI_ROBE = registerChestplateLegacy("pucci_robe", PucciRobeItem::new);
    CosplayItem<PucciBottomItem> PUCCI_PANTS = registerLeggingsLegacy("pucci_pants", PucciBottomItem::new);
    CosplayItem<PucciBottomItem> PUCCI_BOOTS = registerBootsLegacy("pucci_boots", PucciBottomItem::new);

    CosplayItem<JohnnyClothesItem> JOHNNY_CAP = registerHelmetLegacy("johnny_cap", JohnnyClothesItem::new);
    CosplayItem<JohnnyClothesItem> JOHNNY_JACKET = registerChestplateLegacy("johnny_jacket", JohnnyClothesItem::new);
    CosplayItem<JohnnyClothesItem> JOHNNY_PANTS = registerLeggingsLegacy("johnny_pants", JohnnyClothesItem::new);
    CosplayItem<JohnnyClothesItem> JOHNNY_BOOTS = registerBootsLegacy("johnny_boots", JohnnyClothesItem::new);

    CosplayItem<FlutteringArmorItem> GYRO_HAT = registerHelmetLegacy("gyro_hat", FlutteringArmorItem::new);
    CosplayItem<FlutteringArmorItem> GYRO_SHIRT = registerChestplateLegacy("gyro_shirt", FlutteringArmorItem::new);
    CosplayItem<GyroBottomItem> GYRO_PANTS = registerLeggingsLegacy("gyro_pants", GyroBottomItem::new);
    CosplayItem<GyroBottomItem> GYRO_BOOTS = registerBootsLegacy("gyro_boots", GyroBottomItem::new);

    CosplayItem<DiegoOutfitItem> DIEGO_HAT = registerVampireHatLegacy("diego_hat", DiegoOutfitItem::new);
    CosplayItem<DiegoOutfitItem> DIEGO_SHIRT = registerChestplateLegacy("diego_shirt", DiegoOutfitItem::new);
    CosplayItem<DiegoOutfitItem> DIEGO_PANTS = registerLeggingsLegacy("diego_pants", DiegoOutfitItem::new);
    CosplayItem<DiegoOutfitItem> DIEGO_BOOTS = registerBootsLegacy("diego_boots", DiegoOutfitItem::new);

    CosplayItem<ArmorItem> MOUNTAIN_TIM_HAT = registerVampireHat("mountain_tim_hat", ArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_SHIRT = registerChestplate("mountain_tim_shirt", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> MOUNTAIN_TIM_COAT = registerChestplate("mountain_tim_coat", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_PANTS = registerLeggings("mountain_tim_pants", ArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_BOOTS = registerBoots("mountain_tim_boots", ArmorItem::new);

    CosplayItem<RingoOutfitItem> RINGO_OUTFIT = registerLeggingsLegacy("ringo_outfit", RingoOutfitItem::new);
    CosplayItem<RingoOutfitItem> RINGO_BOOTS = registerBootsLegacy("ringo_boots", RingoOutfitItem::new);

    CosplayItem<ArmorItem> COWBOY_HAT = registerVampireHat("cowboy_hat", ArmorItem::new);
    CosplayItem<ArmorItem> COWBOY_PONCHO = registerChestplate("cowboy_poncho", ArmorItem::new);
    CosplayItem<ArmorItem> COWBOY_GUNBELT_SPURS = registerLeggings("cowboy_gunbelt_spurs", ArmorItem::new);

    CosplayItem<ValentineTopItem> VALENTINE_WIG = registerHelmetLegacy("valentine_wig", ValentineTopItem::new);
    CosplayItem<ValentineTopItem> VALENTINE_JACKET = registerChestplateLegacy("valentine_jacket", ValentineTopItem::new);
    CosplayItem<ValentineBottomItem> VALENTINE_PANTS = registerLeggingsLegacy("valentine_pants", ValentineBottomItem::new);
    CosplayItem<ValentineBottomItem> VALENTINE_BOOTS = registerBootsLegacy("valentine_boots", ValentineBottomItem::new);

    static <T extends ArmorItem> CosplayItem<T> registerVampireHat(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.HELMET, true, ctor).register(JCItemRegistry::register);
    }

    static <T extends ArmorItem> CosplayItem<T> registerHelmet(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.HELMET, ctor).register(JCItemRegistry::register);
    }

    static <T extends ArmorItem> CosplayItem<T> registerChestplate(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.CHESTPLATE, ctor).register(JCItemRegistry::register);
    }

    static <T extends ArmorItem> CosplayItem<T> registerLeggings(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.LEGGINGS, ctor).register(JCItemRegistry::register);
    }

    static <T extends ArmorItem> CosplayItem<T> registerBoots(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.BOOTS, ctor).register(JCItemRegistry::register);
    }

    static <T extends ArmorItem> CosplayItem<T> registerVampireHatLegacy(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.HELMET, true, ctor).register(JCItemRegistry::register, JCItemRegistry::registerLegacy);
    }

    static <T extends ArmorItem> CosplayItem<T> registerHelmetLegacy(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.HELMET, ctor).register(JCItemRegistry::register, JCItemRegistry::registerLegacy);
    }

    static <T extends ArmorItem> CosplayItem<T> registerChestplateLegacy(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.CHESTPLATE, ctor).register(JCItemRegistry::register, JCItemRegistry::registerLegacy);
    }

    static <T extends ArmorItem> CosplayItem<T> registerLeggingsLegacy(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.LEGGINGS, ctor).register(JCItemRegistry::register, JCItemRegistry::registerLegacy);
    }

    static <T extends ArmorItem> CosplayItem<T> registerBootsLegacy(String id, CosplayItem.CosplayItemConstructor<T> ctor) {
        return new CosplayItem<>(JjbaCosplay.MOD_ID, id, ArmorItem.Type.BOOTS, ctor).register(JCItemRegistry::register, JCItemRegistry::registerLegacy);
    }

    static <T extends Item> RegistrySupplier<T> register(String id, Supplier<? extends T> supplier) {
        return ITEM_REGISTRY.register(id, supplier);
    }

    static <T extends Item> RegistrySupplier<T> registerLegacy(String id, Supplier<? extends T> supplier) {
        return LEGACY_ITEM_REGISTRY.register(id, supplier);
    }

}
