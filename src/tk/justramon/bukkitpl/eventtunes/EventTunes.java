package tk.justramon.bukkitpl.eventtunes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EventTunes extends JavaPlugin
{
	public static EventTunes plugin;
	public void onEnable()
	{
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		Methods.createSongDir();
		Methods.loadConfiguration();
		/*Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
				{
					public void run()
					{
						Methods.cfcEu();
					}
				}, 20L);*/
	}
	public void onDisable()
	{
		plugin = null;
	}
}
