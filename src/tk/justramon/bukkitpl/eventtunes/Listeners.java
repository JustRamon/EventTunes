package tk.justramon.bukkitpl.eventtunes;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class Listeners implements Listener
{
	Methods methods = new Methods();
	static FileConfiguration config = EventTunes.plugin.getConfig();

	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event)
	{
		Player p = event.getPlayer();
		if(event.getTo().getWorld().getName().equals("world_nether"))
		{
			String eventTune = "NetherEnterEvent";
			if(methods.hasSoundPermission(eventTune, p) && config.getBoolean(eventTune + ".enable"))
			{
				methods.playTune(eventTune, p);
			}
		}
		else if(event.getTo().getWorld().getName().equals("world_the_end"))
		{
			String eventTune = "EndEnterEvent";
			if(methods.hasSoundPermission(eventTune, p) && config.getBoolean(eventTune + ".enable"))
			{
				methods.playTune(eventTune, p);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		String eventTune = "DeathEvent";
		Player p = event.getEntity();
		if(methods.hasSoundPermission(eventTune, p) && config.getBoolean(eventTune + ".enable"))
		{
			methods.playTune(eventTune, p);
		}
	}
}
