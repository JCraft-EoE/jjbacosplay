package com.jcraft_eoe.jjbacosplay.item;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

/**
 * {@link ArmorItem} animated by GeckoLib to flutter when its wearer is moving.
 */
public class FlutteringArmorItem extends ArmorItem {

    public static final AzCommand IDLE_CMD = AzCommand.create(JjbaCosplay.BASE_CONTROLLER, "animation.idle", AzPlayBehaviors.LOOP);
    public static final AzCommand MOVING_CMD = AzCommand.create(JjbaCosplay.BASE_CONTROLLER, "animation.moving", AzPlayBehaviors.LOOP);

    public FlutteringArmorItem(ArmorMaterial materialIn, Type slot, Properties builder) {
        super(materialIn, slot, builder);
    }

}
