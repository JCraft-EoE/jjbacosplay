package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

// renders wig
public class AvdolOutfitRenderer extends ArmorRenderer {

    public static final String ID = "avdoloutfit";

    public AvdolOutfitRenderer() {
        super(() -> new ArmorAnimator(ID), new AvdolOutfitBoneContext(), ID);
    }

    protected static class AvdolOutfitBoneContext extends AzArmorBoneContext {
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

}
