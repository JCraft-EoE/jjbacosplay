package com.jcraft_eoe.jjbacosplay.client.renderer;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;

public class KiraArmorRenderer extends ArmorRenderer {
    public static final String ID = "kiraoutfit";
    public static final ResourceLocation MODEL = JjbaCosplay.id(MODEL_STR_TEMPLATE.formatted(ID));
    public static final ResourceLocation TEXTURE = JjbaCosplay.id(TEXTURE_STR_TEMPLATE.formatted(ID));

    public KiraArmorRenderer() {
        super(() -> new ArmorAnimator(ID), new KiraArmorBoneContext(), MODEL, TEXTURE);
    }

    public static class KiraArmorBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);

            if (currentSlot == EquipmentSlot.LEGS) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftLeg, true);
                setBoneVisible(this.rightLeg, true);
                setBoneVisible(this.leftArm, true);
                setBoneVisible(this.rightArm, true);
            }
            else if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.leftBoot, true);
                setBoneVisible(this.rightBoot, true);
            }
            else if (currentSlot == EquipmentSlot.HEAD) {
                setBoneVisible(this.head, true);
            }
        }
    }
}
