package com.jcraft_eoe.jjbacosplay;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

import java.util.function.Consumer;

public final class JCLootTableHelper {
    public static final Multimap<ResourceLocation, Consumer<LootTable.Builder>> modifications = MultimapBuilder.hashKeys().linkedHashSetValues().build();

    private JCLootTableHelper() {
        /* No instantiation */
    }

    public static void registerMusicDiscLootTables() {
        // Leather Cosplay: Villages
        registerModification(JCLootTableHelper::addLeatherCosplay,
                new ResourceLocation("chests/village/village_tannery")
        );

        // Iron and Chainmail Cosplay: Blacksmith, Strongholds, Dungeons
        registerModification(JCLootTableHelper::addIronCosplay,
                new ResourceLocation("chests/village/village_armorer"),
                new ResourceLocation("chests/stronghold_corridor"),
                new ResourceLocation("chests/stronghold_crossing"),
                new ResourceLocation("chests/simple_dungeon")
        );

        // Gold Cosplay: Ruined Portals, Bastions
        registerModification(JCLootTableHelper::addGoldCosplay,
                new ResourceLocation("chests/ruined_portal"),
                new ResourceLocation("chests/bastion_bridge"),
                new ResourceLocation("chests/bastion_other")
        );

        // Diamond Cosplay: Ancient Cities and End Cities
        registerModification(JCLootTableHelper::addDiamondCosplay,
                new ResourceLocation("chests/ancient_city"),
                new ResourceLocation("chests/end_city_treasure")
        );
    }

    private static void addLeatherCosplay(LootTable.Builder builder) {
        var lootPool = LootPool.lootPool();
        for (CosplayItem<?> cosplayItem : CosplayItem.all()) {
            final var item = cosplayItem.get(ArmorMaterials.LEATHER);
            if (item != null) {
                lootPool.add(LootItem.lootTableItem(item.get()));
            }
        }
        builder.withPool(lootPool.when(LootItemRandomChanceCondition.randomChance(0.05f)));
    }

    private static void addIronCosplay(LootTable.Builder builder) {
        var lootPool = LootPool.lootPool();
        for (CosplayItem<?> cosplayItem : CosplayItem.all()) {
            var item = cosplayItem.get(ArmorMaterials.IRON);
            if (item != null) {
                lootPool.add(LootItem.lootTableItem(item.get()));
            }
            item = cosplayItem.get(ArmorMaterials.CHAIN);
            if (item != null) {
                lootPool.add(LootItem.lootTableItem(item.get()));
            }
        }
        builder.withPool(lootPool.when(LootItemRandomChanceCondition.randomChance(0.05f)));
    }

    private static void addGoldCosplay(LootTable.Builder builder) {
        var lootPool = LootPool.lootPool();
        for (CosplayItem<?> cosplayItem : CosplayItem.all()) {
            final var item = cosplayItem.get(ArmorMaterials.GOLD);
            if (item != null) {
                lootPool.add(LootItem.lootTableItem(item.get()));
            }
        }
        builder.withPool(lootPool.when(LootItemRandomChanceCondition.randomChance(0.05f)));
    }

    private static void addDiamondCosplay(LootTable.Builder builder) {
        var lootPool = LootPool.lootPool();
        for (CosplayItem<?> cosplayItem : CosplayItem.all()) {
            final var item = cosplayItem.get(ArmorMaterials.DIAMOND);
            if (item != null) {
                lootPool.add(LootItem.lootTableItem(item.get()));
            }
        }
        builder.withPool(lootPool.when(LootItemRandomChanceCondition.randomChance(0.05f)));
    }

    public static void registerModification(Consumer<LootTable.Builder> modifier, ResourceLocation... lootTables) {
        for (ResourceLocation lootTable : lootTables) {
            modifications.put(lootTable, modifier);
        }
    }
    
}
