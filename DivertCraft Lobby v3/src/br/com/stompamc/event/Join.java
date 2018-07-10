package br.com.stompamc.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import br.com.stompamc.Main;
import br.com.stompamc.api.API;
import br.com.stompamc.scoreboard.ScoreboardUpdater;
import br.com.stompamc.utils.HotBar;
import br.com.stompamc.warp.WarpManager;
import ca.wacos.nametagedit.NametagAPI;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Join implements Listener {
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		Main.jogadores.add(p.getName());
		
		//MySQL.addPlayerToTable(p.getUniqueId(), "KitPvP",
			//	new String[] { "0", "0", "200", "Unranked", "I", "0", p.getName(), "0" }, false, true);
		
		//String prefix = "§b§7";
		//String suffix = " §7(" + ScoreboardUser.getRank(p) + "§7)";
		PermissionUser User = PermissionsEx.getUser(p); // User.getPrefix().replace("&", "§")
		NametagAPI.setPrefix(p.getName(), User.getPrefix().replace("&", "§"));
		//NametagAPI.setSuffix(p.getName(), suffix);
		
		WarpManager.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");
		ScoreboardUpdater.Score(p);
		
		HotBar.pegaritens(p);
		
		
		API.mandarTitulo(p, "§6§lREDE DIVERT");
		API.mandarSubTitulo(p, "§fBem Vindo,§e " + p.getName());

		//p.sendMessage("§7");
		//p.sendMessage(Strings.prefix + "Bem Vindo, §9" + p.getName());
		//p.sendMessage("§7» Compre §9VIP §7e §9KITS§7 acessando: §bwww.stompamc.com.br");
		//p.sendMessage("§7");
		API.checarNameTag(p);
		
		if(p.hasPermission("divert.lobby.entrar")) {
			e.setJoinMessage(User.getPrefix().replace("&", "§") + p.getName() + " §6entrou neste lobby.");
		} else {
			e.setJoinMessage(null);
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		
		Main.jogadores.remove(e.getPlayer().getName());
	}

}
