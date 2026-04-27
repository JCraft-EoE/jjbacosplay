package com.jcraft_eoe.jjbacosplay.forge.datafixer;

import com.jcraft_eoe.jjbacosplay.datafixer.ItemMigrator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.MissingMappingsEvent;

/**
 * Forge-side companion to {@link com.jcraft_eoe.jjbacosplay.mixin.ItemStackMixin}. The mixin handles
 * any cosplay item references stored as raw NBT in inventories, chests, item entities, etc., but
 * Forge also writes a registry snapshot into {@code level.dat}; references to {@code jcraft:} items
 * in that snapshot trigger Forge's "Missing Registry Entries" warning unless we explicitly remap
 * them. This handler resolves each {@code jcraft:<name>} listed by {@link ItemMigrator} to the
 * corresponding {@code jjbacosplay:<name>} item.
 */
public final class JCForgeMissingMappings {

    private JCForgeMissingMappings() {
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.addListener(JCForgeMissingMappings::onMissingMappings);
    }

    @SuppressWarnings("deprecation")
    private static void onMissingMappings(final MissingMappingsEvent event) {
        for (final var mapping : event.getMappings(Registries.ITEM, ItemMigrator.LEGACY_NAMESPACE)) {
            final ResourceLocation oldId = mapping.getKey();
            final ResourceLocation newId = ItemMigrator.remap(oldId);
            if (newId == null || !BuiltInRegistries.ITEM.containsKey(newId)) {
                continue;
            }

            final Item replacement = BuiltInRegistries.ITEM.get(newId);
            mapping.remap(replacement);
        }
    }
}
