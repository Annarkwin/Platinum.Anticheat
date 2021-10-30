package com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat;

import org.bukkit.command.CommandSender;

import com.gmail.Annarkwin.Platinum.API.PlatinumCommand;

public class AntiCheatTestCommand extends PlatinumCommand
{

	public AntiCheatTestCommand( String name, String permission, boolean player, String description, String usage )
	{

		super(name, permission, player, description, usage);

	}

	@Override
	public boolean run( CommandSender sender, String cmdname, String[] cmdargs )
	{

		sender.sendMessage("This is a test command");
		sender.sendMessage(cmdname);
		return true;

	}

}
