package br.com.stompamc.comando;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import br.com.stompamc.Strings;

public class Chat implements Listener, CommandExecutor {

	public static ArrayList<Player> chat = new ArrayList<Player>();

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("chat")) {
			if (sender.hasPermission("lobby.admin")) {
				if (args.length > 0) {
					if (args.length == 1) {
						if (args[0].equalsIgnoreCase("off")) {
							Bukkit.broadcastMessage("§6*§7 O Chat do servidor foi §6Desativado§7.");
							for (Player p1 : Bukkit.getOnlinePlayers()) {
								if (!p1.hasPermission("lobby.admin")) {
									chat.add(p1);
								}
							}
						} else if (args[0].equalsIgnoreCase("on")) {
							Bukkit.broadcastMessage("§6*§7 O Chat do servidor foi §6Ativad§7.");
							for (Player p1 : Bukkit.getOnlinePlayers()) {
								if (chat.contains(p1)) {
									chat.remove(p1);
								}
							}
						}
					} else {
						p.sendMessage("§e* §7Sintaxe Incorreta, por favor reformule o comando da maneira: §e/chat (on) (off)");
					}
				} else {
					p.sendMessage("§e* §7Sintaxe Incorreta, por favor reformule o comando da maneira: §e/chat (on) (off)");
				}
			} else {
				p.sendMessage(Strings.semperm);
				return true;
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void ChatDesativado(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		if (chat.contains(p)) {
			p.sendMessage("§c* &7O Chat Esta desativado no momento!");
			event.setCancelled(true);
		}
	}

}
