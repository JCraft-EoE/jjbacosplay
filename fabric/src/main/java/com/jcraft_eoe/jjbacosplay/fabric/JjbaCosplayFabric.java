package com.jcraft_eoe.jjbacosplay.fabric;

import com.jcraft_eoe.jjbacosplay.JCLootTableHelper;
import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.Consumer;

public final class JjbaCosplayFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        JjbaCosplay.init();
        // modify loot tables
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (Consumer<LootTable.Builder> modification : JCLootTableHelper.modifications.get(id)) {
                modification.accept(tableBuilder);
            }
        });

        JjbaCosplay.postInit();
    }
}
