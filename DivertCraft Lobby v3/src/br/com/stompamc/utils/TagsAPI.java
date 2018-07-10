package br.com.stompamc.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import ca.wacos.nametagedit.NametagAPI;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class TagsAPI implements Listener {
	public static void setarTag(Player p ,String rank) {
		new BukkitRunnable() {
			@Override
			public void run() {
				PermissionUser User = PermissionsEx.getUser(p); // User.getPrefix().replace("&", "§")
				p.setDisplayName(User.getPrefix().replace("&", "§") + p.getName());
				NametagAPI.setPrefix(p.getName(), User.getPrefix().replace("&", "§"));
				
			}
		};
	}
	@EventHandler
	public void rank(PlayerJoinEvent e) {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
		};
			};
		};
	
	}
