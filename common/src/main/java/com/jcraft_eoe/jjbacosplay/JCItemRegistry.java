package com.jcraft_eoe.jjbacosplay;

import com.jcraft_eoe.jjbacosplay.item.FlutteringArmorItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface JCItemRegistry {

    DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(JjbaCosplay.MOD_ID, Registries.ITEM);
    DeferredRegister<Item> LEGACY_ITEM_REGISTRY = DeferredRegister.create("jcraft", Registries.ITEM);

    CosplayItem<ArmorItem> JONATHAN_WIG = registerHelmet("jonathan_wig", ArmorItem::new);
    CosplayItem<ArmorItem> JONATHAN_GEAR = registerChestplate("jonathan_gear", ArmorItem::new);
    CosplayItem<ArmorItem> JONATHAN_PANTS = registerLeggings("jonathan_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JONATHAN_BOOTS = registerBoots("jonathan_boots", ArmorItem::new);

    CosplayItem<ArmorItem> DIO_P1_WIG = registerHelmetLegacy("dio_p1_wig", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_P1_JACKET = registerChestplateLegacy("dio_p1_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_P1_PANTS = registerLeggingsLegacy("dio_p1_pants", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_P1_BOOTS = registerBootsLegacy("dio_p1_boots", ArmorItem::new);

    CosplayItem<ArmorItem> STRAIZO_PONCHO = registerChestplateLegacy("straizo_poncho", ArmorItem::new);

    CosplayItem<ArmorItem> JOSEPH_WIG = registerHelmet("joseph_wig", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> JOSEPH_SCARF = registerChestplate("joseph_scarf", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> JOSEPH_PANTS = registerLeggings("joseph_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JOSEPH_BOOTS = registerBoots("joseph_boots", ArmorItem::new);

    CosplayItem<ArmorItem> KARS_HEADWRAP = registerVampireHatLegacy("kars_headwrap", ArmorItem::new);

    CosplayItem<ArmorItem> DIO_HEADBAND = registerHelmetLegacy("dio_headband", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_JACKET = registerChestplateLegacy("dio_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_PANTS = registerLeggingsLegacy("dio_pants", ArmorItem::new);
    CosplayItem<ArmorItem> DIO_BOOTS = registerBootsLegacy("dio_boots", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> DIO_CAPE = registerChestplateLegacy("dio_cape", FlutteringArmorItem::new);

    CosplayItem<ArmorItem> OH_DIO_WIG = registerHelmet("oh_dio_wig", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_JACKET = registerChestplate("oh_dio_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_PANTS = registerLeggings("oh_dio_pants", ArmorItem::new);
    CosplayItem<ArmorItem> OH_DIO_BOOTS = registerBoots("oh_dio_boots", ArmorItem::new);

    CosplayItem<ArmorItem> HEAVEN_ATTAINED_WIG = registerHelmetLegacy("heaven_attained_wig", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> HEAVEN_ATTAINED_SHIRT = registerChestplateLegacy("heaven_attained_shirt", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> HEAVEN_ATTAINED_PANTS = registerLeggingsLegacy("heaven_attained_pants", ArmorItem::new);
    CosplayItem<ArmorItem> HEAVEN_ATTAINED_BOOTS = registerBootsLegacy("heaven_attained_boots", ArmorItem::new);

    CosplayItem<ArmorItem> JOTARO_CAP = registerHelmetLegacy("jotaro_cap", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> JOTARO_JACKET = registerChestplateLegacy("jotaro_jacket", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_PANTS = registerLeggingsLegacy("jotaro_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_BOOTS = registerBootsLegacy("jotaro_boots", ArmorItem::new);

    CosplayItem<ArmorItem> JOTARO_P4_CAP = registerHelmetLegacy("jotaro_p4_cap", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> JOTARO_P4_JACKET = registerChestplateLegacy("jotaro_p4_jacket", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_P4_PANTS = registerLeggingsLegacy("jotaro_p4_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_P4_BOOTS = registerBootsLegacy("jotaro_p4_boots", ArmorItem::new);

    CosplayItem<ArmorItem> JOTARO_P6_CAP = registerHelmetLegacy("jotaro_p6_cap", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> JOTARO_P6_JACKET = registerChestplateLegacy("jotaro_p6_jacket", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_P6_PANTS = registerLeggingsLegacy("jotaro_p6_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JOTARO_P6_BOOTS = registerBootsLegacy("jotaro_p6_boots", ArmorItem::new);

    CosplayItem<ArmorItem> AVDOL_WIG = registerHelmet("avdol_wig", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> AVDOL_COAT = registerChestplate("avdol_coat", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> AVDOL_PANTS = registerLeggings("avdol_pants", ArmorItem::new);
    CosplayItem<ArmorItem> AVDOL_BOOTS = registerBoots("avdol_boots", ArmorItem::new);

    CosplayItem<ArmorItem> KAKYOIN_WIG = registerHelmetLegacy("kakyoin_wig", ArmorItem::new);
    CosplayItem<ArmorItem> KAKYOIN_COAT = registerChestplateLegacy("kakyoin_coat", ArmorItem::new);
    CosplayItem<ArmorItem> KAKYOIN_PANTS = registerLeggingsLegacy("kakyoin_pants", ArmorItem::new);
    CosplayItem<ArmorItem> KAKYOIN_BOOTS = registerBootsLegacy("kakyoin_boots", ArmorItem::new);

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

    CosplayItem<ArmorItem> KIRA_WIG = registerHelmetLegacy("kira_wig", ArmorItem::new);
    CosplayItem<ArmorItem> KIRA_JACKET = registerChestplateLegacy("kira_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> KIRA_PANTS = registerLeggingsLegacy("kira_pants", ArmorItem::new);
    CosplayItem<ArmorItem> KIRA_BOOTS = registerBootsLegacy("kira_boots", ArmorItem::new);
    CosplayItem<ArmorItem> KOSAKU_WIG = registerHelmetLegacy("kosaku_wig", ArmorItem::new);
    CosplayItem<ArmorItem> KOSAKU_JACKET = registerChestplateLegacy("kosaku_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> KOSAKU_PANTS = registerLeggingsLegacy("kosaku_pants", ArmorItem::new);
    CosplayItem<ArmorItem> KOSAKU_BOOTS = registerBootsLegacy("kosaku_boots", ArmorItem::new);
    CosplayItem<ArmorItem> FINAL_KIRA_WIG = registerHelmetLegacy("final_kira_wig", ArmorItem::new);
    CosplayItem<ArmorItem> FINAL_KIRA_JACKET = registerChestplateLegacy("final_kira_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> FINAL_KIRA_PANTS = registerLeggingsLegacy("final_kira_pants", ArmorItem::new);
    CosplayItem<ArmorItem> FINAL_KIRA_BOOTS = registerBootsLegacy("final_kira_boots", ArmorItem::new);

    CosplayItem<ArmorItem> GIORNO_WIG = registerHelmetLegacy("giorno_wig", ArmorItem::new);
    CosplayItem<ArmorItem> GIORNO_JACKET = registerChestplateLegacy("giorno_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> GIORNO_PANTS = registerLeggingsLegacy("giorno_pants", ArmorItem::new);
    CosplayItem<ArmorItem> GIORNO_BOOTS = registerBootsLegacy("giorno_boots", ArmorItem::new);

    CosplayItem<ArmorItem> FUGO_WIG = registerHelmet("fugo_wig", ArmorItem::new);
    CosplayItem<ArmorItem> FUGO_JACKET = registerChestplate("fugo_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> FUGO_PANTS = registerLeggings("fugo_pants", ArmorItem::new);
    CosplayItem<ArmorItem> FUGO_BOOTS = registerBoots("fugo_boots", ArmorItem::new);

    CosplayItem<ArmorItem> RISOTTO_CAP = registerVampireHatLegacy("risotto_cap", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> RISOTTO_JACKET = registerChestplateLegacy("risotto_jacket", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> RISOTTO_PANTS = registerLeggingsLegacy("risotto_pants", ArmorItem::new);
    CosplayItem<ArmorItem> RISOTTO_BOOTS = registerBootsLegacy("risotto_boots", ArmorItem::new);

    CosplayItem<ArmorItem> DOPPIO_WIG = registerHelmetLegacy("doppio_wig", ArmorItem::new);
    CosplayItem<ArmorItem> DOPPIO_SHIRT = registerChestplateLegacy("doppio_shirt", ArmorItem::new);

    CosplayItem<ArmorItem> DIAVOLO_WIG = registerHelmetLegacy("diavolo_wig", ArmorItem::new);
    CosplayItem<ArmorItem> DIAVOLO_SHIRT = registerChestplateLegacy("diavolo_shirt", ArmorItem::new);
    CosplayItem<ArmorItem> DIAVOLO_PANTS = registerLeggingsLegacy("diavolo_pants", ArmorItem::new);
    CosplayItem<ArmorItem> DIAVOLO_BOOTS = registerBootsLegacy("diavolo_boots", ArmorItem::new);

    CosplayItem<ArmorItem> PUCCIS_HAT = registerVampireHatLegacy("puccis_hat", ArmorItem::new);
    CosplayItem<ArmorItem> PUCCI_ROBE = registerChestplateLegacy("pucci_robe", ArmorItem::new);
    CosplayItem<ArmorItem> PUCCI_PANTS = registerLeggingsLegacy("pucci_pants", ArmorItem::new);
    CosplayItem<ArmorItem> PUCCI_BOOTS = registerBootsLegacy("pucci_boots", ArmorItem::new);

    CosplayItem<ArmorItem> JOHNNY_CAP = registerHelmetLegacy("johnny_cap", ArmorItem::new);
    CosplayItem<ArmorItem> JOHNNY_JACKET = registerChestplateLegacy("johnny_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> JOHNNY_PANTS = registerLeggingsLegacy("johnny_pants", ArmorItem::new);
    CosplayItem<ArmorItem> JOHNNY_BOOTS = registerBootsLegacy("johnny_boots", ArmorItem::new);

    CosplayItem<FlutteringArmorItem> GYRO_HAT = registerHelmetLegacy("gyro_hat", FlutteringArmorItem::new);
    CosplayItem<FlutteringArmorItem> GYRO_SHIRT = registerChestplateLegacy("gyro_shirt", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> GYRO_PANTS = registerLeggingsLegacy("gyro_pants", ArmorItem::new);
    CosplayItem<ArmorItem> GYRO_BOOTS = registerBootsLegacy("gyro_boots", ArmorItem::new);

    CosplayItem<ArmorItem> DIEGO_HAT = registerVampireHatLegacy("diego_hat", ArmorItem::new);
    CosplayItem<ArmorItem> DIEGO_SHIRT = registerChestplateLegacy("diego_shirt", ArmorItem::new);
    CosplayItem<ArmorItem> DIEGO_PANTS = registerLeggingsLegacy("diego_pants", ArmorItem::new);
    CosplayItem<ArmorItem> DIEGO_BOOTS = registerBootsLegacy("diego_boots", ArmorItem::new);

    CosplayItem<ArmorItem> MOUNTAIN_TIM_HAT = registerVampireHat("mountain_tim_hat", ArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_SHIRT = registerChestplate("mountain_tim_shirt", ArmorItem::new);
    CosplayItem<FlutteringArmorItem> MOUNTAIN_TIM_COAT = registerChestplate("mountain_tim_coat", FlutteringArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_PANTS = registerLeggings("mountain_tim_pants", ArmorItem::new);
    CosplayItem<ArmorItem> MOUNTAIN_TIM_BOOTS = registerBoots("mountain_tim_boots", ArmorItem::new);

    CosplayItem<ArmorItem> RINGO_OUTFIT = registerLeggingsLegacy("ringo_outfit", ArmorItem::new);
    CosplayItem<ArmorItem> RINGO_BOOTS = registerBootsLegacy("ringo_boots", ArmorItem::new);

    CosplayItem<ArmorItem> COWBOY_HAT = registerVampireHat("cowboy_hat", ArmorItem::new);
    CosplayItem<ArmorItem> COWBOY_PONCHO = registerChestplate("cowboy_poncho", ArmorItem::new);
    CosplayItem<ArmorItem> COWBOY_GUNBELT_SPURS = registerLeggings("cowboy_gunbelt_spurs", ArmorItem::new);

    CosplayItem<ArmorItem> VALENTINE_WIG = registerHelmetLegacy("valentine_wig", ArmorItem::new);
    CosplayItem<ArmorItem> VALENTINE_JACKET = registerChestplateLegacy("valentine_jacket", ArmorItem::new);
    CosplayItem<ArmorItem> VALENTINE_PANTS = registerLeggingsLegacy("valentine_pants", ArmorItem::new);
    CosplayItem<ArmorItem> VALENTINE_BOOTS = registerBootsLegacy("valentine_boots", ArmorItem::new);

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
