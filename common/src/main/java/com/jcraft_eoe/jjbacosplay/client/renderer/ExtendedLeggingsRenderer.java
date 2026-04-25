package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.function.Supplier;

/**
 * Renders legs + chest + arms on the legs.
 */
public class ExtendedLeggingsRenderer extends ArmorRenderer {

    public ExtendedLeggingsRenderer(final String id) {
        super(() -> new ArmorAnimator(id), new ExtendedLeggingsBoneContext(), id);
    }

    protected static class ExtendedLeggingsBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);
            if (currentSlot == EquipmentSlot.LEGS) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftArm, true);
                setBoneVisible(this.rightArm, true);
                setBoneVisible(this.leftLeg, true);
                setBoneVisible(this.rightLeg, true);
            }
        }
    }

    public static Supplier<AzArmorRenderer> of(final String id) {
        return () -> new ExtendedLeggingsRenderer(id);
    }

}
