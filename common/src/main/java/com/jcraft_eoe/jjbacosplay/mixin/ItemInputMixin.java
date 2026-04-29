package com.jcraft_eoe.jjbacosplay.mixin;

import mod.azure.azurelib.AzureLib;
import mod.azure.azurelib.animation.cache.AzIdentityRegistry;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(ItemInput.class)
public class ItemInputMixin {

    @Inject(method = "createItemStack(IZ)Lnet/minecraft/world/item/ItemStack;", at = @At("RETURN"), cancellable = true)
    public void jjbacosplay$ensureAzureLibUuid(final int i, final boolean bl, final CallbackInfoReturnable<ItemStack> cir) {
        final ItemStack stack = cir.getReturnValue();
        if (stack == null || stack.isEmpty() || !AzIdentityRegistry.hasIdentity(stack.getItem())) {
            return;
        }
        final CompoundTag tag = stack.getOrCreateTag();
        if (tag.contains(AzureLib.ITEM_UUID_TAG)) {
            return;
        }
        tag.putUUID(AzureLib.ITEM_UUID_TAG, UUID.randomUUID());
        stack.setTag(tag);
        cir.setReturnValue(stack);
    }

}
