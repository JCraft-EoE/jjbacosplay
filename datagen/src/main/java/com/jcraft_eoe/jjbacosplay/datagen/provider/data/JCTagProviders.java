package com.jcraft_eoe.jjbacosplay.datagen.provider.data;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCItemRegistry;
import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import lombok.SneakyThrows;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;

import java.util.concurrent.CompletableFuture;

public interface JCTagProviders {

    class JMItemTags extends FabricTagProvider.ItemTagProvider {

        public JMItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            addCosplayTags();

            final var piglinLoved = getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED);

            final var cosplay = getOrCreateTagBuilder(JCTagRegistry.COSPLAY);
            for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
                cosplay.addTag(cosplayItem.getTag());
                if (cosplayItem.get(ArmorMaterials.GOLD) != null) {
                    piglinLoved.add(cosplayItem.get(ArmorMaterials.GOLD).get());
                }
            }

            final var spurs = getOrCreateTagBuilder(JCTagRegistry.BOOTS_WITH_THE_SPURS);
            spurs.addTag(JCItemRegistry.GYRO_BOOTS.getTag());
            spurs.addTag(JCItemRegistry.MOUNTAIN_TIM_BOOTS.getTag());
            spurs.addTag(JCItemRegistry.DIEGO_BOOTS.getTag());
            spurs.addTag(JCItemRegistry.COWBOY_GUNBELT_SPURS.getTag());

            // JCraft compatibility
            final var equipables = getOrCreateTagBuilder(JCTagRegistry.EQUIPABLES);
            equipables.addTag(JCTagRegistry.COSPLAY);

            final var blindsOnImpact = getOrCreateTagBuilder(JCTagRegistry.BLINDS_ON_IMPACT);
            blindsOnImpact.addTag(JCItemRegistry.DIO_CAPE.getTag());
            blindsOnImpact.addTag(JCItemRegistry.KARS_HEADWRAP.getTag());

        }

        @SneakyThrows
        protected void addCosplayTags() {
            final var cosplayTag = getOrCreateTagBuilder(JCTagRegistry.COSPLAY);
            final var protectsFromSunTag = getOrCreateTagBuilder(JCTagRegistry.PROTECTS_FROM_SUN);
            for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
                final var pieceTag = getOrCreateTagBuilder(cosplayItem.getTag());
                cosplayTag.addTag(cosplayItem.getTag());
                for (final RegistrySupplier<? extends ArmorItem> item : cosplayItem) {
                    pieceTag.add(item.get());
                    if (cosplayItem.isVampireProtection() && cosplayItem.getSlot() == ArmorItem.Type.HELMET) {
                        protectsFromSunTag.add(item.get());
                    }
                }
            }
        }

    }

    class JMEntityTags extends FabricTagProvider.EntityTypeTagProvider {

        public JMEntityTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(final HolderLookup.Provider provider) {
            final var canWearCosplay = getOrCreateTagBuilder(JCTagRegistry.CAN_WEAR_COSPLAY);
            canWearCosplay.add(EntityType.ARMOR_STAND)
                    .add(EntityType.ZOMBIE)
                    .add(EntityType.SKELETON)
                    .add(EntityType.ZOMBIE_VILLAGER)
                    .add(EntityType.PIGLIN)
                    .add(EntityType.ZOMBIFIED_PIGLIN);
        }
    }

}
