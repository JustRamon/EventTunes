package tk.justramon.bukkitpl.eventtunes;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPortalEvent;

public class Listeners implements Listener
{
	Methods methods = new Methods();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event)
	{
		String eventTune = "DeathEvent";
		Player p = event.getEntity();
		if(methods.hasSoundPermission(eventTune, p))
		{
			methods.playTune(eventTune, p);
		}

	}

	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event)
	{
		String EventTune = "PortalEvent";
		Player p = event.getPlayer();
		if(methods.hasSoundPermission(EventTune, p))
		{
			methods.playTune(EventTune, p);
		}
	}
}
