package br.com.stompamc.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.stompamc.Main;

@SuppressWarnings({ "deprecation" })
public class eAdmin implements Listener {

	public Main main;

	public eAdmin(Main main) {
		this.main = main;
	}

	@EventHandler
	private void onPlayerInteractPlayerAdmin(PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player))
			return;

		Player player = e.getPlayer();
		Player clicked = (Player) e.getRightClicked();

		String player_name = player.getName();

		if (main.admins.contains(player_name)) {
			if (player.getItemInHand().getType() == Material.TRAPPED_CHEST) {
				player.openInventory(clicked.getInventory());

				player.sendMessage("§7Você está vendo o §6§lINVENTARIO §7do §e" + player.getName());
				e.setCancelled(true);
			} else if (player.getItemInHand().getType() == Material.IRON_FENCE) {
				player.performCommand("cage " + clicked.getName());
				e.setCancelled(true);
			}
			
			e.setCancelled(true);
		}
	}

	@EventHandler
	private void onPlayerInteractAdmin(PlayerInteractEvent e) {
		final Player player = e.getPlayer();
		String player_name = player.getName();

		if (main.admins.contains(player_name)) {
			if (player.getItemInHand() == null || !player.getItemInHand().hasItemMeta())
				return;

			if (player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aFast Admin")) {
				player.performCommand("admin");
				player.setAllowFlight(true);
				player.setFlying(true);

				new BukkitRunnable() {
					public void run() {
						player.performCommand("admin");
						player.setAllowFlight(true);
						player.setFlying(true);
					}
				}.runTaskLater(Main.plugin, 7);
				player.setAllowFlight(true);
				player.setFlying(true);
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	private void onPlayerDropItemAdmin(PlayerDropItemEvent e) {
		Player player = e.getPlayer();

		if (main.admins.contains(player.getName())) {
			if (!e.getItemDrop().getItemStack().hasItemMeta())
				return;

			if (!e.getItemDrop().getItemStack().getItemMeta().getDisplayName()
					.contains(e.getItemDrop().getItemStack().getType().toString())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	private void onPlayerPickUpAdmin(PlayerPickupItemEvent e) {
		Player player = e.getPlayer();

		if (main.admins.contains(player.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		for (Player players : Bukkit.getOnlinePlayers()) {
			if (main.admins.contains(players.getName()) && (!players.hasPermission("lobby.admin"))) {
				player.hidePlayer(players);
			}
		}
	}
}