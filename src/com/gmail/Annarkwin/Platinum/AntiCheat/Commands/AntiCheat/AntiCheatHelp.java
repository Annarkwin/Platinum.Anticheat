package com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import com.gmail.Annarkwin.Platinum.API.CommandHelper;
import com.gmail.Annarkwin.Platinum.API.HelpCommand;
import com.gmail.Annarkwin.Platinum.API.PlatinumCommand;

public class AntiCheatHelp extends PlatinumCommand implements HelpCommand
{

	public AntiCheatHelp( String name, String permission, boolean player, String description, String usage )
	{

		super(name, permission, player, description, usage);

	}

	@Override
	public String getHelpString( PlatinumCommand command )
	{

		return " §5" + command.getUsage() + " §6- " + command.getDescription();

	}

	@Override
	public String[] getHelpEntries( CommandSender sender, PlatinumCommand command )
	{

		ArrayList<String> entries = new ArrayList<String>();

		for (PlatinumCommand sc : command.getChildren())
		{

			if (sender.hasPermission(sc.getPermissionHook()))
				entries.add(getHelpString(sc));

		}

		return ((String[]) entries.toArray(new String[0]));

	}

	@Override
	public boolean run( CommandSender sender, String cmdname, String[] cmdargs )
	{

		String[] entries = getHelpEntries(sender, getParent());

		if (cmdargs.length > 1)
		{

			if (CommandHelper.isPositiveInt(cmdargs[1]))
			{

				CommandHelper.sendHelp(sender, entries, "Anticheat", CommandHelper.getInt(cmdargs[1]));

			}
			else
			{

				sender.sendMessage("§4[Error]:§f Enter a positive number");

			}

		}
		else
		{

			CommandHelper.sendHelp(sender, entries, "Anticheat", 1);

		}

		return true;

	}

}
