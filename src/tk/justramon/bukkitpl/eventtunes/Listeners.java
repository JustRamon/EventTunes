package tk.justramon.bukkitpl.eventtunes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class Listeners implements Listener
{
	Methods Util = new Methods();
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		String EventTune = "DeathEvent";
		Player p = event.getEntity();
		if(Util.hasSoundPermission(EventTune, p))
		{
			Util.playTune(EventTune, p);
		}
		
	}
	
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event)
	{
		String EventTune = "PortalEvent";
		Player p = event.getPlayer();
		if(Util.hasSoundPermission(EventTune, p))
		{
			Util.playTune(EventTune, p);
		}
	}
	
	
}
