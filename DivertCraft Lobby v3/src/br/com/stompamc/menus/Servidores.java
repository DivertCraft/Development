package br.com.stompamc.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import br.com.stompamc.api.API;
import br.com.stompamc.api.CooldownAPI;
import br.com.stompamc.api.ItemBuilder;

public class Servidores implements Listener {

	public static void gServer(Player player) {
		Inventory inventory = Bukkit.createInventory(player, 54, "§8McStompa: Menu");

		ItemBuilder.criarItemInv(Material.DIAMOND_SWORD, "§bKITPVP", 1, 0, 30, inventory);
		ItemBuilder.criarItemInv(Material.MUSHROOM_SOUP, "§bHG", 1, 0, 32, inventory);
		//
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 0, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 1, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 9, inventory);
		//
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 7, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 8, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 17, inventory);
		//
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 36, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 45, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 46, inventory);
		//
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 52, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 53, inventory);
		ItemBuilder.criarItemInv(Material.STAINED_GLASS_PANE, "§a ", 1, 0, 44, inventory);

		player.openInventory(inventory);
	}

	@EventHandler
	private void compass(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COMPASS) {
			gServer(p);
			e.setCancelled(true);
			if (p.hasPermission("lobby.admin")) {
				CooldownAPI.addCooldown(p, 2);
			} else {
				CooldownAPI.addCooldown(p, 3);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void invclick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("§8McStompa: Menu") && (event.getCurrentItem() != null)
				&& (event.getCurrentItem().getTypeId() != 0)) {
			event.setCancelled(true);

			if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				event.setCancelled(true);
				return;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bHG")) {
				API.TranferirJogador(player, "hg");
				player.closeInventory();

				event.setCancelled(true);
				return;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKITPVP")) {
				API.TranferirJogador(player, "kitpvp");
				player.closeInventory();
				event.setCancelled(true);
				return;
			}

		}
	}

}