package com.jcraft_eoe.jjbacosplay.command;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCTagRegistry;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.architectury.registry.registries.RegistrySupplier;
import mod.azure.azurelib.AzureLib;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OutfitCommand {

    private static final Map<Integer, ArmorItem.Type> SLOTS =
        Map.of(3, ArmorItem.Type.HELMET, 2, ArmorItem.Type.CHESTPLATE, 1, ArmorItem.Type.LEGGINGS, 0, ArmorItem.Type.BOOTS);

    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jjbacosplay")
                .then(Commands.literal("outfit")
                        .requires(source -> source.hasPermission(2))
                        .then(Commands.argument("entities", EntityArgument.entities())
                                .then(Commands.literal("random")
                                    .executes(OutfitCommand::run)
                                )
                        )
                )
        );
    }

    public static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final Collection<? extends Entity> entities = EntityArgument.getEntities(ctx, "entities");
        final List<LivingEntity> livings = entities.stream()
                .filter(e -> e instanceof LivingEntity
                        && (e.getType().is(JCTagRegistry.CAN_WEAR_COSPLAY) || e instanceof Player))
                .map(LivingEntity.class::cast)
                .toList();
        final RandomSource random = ctx.getSource() != null ? ctx.getSource().getLevel().getRandom() : RandomSource.createNewThreadLocalInstance();
        final List<CosplayItem<?>> cosplays = CosplayItem.all();
        for (final LivingEntity living : livings) {
            final NonNullList<ItemStack> armorItems = (NonNullList<ItemStack>)living.getArmorSlots();
            for (int slot = 0; slot < 4; slot++) {
                while (armorItems.get(slot).isEmpty()) {
                    final CosplayItem<?> cosplayItem = cosplays.get(random.nextInt(cosplays.size()));
                    if (cosplayItem.getSlot() == SLOTS.get(slot)) {
                        final List<? extends ArmorItem> pieces = cosplayItem.getAll().stream()
                                .map(RegistrySupplier::get)
                                .toList();
                        final ItemStack stack = new ItemStack(pieces.get(random.nextInt(pieces.size())));
                        final CompoundTag tag = stack.getOrCreateTag();
                        tag.putUUID(AzureLib.ITEM_UUID_TAG, UUID.randomUUID());
                        stack.setTag(tag);
                        armorItems.set(slot, stack);
                    }
                }
            }
        }
        return 1;
    }

}
