package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

//renders leotard and boots
public class FugoPantsRenderer extends ArmorRenderer {

    public static final String ID = "fugooutfit";

    public FugoPantsRenderer() {
        super(() -> new ArmorAnimator(ID), new FugoPantsBoneContext(), ID);
    }

    protected static class FugoPantsBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);

            if (currentSlot == EquipmentSlot.LEGS) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftLeg, true);
                setBoneVisible(this.rightLeg, true);
            }
        }
    }
}
