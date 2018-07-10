package br.com.stompamc.comando;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import br.com.stompamc.Strings;

public class Fly implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§c Comandos apenas no servidor!");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player player = (Player) sender;
			if (args.length == 0) {
				if (player.hasPermission("lobby.vip")) {
						if (!player.getAllowFlight()) {
							player.sendMessage("§a* &7Seu modo Fly foi ativado!");
							player.setAllowFlight(true);
						} else {
							sender.sendMessage("§c* &7Seu Modo Fly foi desativado!");
							player.setAllowFlight(false);
						}
				} else {
					player.sendMessage(Strings.semperm);
					return true;
				}
			}
		return true;
	}
		return false;
 }
}