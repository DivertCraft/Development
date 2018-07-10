package br.com.stompamc.comando;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.stompamc.Strings;
import br.com.stompamc.warp.WarpManager;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (p.hasPermission("lobby.admin")){
					WarpManager.Set(p, "Spawn");
					p.sendMessage("§a* &7O Spawn foi setado nas coordenadas &a" + p.getLocation().getBlockX() + ", "
							+ p.getLocation().getBlockY() + ", " + p.getLocation().getBlockZ());
					return true;
				} else {
					p.sendMessage(Strings.semperm);
					return true;
				}	
			}
		return false;
	}
}
