package br.com.stompamc.comando;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.stompamc.Main;
import net.minecraft.util.com.google.common.collect.Maps;

@SuppressWarnings({ "deprecation" })
public class Admin implements CommandExecutor {
	
	public Main main;
	public Map<String, ItemStack[]> inv = Maps.newHashMap();
	public Map<String, ItemStack[]> armor = Maps.newHashMap();
	
	public Admin(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cPrecisa ser um jogador");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (label.equalsIgnoreCase("admin")) {
			if (player.hasPermission("lobby.admin")) {
				if (!main.admins.contains(player.getName())) {
					main.admins.add(player.getName());
					
					for (Player players : Bukkit.getOnlinePlayers()) {
							players.hidePlayer(player);
					}
					
					Main.jogadores.remove(player.getName());
					
					inv.put(player.getName(), player.getInventory().getContents());
					armor.put(player.getName(), player.getInventory().getArmorContents());
					
					player.setGameMode(GameMode.CREATIVE);
										
					player.getInventory().clear();
					player.getInventory().setArmorContents(null);
					player.setAllowFlight(true);
					
					ItemStack fz = new ItemStack(Material.IRON_FENCE);
					ItemMeta fzm = fz.getItemMeta();
					fzm.setDisplayName("§cPrender Jogador");
					fz.setItemMeta(fzm);
					
					player.getInventory().setItem(2, fz);
					
					ItemStack f = new ItemStack(Material.MAGMA_CREAM);
					ItemMeta fm = f.getItemMeta();
					fm.setDisplayName("§aFast Admin");
					f.setItemMeta(fm);
					
					player.getInventory().setItem(4, f);
					
					ItemStack fn = new ItemStack(Material.TRAPPED_CHEST);
					ItemMeta fnm = fn.getItemMeta();
					fnm.setDisplayName("§eAbrir Inventario");
					fn.setItemMeta(fnm);
					
					player.getInventory().setItem(6, fn);
					
					player.updateInventory();
					
					player.sendMessage("§dSeu Modo ADMIN foi Ativado!");
					player.sendMessage("§5§OVOCE ESTA VISIVEL PARA TRIAL OU SUPERIOR.");
				} else {
					main.admins.remove(player.getName());
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.showPlayer(player);
					}
					
					Main.jogadores.add(player.getName());
					
					player.setGameMode(GameMode.SURVIVAL);
					player.setAllowFlight(false);
					player.setFlying(false);
					
					player.getInventory().setContents(inv.get(player.getName()));
					player.getInventory().setArmorContents(armor.get(player.getName()));
					
					inv.remove(player.getName());
					armor.remove(player.getName());
					
					player.updateInventory();
					
					player.sendMessage("§dVoce saiu do Modo ADMIN!");
					player.sendMessage("§d§oVOCE ESTA VISIVEL PARA TODOS!");
				}
			}
		}
		return false;
	}
}