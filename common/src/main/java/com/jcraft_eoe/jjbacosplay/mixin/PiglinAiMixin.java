package com.jcraft_eoe.jjbacosplay.mixin;

import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public abstract class PiglinAiMixin {

    @Inject(method = "isWearingGold(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("RETURN"), cancellable = true)
    private static void jjbacosplay$piglinsRecognizeGoldDrip(final LivingEntity livingEntity, final CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValueZ()) {
            return;
        }
        for (final ItemStack armor : livingEntity.getArmorSlots()) {
            if (armor.is(JCTagRegistry.COSPLAY) && armor.getItem() instanceof ArmorItem armorItem && armorItem.getMaterial() == ArmorMaterials.GOLD) {
                cir.setReturnValue(true);
                return;
            }
        }
    }

}
