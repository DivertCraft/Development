package br.com.stompamc.comando;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cage implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao e um jogador.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (label.equalsIgnoreCase("cage")) {
			if (player.hasPermission("lobby.admin") ) {
				if (args.length == 0) {
					player.sendMessage("&e* &7Sintaxe Incorreta, por favor reformule o comando da maneira: &e/cage (jogador)");
					return true;
				}
				
				if (args.length == 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					
					if (target != null) {
						cagePlayer(target);
						
						player.sendMessage("§a* &7O Jogador &a" + target.getName() + " &7Foi preso!");
					} else {
						player.sendMessage("&c* &7Este jogador nao foi encontrado!");
					}
				}
			}
		}
		return false;
	}
	
	public void cagePlayer(Player target) {
		target.getLocation().add(0, 13, 0).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0, 11, 1).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(1, 11, 0).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0, 11, -1).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(-1, 11, 0).getBlock().setType(Material.BEDROCK);
		target.getLocation().add(0, 10, 0).getBlock().setType(Material.BEDROCK);

		target.teleport(target.getLocation().add(0, 11, -0.05));
	}
}