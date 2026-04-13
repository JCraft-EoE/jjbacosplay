package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

// renders wig, pants and boots
public class OkuyasuOutfitRenderer extends ArmorRenderer {

    public static final String ID = "okuyasuoutfit";

    public OkuyasuOutfitRenderer() {
        super(() -> new ArmorAnimator(ID), new OkuyasuOutfitBoneContext(), ID);
    }

    protected static class OkuyasuOutfitBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);

            if (currentSlot == EquipmentSlot.LEGS) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftLeg, true);
                setBoneVisible(this.rightLeg, true);
            } else if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.leftBoot, true);
                setBoneVisible(this.rightBoot, true);
            } else if (currentSlot == EquipmentSlot.HEAD) {
                setBoneVisible(this.head, true);
            }
        }
    }

}
