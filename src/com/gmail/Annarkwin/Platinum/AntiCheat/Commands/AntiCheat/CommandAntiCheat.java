package com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat;

import org.bukkit.command.CommandSender;

import com.gmail.Annarkwin.Platinum.API.PlatinumCommand;
import com.gmail.Annarkwin.Platinum.API.PlatinumMainCommand;

public class CommandAntiCheat extends PlatinumMainCommand
{

	public CommandAntiCheat( String name, String permission, boolean player, String description, String usage )
	{

		super(name, permission, player, description, usage);

	}

	@Override
	public boolean run( CommandSender sender, String cmdname, String[] cmdargs )
	{

		if (cmdargs.length > 0)
		{

			PlatinumCommand child = getChild(cmdargs[0]);

			if (child != null)
			{

				if (sender.hasPermission(child.getPermissionHook()))
				{

					return child.run(sender, cmdname, cmdargs);

				}
				else
				{

					sender.sendMessage("Error: You don't have permission to execute that command");
					return true;

				}

			}

		}

		return false;

	}

}
