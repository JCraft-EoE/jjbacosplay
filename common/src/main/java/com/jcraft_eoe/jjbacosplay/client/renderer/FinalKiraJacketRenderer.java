package com.jcraft_eoe.jjbacosplay.client.renderer;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import net.minecraft.resources.ResourceLocation;

//renders coat
public class FinalKiraJacketRenderer extends ArmorRenderer {
    public static final String ID = "finalkirajacket";
    public static final ResourceLocation TEXTURE = JjbaCosplay.id(TEXTURE_STR_TEMPLATE.formatted(ID));

    public FinalKiraJacketRenderer() {
        super(() -> new ArmorRenderer.FlutteringArmorAnimator(ID), KosakuJacketRenderer.MODEL, TEXTURE);
    }
}
