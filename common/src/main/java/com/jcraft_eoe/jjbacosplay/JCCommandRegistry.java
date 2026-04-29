package com.jcraft_eoe.jjbacosplay;

import com.jcraft_eoe.jjbacosplay.command.GrantAdvancementsCommand;
import com.jcraft_eoe.jjbacosplay.command.PresentCommand;
import com.jcraft_eoe.jjbacosplay.command.StatsCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public interface JCCommandRegistry {

    static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess, Commands.CommandSelection environment) {
        GrantAdvancementsCommand.register(dispatcher);
        PresentCommand.register(dispatcher);
        StatsCommand.register(dispatcher);
    }

}
