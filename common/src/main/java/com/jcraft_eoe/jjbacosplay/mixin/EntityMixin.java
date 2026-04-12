package com.jcraft_eoe.jjbacosplay.mixin;

import com.jcraft_eoe.jjbacosplay.mixin_logic.Jangler;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Entity.class)
public abstract class EntityMixin implements Jangler {

    @Shadow
    public int tickCount;
    @Unique
    private int jjbacosplay$lastJangle = 0;

    @Override
    public int jjbacosplay$getLastJangleAge() {
        return jjbacosplay$lastJangle;
    }

    @Override
    public void jjbacosplay$markJangle() {
        jjbacosplay$lastJangle = tickCount;
    }
}
