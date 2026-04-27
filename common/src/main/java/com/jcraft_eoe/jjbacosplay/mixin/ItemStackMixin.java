package com.jcraft_eoe.jjbacosplay.mixin;

import com.jcraft_eoe.jjbacosplay.datafixer.ItemMigrator;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Acts as the runtime "data fixer" for cosplay items that used to live under the {@code jcraft:}
 * namespace. Every NBT-loaded {@link ItemStack} (player inventories, chests, item entities, item
 * frames, ender chests, ...) flows through {@link ItemStack#of(CompoundTag)}, so rewriting the stored
 * {@code id} string here covers all storage locations on both Fabric and Forge without needing a
 * proper Mojang DataFixerUpper schema (which Fabric has no first-party support for in 1.20.1).
 *
 * <p>The set of names eligible for migration is populated by
 * {@link com.jcraft_eoe.jjbacosplay.CosplayItem} as legacy items register, so this mixin stays in
 * sync with the registry without a separately maintained mapping table.</p>
 */
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "of(Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/world/item/ItemStack;", at = @At("HEAD"))
    private static void jjbacosplay$migrateLegacyNamespace(final CompoundTag tag, final CallbackInfoReturnable<ItemStack> cir) {
        if (tag == null || !tag.contains("id", Tag.TAG_STRING)) {
            return;
        }
        final String rawId = tag.getString("id");
        // Cheap fast-path: skip the parse for anything that isn't even in the legacy namespace.
        if (!rawId.startsWith(ItemMigrator.LEGACY_NAMESPACE + ":")) {
            return;
        }
        final ResourceLocation oldId = ResourceLocation.tryParse(rawId);
        final ResourceLocation newId = ItemMigrator.remap(oldId);
        if (newId != null) {
            tag.putString("id", newId.toString());
        }
    }
}
