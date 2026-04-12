package com.jcraft_eoe.jjbacosplay;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

import java.util.function.Consumer;

public final class JCLootTableHelper {
    public static final Multimap<ResourceLocation, Consumer<LootTable.Builder>> modifications = MultimapBuilder.hashKeys().linkedHashSetValues().build();

    private JCLootTableHelper() {
        /* No instantiation */
    }

    public static void registerMusicDiscLootTables() {
        // Openings: Desert/Jungle Temples (pyramids)
        registerModification(JCLootTableHelper::addOpeningDiscs,
                new ResourceLocation("chests/desert_pyramid"),
                new ResourceLocation("chests/jungle_temple")
        );

        // JoJo's OST: Dungeons
        registerModification(JCLootTableHelper::addOSTDiscs,
                new ResourceLocation("chests/simple_dungeon")
        );

        // Endings: Ancient Cities and End Cities
        registerModification(JCLootTableHelper::addEndingDiscs,
                new ResourceLocation("chests/ancient_city"),
                new ResourceLocation("chests/end_city_treasure")
        );
    }

    // Openings: Desert Pyramids & Jungle Temples
    private static void addOpeningDiscs(LootTable.Builder builder) {
        builder.withPool(LootPool.lootPool()
//                .add(LootItem.lootTableItem(JMItemRegistry.DISC_SONO_CHI_NO_SADAME.get()).setWeight(1))
                .when(LootItemRandomChanceCondition.randomChance(0.25f))
        );
    }

    // JoJo's OST: Dungeons
    private static void addOSTDiscs(LootTable.Builder builder) {
        builder.withPool(LootPool.lootPool()
//                .add(LootItem.lootTableItem(JMItemRegistry.DISC_AWAKEN.get()).setWeight(1))
                .when(LootItemRandomChanceCondition.randomChance(0.25f))
        );
    }

    // Endings: Ancient Cities & End Cities
    private static void addEndingDiscs(LootTable.Builder builder) {
        builder.withPool(LootPool.lootPool()
//                .add(LootItem.lootTableItem(JMItemRegistry.DISC_TO_BE_CONTINUED.get()).setWeight(1))
                .when(LootItemRandomChanceCondition.randomChance(0.25f))
        );
    }

    public static void registerModification(Consumer<LootTable.Builder> modifier, ResourceLocation... lootTables) {
        for (ResourceLocation lootTable : lootTables) {
            modifications.put(lootTable, modifier);
        }
    }
    
}
