package com.jcraft_eoe.jjbacosplay.client.renderer;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import net.minecraft.resources.ResourceLocation;

//renders coat
public class KosakuJacketRenderer extends ArmorRenderer{
    public static final String ID = "kosakujacket";
    public static final ResourceLocation MODEL = JjbaCosplay.id(MODEL_STR_TEMPLATE.formatted("kirajacket"));
    public static final ResourceLocation TEXTURE = JjbaCosplay.id(TEXTURE_STR_TEMPLATE.formatted(ID));

    public KosakuJacketRenderer() {
        super(() -> new FlutteringArmorAnimator(ID), MODEL, TEXTURE);
    }
}
