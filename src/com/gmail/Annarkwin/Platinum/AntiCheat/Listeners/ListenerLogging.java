package com.gmail.Annarkwin.Platinum.AntiCheat.Listeners;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class ListenerLogging implements Listener {

	//Log kicked players
	@EventHandler (ignoreCancelled = true, priority = EventPriority.MONITOR)
	public void playerKickEvent(PlayerKickEvent e) {
		Bukkit.getLogger().log(Level.WARNING, "Player kicked at location " + e.getPlayer().getLocation().toString());
	}
	
	
}
