package com.jcraft_eoe.jjbacosplay.item;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import mod.azure.azurelib.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * {@link ArmorItem} animated by GeckoLib to flutter when its wearer is moving.
 */
public class FlutteringArmorItem extends ArmorItem {

    protected static final AzCommand IDLE_CMD = AzCommand.create(JjbaCosplay.BASE_CONTROLLER, "animation.idle", AzPlayBehaviors.LOOP);
    protected static final AzCommand MOVING_CMD = AzCommand.create(JjbaCosplay.BASE_CONTROLLER, "animation.moving", AzPlayBehaviors.LOOP);

    public FlutteringArmorItem(ArmorMaterial materialIn, Type slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void inventoryTick(final @NotNull ItemStack stack, final @NotNull Level level, final @NotNull Entity entity, final int slotId, final boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (level.isClientSide()) {
            final boolean moving = entity.getDeltaMovement().horizontalDistanceSqr() > 0.01;
            if (moving) {
                MOVING_CMD.sendForItem(entity, stack);
            }
            else {
                IDLE_CMD.sendForItem(entity, stack);
            }
        }
    }

}
