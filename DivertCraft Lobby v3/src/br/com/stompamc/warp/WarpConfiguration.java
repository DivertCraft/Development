package br.com.stompamc.warp;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class WarpConfiguration {

public class Warps {
}
	public static WarpConfiguration pasta = new WarpConfiguration();
	FileConfiguration Warps;
	File FileWarps;
	public static WarpConfiguration getConfig(){
		return pasta;
	}
	public void ConfigEnable(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileWarps = new File(plugin.getDataFolder(), "spawn.yml");
		if(FileWarps.exists()){
			try{
				FileWarps.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Warps = YamlConfiguration.loadConfiguration(FileWarps);
	}
	public FileConfiguration config(){
		return Warps;
	}
	public void saveConfigs(){
		try{
			Warps.save(FileWarps);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}