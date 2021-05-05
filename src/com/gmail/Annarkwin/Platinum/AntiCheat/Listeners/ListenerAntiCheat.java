package com.gmail.Annarkwin.Platinum.AntiCheat.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class ListenerAntiCheat implements Listener
{

	Material[] pressure_plates =
	{
			Material.ACACIA_PRESSURE_PLATE, Material.BIRCH_PRESSURE_PLATE, Material.DARK_OAK_PRESSURE_PLATE,
			Material.HEAVY_WEIGHTED_PRESSURE_PLATE, Material.JUNGLE_PRESSURE_PLATE,
			Material.LIGHT_WEIGHTED_PRESSURE_PLATE, Material.OAK_PRESSURE_PLATE, Material.SPRUCE_PRESSURE_PLATE,
			Material.STONE_PRESSURE_PLATE, Material.CRIMSON_PRESSURE_PLATE, Material.WARPED_PRESSURE_PLATE
	};

	double spawner_chance = 1;

	// Automatic Cactus Farms
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	public void cactusGrowth( BlockGrowEvent e )
	{

		if (e.getNewState().getType() == Material.CACTUS)
		{

			Block growth = e.getNewState().getBlock();

			if (growth.getRelative(BlockFace.EAST).getType() != Material.AIR
					|| growth.getRelative(BlockFace.NORTH).getType() != Material.AIR
					|| growth.getRelative(BlockFace.SOUTH).getType() != Material.AIR
					|| growth.getRelative(BlockFace.WEST).getType() != Material.AIR)
			{

				e.setCancelled(true);

			}

		}

	}

	// Automatic Fishing Farms
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	public void fishingEvent( EntityInteractEvent e )
	{

		if (e.getEntityType() == EntityType.FISHING_HOOK && isPressurePlate(e.getBlock().getType()))
			e.setCancelled(true);

	}

	// Automatic Guardian Grinders
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	public void guardianSpawn( EntitySpawnEvent e )
	{

		if (e.getEntityType() == EntityType.GUARDIAN
				&& e.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.WATER)
		{

			e.setCancelled(true);

		}

	}

	// Throttle Monster Spawners
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
	public void monsterSpawnerSpawn( CreatureSpawnEvent e )
	{

		if (e.getSpawnReason() == SpawnReason.SPAWNER)
		{

			if (Math.random() > spawner_chance)
				e.setCancelled(true);

		}

	}

	// Check if given material is a pressure plate
	public boolean isPressurePlate( Material type )
	{

		for (Material plate : pressure_plates)
			if (type == plate)
				return true;
		return false;

	}

}
