package com.jcraft_eoe.jjbacosplay.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mod.azure.azurelib.AzureLib;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.UUID;

@Mixin(ArmorStand.class)
public abstract class ArmorStandMixin {

    @WrapOperation(method = "swapItem(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/EquipmentSlot;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/InteractionHand;)Z",
        at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/item/ItemStack;copyWithCount(I)Lnet/minecraft/world/item/ItemStack;",
        ordinal = 0))
    public ItemStack jcraft$doNotCopyAzureLibUuid(final ItemStack instance, final int i, final Operation<ItemStack> original) {
        final ItemStack copy = original.call(instance, i);
        if (copy.isEmpty()) {
            return copy;
        }
        final CompoundTag tag = copy.getTag();
        if (tag == null || !tag.contains(AzureLib.ITEM_UUID_TAG)) {
            return copy;
        }
        tag.putUUID(AzureLib.ITEM_UUID_TAG, UUID.randomUUID());
        return copy;
    }

}
