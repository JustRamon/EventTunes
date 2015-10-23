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

	public static File getSongPath(String EventTune)
	{
		File songpath = new File(songfolder, config.getString(EventTune + ".file"));
		return songpath;
	}

	public static void createSongDir()
	{
		if (!songfolder.exists())
			songfolder.mkdir();
	}

	public void playTune(String EventTune, Player p)
	{
		if (Methods.getSongPath(EventTune).exists())
		{
			Song s = NBSDecoder.parse(Methods.getSongPath(EventTune));
			SongPlayer sp = new RadioSongPlayer(s);
			sp.setAutoDestroy(true);
			sp.addPlayer(p);
			sp.setPlaying(true);
			System.out.println("Play");
		}
		else
		{
			notFound(EventTune);
		}
	}

	public boolean hasSoundPermission(String EventTune, Player p)
	{
		if(p.hasPermission("eventtunes." + EventTune))
			return true;
		else
			return false;
	}

	public static void loadConfiguration()
	{
		EventTunes.plugin.getConfig().addDefault("DeathEvent.file", "DeathEvent.nbs");
		EventTunes.plugin.getConfig().addDefault("DeathEvent.enable", true);
		EventTunes.plugin.getConfig().addDefault("PortalEvent.file", "PortalEvent.nbs");
		EventTunes.plugin.getConfig().addDefault("PortalEvent.enable", true);
		
		EventTunes.plugin.getConfig().options().copyDefaults(true);
		EventTunes.plugin.saveConfig();
	}
	
	public static void notFound(String EventTune)
	{
		EventTunes.plugin.getLogger().warning("The file for " + EventTune + " could not be found.");
	}


}
