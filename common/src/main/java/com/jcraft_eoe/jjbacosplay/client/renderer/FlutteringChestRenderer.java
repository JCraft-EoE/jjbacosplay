package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.function.Supplier;

/**
 * Renders chest + arms + head on the chest with fluttering armor animator.
 */
public class FlutteringChestRenderer extends ArmorRenderer {

    public FlutteringChestRenderer(final String id) {
        super(() -> new FlutteringArmorAnimator(id), new ExtendedChestBoneContext(), id);
    }

    protected static class ExtendedChestBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);
            if (currentSlot == EquipmentSlot.CHEST) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftLeg, true);
                setBoneVisible(this.rightLeg, true);
                setBoneVisible(this.leftArm, true);
                setBoneVisible(this.rightArm, true);
                setBoneVisible(this.head, true);
            }
        }
    }

    public static Supplier<AzArmorRenderer> of (final String id) {
        return () -> new FlutteringChestRenderer(id);
    }
}
