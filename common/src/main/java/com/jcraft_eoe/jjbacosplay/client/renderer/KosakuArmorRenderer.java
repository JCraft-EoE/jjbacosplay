package com.jcraft_eoe.jjbacosplay.client.renderer;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import net.minecraft.resources.ResourceLocation;

public class KosakuArmorRenderer extends ArmorRenderer {

    public static final String ID = "kosakuoutfit";
    public static final ResourceLocation TEXTURE = JjbaCosplay.id(TEXTURE_STR_TEMPLATE.formatted(ID));

    public KosakuArmorRenderer() {
        super(() -> new ArmorAnimator(ID), new KiraArmorRenderer.KiraArmorBoneContext(), KiraArmorRenderer.MODEL, TEXTURE);
    }
}
