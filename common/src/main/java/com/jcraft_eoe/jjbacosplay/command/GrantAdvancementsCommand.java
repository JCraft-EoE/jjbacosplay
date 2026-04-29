package com.jcraft_eoe.jjbacosplay.command;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.advancements.Advancement;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;

public class GrantAdvancementsCommand {

    public static void register(final CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jjbacosplay")
                .then(Commands.literal("grant")
                        .requires(source -> source.hasPermission(2))
                        .then(Commands.argument("players", EntityArgument.players())
                            .executes(GrantAdvancementsCommand::run)
                        )
                )
        );
    }

    public static int run(final CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        final Collection<? extends Player> players = EntityArgument.getPlayers(ctx, "players");
        for (final Player player : players) {
            if (player instanceof ServerPlayer serverPlayer) {
                if (serverPlayer.getServer() == null) {
                    continue;
                }
                for (final Advancement advancement : serverPlayer.getServer().getAdvancements().getAllAdvancements()) {
                    if (!advancement.getId().getNamespace().equals(JjbaCosplay.MOD_ID)) {
                        continue;
                    }
                    for (final String criterion : advancement.getCriteria().keySet()) {
                        serverPlayer.getAdvancements().award(advancement, criterion);
                    }
                }
            }
        }
        return 1;
    }

}
