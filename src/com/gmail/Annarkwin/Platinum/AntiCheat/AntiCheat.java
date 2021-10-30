package com.gmail.Annarkwin.Platinum.AntiCheat;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.Annarkwin.Platinum.API.PlatinumMainCommand;
import com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat.AntiCheatHelp;
import com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat.AntiCheatTestCommand;
import com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat.CommandAntiCheat;
import com.gmail.Annarkwin.Platinum.AntiCheat.Listeners.ListenerAntiCheat;
import com.gmail.Annarkwin.Platinum.AntiCheat.Listeners.ListenerLogging;

public class AntiCheat extends JavaPlugin
{

	@Override
	public void onEnable()
	{

		// Load configuration serializable classes
		registerSerializables();

		// Retrieve file data

		// Enable plugin features
		enableListeners();
		enableCommands();

		// Initialize update event
	}

	@Override
	public void onDisable()
	{

		// Save data
	}

	private void registerSerializables()
	{

	}

	public void enableCommands()
	{

		PlatinumMainCommand anticheat = new CommandAntiCheat("AntiCheat", "platinum.command.anticheat", true,
				"Anticheat commands", "/Anticheat help");
		anticheat.addChildCommand(new AntiCheatHelp("help", "platinum.command.anticheat.help", true,
				"Get anticheat command help", "/Anticheat help"));
		anticheat.addChildCommand(new AntiCheatTestCommand("test", "platinum.command.anticheat.test", true,
				"Anticheat test subcommand", "/Anticheat test"));
		getCommand("AntiCheat").setExecutor(anticheat);

	}

	public void enableListeners()
	{

		getServer().getPluginManager().registerEvents(new ListenerAntiCheat(), this);
		getServer().getPluginManager().registerEvents(new ListenerLogging(), this);

	}

}
