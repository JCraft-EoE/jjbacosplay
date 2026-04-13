package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

// renders wig
public class AvdolWigRenderer extends ArmorRenderer {

    public static final String ID = "avdolwig";

    public AvdolWigRenderer() {
        super(() -> new ArmorAnimator(ID), new AvdolWigBoneContext(), ID);
    }

    protected static class AvdolWigBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);

            if (currentSlot == EquipmentSlot.HEAD) {
                setBoneVisible(this.head, true);
                setBoneVisible(this.body, true);
            }
        }
    }

}
