package com.gmail.Annarkwin.Platinum.AntiCheat;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.Annarkwin.Platinum.AntiCheat.Commands.AntiCheat.CommandAntiCheat;
import com.gmail.Annarkwin.Platinum.AntiCheat.Listeners.ListenerAntiCheat;
import com.gmail.Annarkwin.Platinum.AntiCheat.Listeners.ListenerLogging;


public class AntiCheat extends JavaPlugin {
	
	@Override
	public void onEnable(){		
		//Load configuration serializable classes
		registerSerializables();
		
		//Retrieve file data

		//Enable plugin features
		enableListeners();
		enableCommands();
		
		//Initialize update event
	}
	
	@Override
	public void onDisable(){
		//Save data
	}
	
	private void registerSerializables() {
		
	}
	
	public void enableCommands(){
		getCommand("AntiCheat").setExecutor(new CommandAntiCheat());
	}
	
	public void enableListeners(){
		getServer().getPluginManager().registerEvents(new ListenerAntiCheat(), this);
		getServer().getPluginManager().registerEvents(new ListenerLogging(), this);
	}
}
