package com.jcraft_eoe.jjbacosplay.client.renderer;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.bone.AzArmorBoneContext;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.function.Supplier;

/**
 * Renders head + chest on the head.
 */
public class ExtendedHeadRenderer extends ArmorRenderer {

    public ExtendedHeadRenderer(final String id) {
        super(() -> new ArmorAnimator(id), new ExtendedHeadBoneContext(), id);
    }

    protected static class ExtendedHeadBoneContext extends AzArmorBoneContext {
        public void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
            setAllVisible(false);
            if (currentSlot == EquipmentSlot.HEAD) {
                setBoneVisible(this.head, true);
                setBoneVisible(this.body, true);
            }
        }
    }

    public static Supplier<AzArmorRenderer> of(final String id) {
        return () -> new ExtendedHeadRenderer(id);
    }

}
