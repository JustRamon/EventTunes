package tk.justramon.bukkitpl.eventtunes;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

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
	public void onPlayerRespawn(PlayerRespawnEvent event)
	{
		String eventTune = "RespawnEvent";
		Player p = event.getPlayer();
		if(methods.hasSoundPermission(eventTune, p) && config.getBoolean(eventTune + ".enable"))
		{
			methods.playTune(eventTune, p);
		}
	}
}
