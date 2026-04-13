package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

//renders leotard and boots
public class FugoShoesRenderer extends ArmorRenderer {

    public static final String ID = "fugoextras";

    public FugoShoesRenderer() {
        super(() -> new ArmorAnimator(ID), new FugoShoesBoneContext(), ID);
    }

    protected static class FugoShoesBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);

            if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftBoot, true);
                setBoneVisible(this.rightBoot, true);
            }
        }
    }
}
