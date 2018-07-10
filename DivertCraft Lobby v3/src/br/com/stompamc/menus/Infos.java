package br.com.stompamc.menus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Infos implements Listener {

	public static void gServerI(Player player) {
		Inventory inv = Bukkit.createInventory(player, 27, "§8McStompa: Infos");

		ItemStack stack = new ItemStack(Material.BOOK);
		ItemMeta meta = stack.getItemMeta();

		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7");
		lore.add("§7Nossa rede de servidores, atualmente,");
		lore.add("§7esta com os modos de jogo:");
		lore.add("§7HardcoreGames, Em breve mais modos de jogo...");
		meta.setLore(lore);

		meta.setDisplayName("§cModos de Jogo");
		stack.setItemMeta(meta);
		inv.setItem(11, stack);
		
		ItemStack stack1e = new ItemStack(Material.BOOK);
		ItemMeta meta1e = stack1e.getItemMeta();

		ArrayList<String> loree = new ArrayList<String>();
		loree.add("§7");
		loree.add("§7Nossos plugin sao");
		loree.add("§7desenvolvidos pelos programadores:");
		loree.add("§3iViniiHG §7& §3iCostly");
		meta1e.setLore(loree);

		meta1e.setDisplayName("§cPlugins");
		stack1e.setItemMeta(meta1e);
		inv.setItem(15, stack1e);
		
		ItemStack stack1 = new ItemStack(Material.BOOK);
		ItemMeta meta1 = stack1.getItemMeta();

		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add("§7");
		lore1.add("§7Servidor baseado em:    ");
		lore1.add("§7Minecraft PvP com Sopa  ");
		lore1.add("§7");
		meta1.setLore(lore1);

		meta1.setDisplayName("§cSobre o servidor:");
		stack1.setItemMeta(meta1);
		inv.setItem(13, stack1);

		player.openInventory(inv);
	}

	@EventHandler
	private void bau(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.NAME_TAG) {
			gServerI(p);
			e.setCancelled(true);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void invclick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("§8McStompa: Infos") && (event.getCurrentItem() != null)
				&& (event.getCurrentItem().getTypeId() != 0)) {
				event.setCancelled(true);
				
				if (event.getCurrentItem().getType() == Material.BOOK) {
					player.closeInventory();
					event.setCancelled(true);
					return;
				}
		}

	}

}
