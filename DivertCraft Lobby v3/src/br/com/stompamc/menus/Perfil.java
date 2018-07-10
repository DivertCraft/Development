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
import org.bukkit.inventory.meta.SkullMeta;

import br.com.stompamc.comando.Tell;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Perfil implements Listener {
	
	public static void gSeProfile(Player player) {
		PermissionUser User = PermissionsEx.getUser(player); // User.getPrefix().replace("&", "§")
		Inventory inventory = Bukkit.createInventory(player, 27, "§8Perfil");

		ItemStack stack1 = new ItemStack(Material.PAPER);
		ItemMeta meta1 = stack1.getItemMeta();

		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add("§7");
		lore1.add("§7Configuraçoes,");
		lore1.add("§7Aqui voce pode configurar");
		lore1.add("§7seu perfil no servidor como");
		lore1.add("§7ativar ou desativar o tell.");
		meta1.setLore(lore1);

		meta1.setDisplayName("§aConfiguraçoes");
		stack1.setItemMeta(meta1);
		inventory.setItem(13, stack1);
		
		//ItemBuilder.criarItemInv(Material.REDSTONE_TORCH_ON, "§cEm Breve", 1, 14, 15, inventory);
		
        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		
		SkullMeta meta = (SkullMeta) stack.getItemMeta();
		meta.setOwner(player.getName());

		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Nick: §7" + player.getName());
		lore.add("Grupo: §7" + User.getPrefix().replace("&", "§"));
		//lore.add("§fSeu ip: §a" + player.getAddress());
		meta.setLore(lore);

		meta.setDisplayName("§cPerfil:");
		stack.setItemMeta(meta);
		
		inventory.setItem(11, stack);
		
		player.openInventory(inventory);
	}
	
	@EventHandler
	private void bau(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.SKULL_ITEM) {
			gSeProfile(p);
			e.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void invclick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("§8Perfil") && (event.getCurrentItem() != null)
				&& (event.getCurrentItem().getTypeId() != 0)) {
				event.setCancelled(true);
				
				if (Tell.telloff.contains(player)) {
					if (event.getCurrentItem().getType() == Material.PAPER) {
							TellOFF.Tell(player);
						event.setCancelled(true);
						return;
					 }
					}
					if (!Tell.telloff.contains(player)) {
						if (event.getCurrentItem().getType() == Material.PAPER) {
							TellON.Tell(player);
						event.setCancelled(true);
						return;
					 }
					}
					if (event.getCurrentItem().getType() == Material.SKULL_ITEM) {
						event.setCancelled(true);
						return;
					}
					if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
						event.setCancelled(true);
						return;
					}
		}
	
	}

}
