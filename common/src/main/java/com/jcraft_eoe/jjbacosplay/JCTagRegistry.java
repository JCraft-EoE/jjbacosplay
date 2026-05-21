package com.jcraft_eoe.jjbacosplay;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public interface JCTagRegistry {

    TagKey<Item> EQUIPABLES = TagKey.create(Registries.ITEM, new ResourceLocation("c", "equipables"));
    TagKey<Item> PROTECTS_FROM_SUN = TagKey.create(Registries.ITEM, new ResourceLocation("jcraft", "protects_from_sun"));
    TagKey<Item> BLINDS_ON_IMPACT = TagKey.create(Registries.ITEM, new ResourceLocation("jcraft", "blinds_on_impact"));

    TagKey<Item> COSPLAY = TagKey.create(Registries.ITEM, JjbaCosplay.id("cosplay"));
    TagKey<Item> BOOTS_WITH_THE_SPURS = TagKey.create(Registries.ITEM, JjbaCosplay.id("has_spurs"));

    TagKey<EntityType<?>> CAN_WEAR_COSPLAY = TagKey.create(Registries.ENTITY_TYPE, JjbaCosplay.id("can_wear_cosplay"));

}
