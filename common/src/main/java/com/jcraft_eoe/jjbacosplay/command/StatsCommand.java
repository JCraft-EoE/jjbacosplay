package com.jcraft_eoe.jjbacosplay.command;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class StatsCommand {

    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jjbacosplay")
                .then(Commands.literal("stats")
                        .executes(StatsCommand::run)
                )
        );
    }

    public static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final ServerPlayer player = ctx.getSource().getPlayer();
        if (player == null) {
            return 0;
        }
        player.sendSystemMessage(Component.literal("JJBA Cosplay Mod featuring " + CosplayItem.all().size() + " tiered Cosplay pieces."));
        return 1;
    }

}
