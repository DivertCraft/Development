package br.com.stompamc.comando;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.stompamc.api.API;
import br.com.stompamc.utils.HotBar;
import br.com.stompamc.warp.WarpManager;

public class Spawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			WarpManager.Ir(p, "Spawn");
			API.setWarp(p, "Spawn");
			
			HotBar.pegaritens(p);
			p.sendMessage("§a*&7 Voce foi levado ao Lobby.");
		return true;
		}
		return false;
	}

}
