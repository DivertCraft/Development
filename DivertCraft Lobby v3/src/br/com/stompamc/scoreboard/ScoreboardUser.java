package br.com.stompamc.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.stompamc.Main;
import br.com.stompamc.bungee.api.ServersBungeeName;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ScoreboardUser extends BukkitRunnable {

	@Override
	@SuppressWarnings("deprecation")
	public void run() {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			ScoreboardHelper score = Main.scoreboard.get(p);

			//score.clear();
			
			PermissionUser User = PermissionsEx.getUser(p); // User.getPrefix().replace("&", "§")

			score.add(" ", " ");
			score.add("Grupo: ", User.getPrefix().replace("&", "§"));
			score.add(" ", " ");
			score.add("Online: §a", ServersBungeeName.escolher("ALL"));
			score.add("Lobby: ", "§a#1");
			score.add(" ", " ");
			score.add("§ewww.divertcraft", "§e.com.br");

			score.update(p);
		}
	}


}
