package br.com.stompamc.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import br.com.stompamc.Strings;
import br.com.stompamc.api.ItemBuilder;
import br.com.stompamc.comando.Tell;

public class TellOFF implements Listener {

	public static void Tell(Player player) {
		Inventory inv = Bukkit.createInventory(player, 27, "§8McStompa: Config");

			ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§fTell§8 - §cDesativado", 1, 14, 13, inv);
		
		player.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void invclick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("§8McStompa: Config") && (event.getCurrentItem() != null)
				&& (event.getCurrentItem().getTypeId() != 0)) {
				event.setCancelled(true);
				
				if (event.getCurrentItem().getItemMeta().getDisplayName() == "§fTell§8 - §cDesativado") {
					Tell.telloff.remove(player);
					player.sendMessage(Strings.prefix + "§aO seu tell foi ativado.");
					TellON.Tell(player);
					player.playSound(player.getLocation(), Sound.CLICK, 1.0F, 1.0F);
					event.setCancelled(true);
					return;
				}
		}
	}
	
	
}
