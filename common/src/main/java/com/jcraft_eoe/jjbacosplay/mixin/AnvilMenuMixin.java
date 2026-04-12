package com.jcraft_eoe.jjbacosplay.mixin;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin  extends ItemCombinerMenu {

    @Shadow
    @Final
    private DataSlot cost;
    @Shadow private String itemName;

    private AnvilMenuMixin(@Nullable MenuType<?> type, int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(type, containerId, playerInventory, access);
    }

    @Inject(method = "createResult()V", at = @At("RETURN"))
    private void jjbacosplay$injectAnvil(final CallbackInfo ci) {
        ItemStack item1 = inputSlots.getItem(0);
        ItemStack item2 = inputSlots.getItem(1);
        if (item1.is(JCTagRegistry.COSPLAY) || item2.is(JCTagRegistry.COSPLAY)) {
            jjbacosplay$upgradeCosplay(item1, item2);
        }
    }

    @Unique
    private void jjbacosplay$upgradeCosplay(final ItemStack item1, final ItemStack item2) {
        // both items must be armor
        if (!(item1.getItem() instanceof final ArmorItem armor1) || !(item2.getItem() instanceof final ArmorItem armor2)) {
            return;
        }
        // the slot must be the same
        if (armor1.getType() != armor2.getType()) {
            return;
        }
        // if the items are the same, the anvil should already have calculated a result
        // if they are of the same tier only, no change should be possible
        if (armor1.getMaterial() == armor2.getMaterial()) {
            return;
        }
        final ItemStack cosplay;
        final ItemStack upgrade;
        // left side takes precedence if both are cosplay
        if (!item1.is(JCTagRegistry.COSPLAY)) {
            cosplay = item2;
            upgrade = item1;
        }
        else {
            cosplay = item1;
            upgrade = item2;
        }
        final ArmorMaterial upgradeTier = ((ArmorItem)upgrade.getItem()).getMaterial();
        final CosplayItem<?> cosplayItem = CosplayItem.find(cosplay.getItem());
        if (cosplayItem == null) { // shouldn't happen because of the selection in jcraft$injectAnvil
            return;
        }
        final RegistrySupplier<? extends ArmorItem> upgradeItem = cosplayItem.get(upgradeTier);
        if (upgradeItem == null) { // means we have no cosplay item tier for the material
            return;
        }
        final ItemStack result = new ItemStack(upgradeItem.get());
        int c = 0;
        // this is not cosplay/upgrade but item1/item2 on purpose!!
        final var baseEnchantments = EnchantmentHelper.getEnchantments(item1);
        final var upgradeEnchantments = EnchantmentHelper.getEnchantments(item2);
        // calculate result enchantments
        final var resultEnchantments = EnchantmentHelper.getEnchantments(result);
        for (final Enchantment upgradeEnchantment : upgradeEnchantments.keySet()) {
            // don't copy incompatible unless in creative
            if (!player.getAbilities().instabuild) {
                boolean skip = false;
                for (final Enchantment baseEnchantment : baseEnchantments.keySet()) {
                    if (baseEnchantment != upgradeEnchantment && !upgradeEnchantment.isCompatibleWith(baseEnchantment)) {
                        skip = true;
                        break;
                    }
                }
                if (skip) {
                    continue;
                }
            }
            final int baseLevel = baseEnchantments.getOrDefault(upgradeEnchantment, 0);
            final int upgradeLevel = upgradeEnchantments.get(upgradeEnchantment);
            int resultLevel = baseLevel == upgradeLevel ? upgradeLevel + 1 : Math.max(baseLevel, upgradeLevel);
            if (resultLevel > upgradeEnchantment.getMaxLevel()) {
                resultLevel = upgradeEnchantment.getMaxLevel();
            }
            resultEnchantments.put(upgradeEnchantment, resultLevel);
        }
        // copy remaining base enchantments
        for (final var baseEntry : baseEnchantments.entrySet()) {
            if (!upgradeEnchantments.containsKey(baseEntry.getKey())) {
                resultEnchantments.put(baseEntry.getKey(), baseEntry.getValue());
            }
        }
        // increase cost for name changes
        if (itemName != null && !Util.isBlank(itemName)) {
            if (!itemName.equals(item1.getHoverName().getString())) {
                c += 1;
                result.setHoverName(Component.literal(this.itemName));
            }
        } else if (item1.hasCustomHoverName()) {
            c += 1;
        }
        // finalize product
        resultSlots.setItem(0, result);
        cost.set(1);
        // cost.set(c);
    }
}
