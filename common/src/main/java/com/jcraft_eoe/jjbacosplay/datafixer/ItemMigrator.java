package com.jcraft_eoe.jjbacosplay.datafixer;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Records and applies the namespace migration for cosplay items that used to live in the {@code jcraft:}
 * namespace but now live in the {@code jjbacosplay:} namespace.
 *
 * <p>Historically, this mod was bundled inside JCraft, and the (netherite) cosplay items were registered
 * under the {@code jcraft:} namespace. After the split into a standalone mod those items moved to
 * {@code jjbacosplay:}. To keep existing player worlds working without dual-registering everything, this
 * class drives a small "data fixer" that rewrites old IDs at load time.</p>
 *
 * <p>Two complementary mechanisms consume this list:
 * <ul>
 *     <li>A common mixin into {@code ItemStack.of(CompoundTag)} rewrites the stored {@code id} string
 *         on any NBT-loaded ItemStack. This covers player inventories, chests, item entities, item
 *         frames, ender chests, etc., on both Fabric and Forge.</li>
 *     <li>On Forge, the {@code MissingMappingsEvent} fires for any {@code jcraft:} items referenced in
 *         the level's registry snapshot. The Forge integration uses {@link #remap(ResourceLocation)}
 *         to resolve those references to their new {@code jjbacosplay:} counterparts.</li>
 * </ul></p>
 *
 * <p>Names are recorded by {@link com.jcraft_eoe.jjbacosplay.CosplayItem} when it processes a
 * {@code register*Legacy} call, so this list stays in lockstep with the real registry without needing
 * a separately maintained mapping table.</p>
 */
public final class ItemMigrator {

    /** The namespace items used to live in. */
    public static final String LEGACY_NAMESPACE = "jcraft";

    private static final Set<String> LEGACY_NAMES = new LinkedHashSet<>();

    private ItemMigrator() {
    }

    /**
     * Records {@code name} as having historically been registered under {@code jcraft:<name>}.
     * Called from {@link com.jcraft_eoe.jjbacosplay.CosplayItem#register} when the netherite variant
     * of a legacy item is registered.
     */
    public static void recordLegacyName(final String name) {
        LEGACY_NAMES.add(name);
    }

    /**
     * @return an unmodifiable view of every name that should be migrated from {@code jcraft:} to
     *         {@code jjbacosplay:}.
     */
    public static Set<String> legacyNames() {
        return Collections.unmodifiableSet(LEGACY_NAMES);
    }

    /**
     * @return {@code true} if {@code old} is {@code jcraft:<name>} where {@code <name>} was registered
     *         via a {@code *Legacy} helper.
     */
    public static boolean shouldRemap(final @Nullable ResourceLocation old) {
        return old != null
                && LEGACY_NAMESPACE.equals(old.getNamespace())
                && LEGACY_NAMES.contains(old.getPath());
    }

    /**
     * Returns the migrated ID for {@code old}, or {@code null} if {@code old} should not be migrated.
     */
    public static @Nullable ResourceLocation remap(final @Nullable ResourceLocation old) {
        if (!shouldRemap(old)) {
            return null;
        }
        return new ResourceLocation(JjbaCosplay.MOD_ID, old.getPath());
    }
}
