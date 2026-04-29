package com.jcraft_eoe.jjbacosplay.command;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;

public class PresentCommand {

    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jjbacosplay")
                .then(Commands.literal("present")
                        .requires(source -> source.hasPermission(3))
                        .then(Commands.argument("start", BlockPosArgument.blockPos())
                            .executes(PresentCommand::run)
                        )
                )
        );
    }

    public static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final BlockPos.MutableBlockPos start = BlockPosArgument.getBlockPos(ctx, "start").mutable();
        final ServerLevel level = ctx.getSource().getLevel();
        for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
            final ArmorStand armorStand = EntityType.ARMOR_STAND.create(level);
            armorStand.moveTo(start, 0f, 0f);
            armorStand.setItemSlot(cosplayItem.getSlot().getSlot(), new ItemStack(cosplayItem.iterator().next().get()));
            level.addFreshEntityWithPassengers(armorStand);
            start.move(Direction.EAST, 2);
        }
        return 1;
    }

}
