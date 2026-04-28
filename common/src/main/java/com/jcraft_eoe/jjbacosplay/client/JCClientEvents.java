package com.jcraft_eoe.jjbacosplay.client;

import com.jcraft_eoe.jjbacosplay.JCSoundRegistry;
import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import com.jcraft_eoe.jjbacosplay.item.FlutteringArmorItem;
import com.jcraft_eoe.jjbacosplay.mixin_logic.Jangler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;

import java.util.List;

@Environment(EnvType.CLIENT)
public class JCClientEvents {

    public static void tickClient(Minecraft client) {
        // Play jangle sound (from spurs) for all entities
        playJangle();
        animateFlutteringArmor();
    }

    private static void playJangle() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        ClientLevel level = mc.level;
        SoundManager soundManager = mc.getSoundManager();
        if (player == null || level == null) return;

        List<Entity> entities = level.getEntities(player, AABB.ofSize(player.position(), 20, 20, 20),
                e -> e instanceof LivingEntity);
        if (!player.isCrouching()) entities.add(player);

        for (Entity entity : entities) {
            if (!entity.onGround() || !level.getBlockState(entity.blockPosition()).getFluidState().isEmpty()) {
                continue;
            }
            Jangler jangler = (Jangler) entity;

            for (ItemStack armorSlot : entity.getArmorSlots()) {
                if (!armorSlot.is(JCTagRegistry.BOOTS_WITH_THE_SPURS)) {
                    continue;
                }

                double speedMin    = 0.02,  speedMax    = 0.10;
                double intervalMin = 4,    intervalMax = 12;

                double dx = entity.xOld - entity.getX();
                double dy = entity.yOld - entity.getY();
                double dz = entity.zOld - entity.getZ();
                double speed = dx * dx + dy * dy + dz * dz;
                if (speed < speedMin) continue;

                double t     = (speed - speedMin) / (speedMax - speedMin);
                double delta = 1.0 - Mth.clamp(t, 0.0, 1.0);
                int interval = (int) Mth.lerp(delta, intervalMin, intervalMax);

                // Play jangle once every few tick, depending on their speed
                if (entity.tickCount - jangler.jjbacosplay$getLastJangleAge() < interval) {
                    continue;
                }

                // We found an armor piece that has spurs for an entity that is moving,
                // and we haven't played this sound in 5 ticks, play jangle sound.
                RandomSource random = player.getRandom();
                float volume = 1f - random.nextFloat() * 0.3f;
                float pitch = 1f - random.nextFloat() * 0.3f;

                SoundSource soundSource = entity.getSoundSource();
                SoundInstance sound = new SimpleSoundInstance(JCSoundRegistry.JANGLE.get(), soundSource, volume, pitch,
                        random, entity.getX(), entity.getY(), entity.getZ());
                soundManager.play(sound);
                jangler.jjbacosplay$markJangle();
                break;
            }
        }
    }

    private static void animateFlutteringArmor() {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        ClientLevel level = mc.level;
        if (player == null || level == null) {
            return;
        }

        List<Entity> entities = level.getEntities((Entity)null, AABB.ofSize(player.position(), 1_000, 1_000, 1_000),
                e -> e instanceof LivingEntity);

        for (Entity entity : entities) {
            for (ItemStack armorSlot : entity.getArmorSlots()) {
                if (armorSlot.getItem() instanceof FlutteringArmorItem) {
                    final boolean moving = entity == player
                            ? player.getDeltaMovement().horizontalDistanceSqr() > 0.01
                            : (entity.getX() - entity.xo)*(entity.getX() - entity.xo) + (entity.getY() - entity.yo)*(entity.getY() - entity.yo) + (entity.getZ() - entity.zo)*(entity.getZ() - entity.zo) > 0.01;
                    if (moving) {
                        FlutteringArmorItem.MOVING_CMD.sendForItem(entity, armorSlot);
                    }
                    else {
                        FlutteringArmorItem.IDLE_CMD.sendForItem(entity, armorSlot);
                    }
                }
            }
        }
    }

}
