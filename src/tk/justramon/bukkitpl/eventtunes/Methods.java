package tk.justramon.bukkitpl.eventtunes;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.xxmicloxx.NoteBlockAPI.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;

public class Methods
{
	static File songfolder = new File(EventTunes.plugin.getDataFolder().getPath() + "//Songs");
	static FileConfiguration config = EventTunes.plugin.getConfig();

	public static File getSongPath(String eventTune)
	{
		File songpath = new File(songfolder, config.getString(eventTune + ".file"));
		return songpath;
	}

	public static void createSongDir()
	{
		if (!songfolder.exists())
			songfolder.mkdir();
	}

	public void playTune(String eventTune, Player p)
	{
		if (Methods.getSongPath(eventTune).exists())
		{
			Song s = NBSDecoder.parse(Methods.getSongPath(eventTune));
			SongPlayer sp = new RadioSongPlayer(s);
			if(!sp.isPlaying())
			{
				sp.setAutoDestroy(true);
				sp.addPlayer(p);
				sp.setPlaying(true);
			}
			else
			{
				return;
			}
		}
		else
		{
			notFound(eventTune);
		}
	}

	public boolean hasSoundPermission(String eventTune, Player p)
	{
		if(p.hasPermission("eventtunes." + eventTune))
			return true;
		else
			return false;
	}

	public static void loadConfiguration()
	{

		EventTunes.plugin.getConfig().addDefault("NetherEnterEvent.file", "NetherEnterEvent.nbs");
		EventTunes.plugin.getConfig().addDefault("NetherEnterEvent.enable", true);
		EventTunes.plugin.getConfig().addDefault("EndEnterEvent.file", "EndEnterEvent.nbs");
		EventTunes.plugin.getConfig().addDefault("EndEnterEvent.enable", true);
		EventTunes.plugin.getConfig().addDefault("DeathEvent.file", "DeathEvent.nbs");
		EventTunes.plugin.getConfig().addDefault("DeathEvent.enable", true);

		EventTunes.plugin.getConfig().options().copyDefaults(true);
		EventTunes.plugin.saveConfig();
	}

	public static void notFound(String eventTune)
	{
		EventTunes.plugin.getLogger().warning("The file for " + eventTune + " could not be found.");
	}

	/*public static void cfcEu()
	{
		Sunset sunset = new Sunset();
		Sunrise sunrise = new Sunrise();

	}*/


}
