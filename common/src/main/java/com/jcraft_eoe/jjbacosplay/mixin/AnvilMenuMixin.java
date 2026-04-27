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
import net.minecraft.world.item.EnchantedBookItem;
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

import static net.minecraft.world.inventory.AnvilMenu.calculateIncreasedRepairCost;

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
        if (item1.is(JCTagRegistry.COSPLAY)) {
            jjbacosplay$upgradeCosplay(item1, item2);
        }
    }

    @Unique
    private void jjbacosplay$upgradeCosplay(final ItemStack item1, final ItemStack item2) {
        // both items must be armor
        if (!(item1.getItem() instanceof final ArmorItem armor1)) {
            return;
        }
        ItemStack result = null;
        int c = 1; // short for cost
        int customNameCost = 0;
        final var resultEnchantments = EnchantmentHelper.getEnchantments(item1);
        if (item2.getItem() instanceof EnchantedBookItem) { // anvil should have taken care of this one
            return;
        }
        if (item1.isDamageableItem() && item1.getItem().isValidRepairItem(item1, item2)) { // this one as well
            return;
        }
        if (item2.getItem() instanceof ArmorItem armor2) {
            // the slot must be the same
            if (armor1.getType() != armor2.getType()) {
                return;
            }
            // if the items are the same, the anvil should already have calculated a result
            // if they are of the same tier only, no change should be needed
            if (armor1.getMaterial() == armor2.getMaterial()) {
                return;
            }
            final CosplayItem<?> cosplayItem = CosplayItem.find(armor1);
            if (cosplayItem == null) { // shouldn't happen because of the selection in jcraft$injectAnvil
                return;
            }
            final CosplayItem<?> cosplayItem2 = CosplayItem.find(armor2);
            if (cosplayItem2 != null && cosplayItem != cosplayItem2) { // don't combine different kinds of cosplay
                return;
            }
            final ArmorMaterial upgradeTier = armor2.getMaterial();
            final RegistrySupplier<? extends ArmorItem> upgradeItem = cosplayItem.get(upgradeTier);
            if (upgradeItem == null) { // means we have no cosplay item tier for the material
                return;
            }
            result = new ItemStack(upgradeItem.get());
            result.setDamageValue(item1.getDamageValue());
            // calculation stuff from vanilla if there is durability combination
            {
                int l = item1.getMaxDamage() - item1.getDamageValue();
                int m = item2.getMaxDamage() - item2.getDamageValue();
                int n = m + item1.getMaxDamage() * 12 / 100;
                int o = l + n;
                int p = item1.getMaxDamage() - o;
                if (p < 0) {
                    p = 0;
                }

                if (p < result.getDamageValue()) {
                    result.setDamageValue(p);
                    c += 2;
                }
            }
            final var baseEnchantments = EnchantmentHelper.getEnchantments(item1);
            final var upgradeEnchantments = EnchantmentHelper.getEnchantments(item2);
            // calculate result enchantments
            for (final Enchantment baseEnchantment : baseEnchantments.keySet()) {
                // don't copy incompatible unless in creative
                if (!player.getAbilities().instabuild) {
                    boolean skip = false;
                    for (final Enchantment upgradeEnchantment : upgradeEnchantments.keySet()) {
                        if (baseEnchantment != upgradeEnchantment && !upgradeEnchantment.isCompatibleWith(baseEnchantment)) {
                            skip = true;
                            ++c;
                        }
                        if (!skip) {
                            final int baseLevel = baseEnchantments.getOrDefault(upgradeEnchantment, 0);
                            final int upgradeLevel = upgradeEnchantments.get(upgradeEnchantment);
                            int resultLevel = baseLevel == upgradeLevel ? upgradeLevel + 1 : Math.max(baseLevel, upgradeLevel);
                            if (resultLevel > upgradeEnchantment.getMaxLevel()) {
                                resultLevel = upgradeEnchantment.getMaxLevel();
                            }
                            resultEnchantments.put(upgradeEnchantment, resultLevel);

                            int s = 0;
                            switch (upgradeEnchantment.getRarity()) {
                                case COMMON -> s = 1;
                                case UNCOMMON -> s = 2;
                                case RARE -> s = 4;
                                case VERY_RARE -> s = 8;
                            }
                            c += s * resultLevel;
                        }
                    }
                }
            }
            // increase cost for name changes
            if (itemName != null && !Util.isBlank(itemName)) {
                if (!itemName.equals(item1.getHoverName().getString())) {
                    customNameCost = 1;
                    c += customNameCost;
                    result.setHoverName(Component.literal(this.itemName));
                }
            } else if (item1.hasCustomHoverName()) {
                customNameCost = 1;
                c += customNameCost;
                result.resetHoverName();
            }
        }
        // finalize product
        cost.set(c);
        if (c <= 0) {
            result = ItemStack.EMPTY;
        }

        if (customNameCost == c && customNameCost > 0 && this.cost.get() >= 40) {
            this.cost.set(39);
        }

        if (this.cost.get() >= 40 && !this.player.getAbilities().instabuild) {
            result = ItemStack.EMPTY;
        }

        if (result != null && !result.isEmpty()) {
            int t = item1.getBaseRepairCost();
            if (t < item2.getBaseRepairCost()) {
                t = item2.getBaseRepairCost();
            }

            if (customNameCost != c || customNameCost == 0) {
                t = calculateIncreasedRepairCost(t);
            }

            result.setRepairCost(t);
            EnchantmentHelper.setEnchantments(resultEnchantments, result);
            resultSlots.setItem(0, result);
            broadcastChanges();
        }
    }
}
