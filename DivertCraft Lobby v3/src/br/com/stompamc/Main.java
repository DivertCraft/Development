package br.com.stompamc;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.stompamc.comando.Admin;
import br.com.stompamc.comando.Cage;
import br.com.stompamc.comando.Chat;
import br.com.stompamc.comando.ClearChat;
import br.com.stompamc.comando.Fly;
import br.com.stompamc.comando.SetSpawn;
import br.com.stompamc.comando.Spawn;
import br.com.stompamc.comando.Tell;
import br.com.stompamc.event.Join;
import br.com.stompamc.event.Tab;
import br.com.stompamc.event.eAdmin;
import br.com.stompamc.menus.Infos;
import br.com.stompamc.menus.Perfil;
import br.com.stompamc.menus.Servidores;
import br.com.stompamc.menus.TellOFF;
import br.com.stompamc.menus.TellON;
import br.com.stompamc.scoreboard.ScoreboardHelper;
import br.com.stompamc.scoreboard.ScoreboardUser;
import br.com.stompamc.utils.Kangaroo;
import br.com.stompamc.utils.TagsAPI;
import br.com.stompamc.warp.WarpConfiguration;
import br.com.stompamc.warp.WarpManager;
import net.minecraft.util.com.google.common.collect.Lists;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance() {
		return instance;
	}
	public static Plugin plugin;
	//public static Main instance;
	
	public List<String> admins = Lists.newArrayList();
	
	public static List<String> jogadores = Lists.newArrayList();
	
	public static HashMap<Player, ScoreboardHelper> scoreboard = new HashMap<>();
	
	
	public static Plugin getPlugin() {
		return plugin;
	}
	public void onEnable() {
		plugin = this;
		
		Comandos();
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
		Eventos();

		
		instance = this;
		WarpConfiguration.getConfig().ConfigEnable(this);
		
		Bukkit.getConsoleSender().sendMessage("§e[DivertCraft] §aPlugin iniciado do lobby.");
		
		new ScoreboardUser().runTaskTimer(this, 1, 20);
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		getConfig().options().copyDefaults(true);
	      saveConfig();
	}
	
	
	void Comandos() {
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("setspawn").setExecutor(new SetSpawn());
		getCommand("tell").setExecutor(new Tell());
		getCommand("r").setExecutor(new Tell());
		getCommand("fly").setExecutor(new Fly());
		getCommand("admin").setExecutor(new Admin(this));
		getCommand("cage").setExecutor(new Cage());
		getCommand("chat").setExecutor(new Chat());
		getCommand("cc").setExecutor(new ClearChat());
	}
	void Eventos() {
		PluginManager m = Bukkit.getPluginManager();
		
		m.registerEvents(new Join(), this);
		m.registerEvents(new TagsAPI(), this);
		m.registerEvents(new Perfil(), this);
		m.registerEvents(new Servidores(), this);
		m.registerEvents(new Tab(), this);
		m.registerEvents(new TellON(), this);
		m.registerEvents(new TellOFF(), this);
		m.registerEvents(new Infos(), this);
		m.registerEvents(new br.com.stompamc.event.Eventos(), this);
		m.registerEvents(new Kangaroo(), this);
		m.registerEvents(new WarpManager(), this);
		m.registerEvents(new eAdmin(this), this);
	}
	public void onDisable() {
		plugin = null;
		saveConfig();
	}
	}

