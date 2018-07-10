package br.com.stompamc.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import br.com.stompamc.Main;

public class Kangaroo implements Listener {
	public Main plugin;

	public Kangaroo(Main plugin) {
		this.plugin = plugin;
	}

	public Kangaroo() {
		// TODO Auto-generated constructor stub
	}

	ArrayList<String> tempo = new ArrayList<>();
	ArrayList<String> naofugir = new ArrayList<>();

	@EventHandler
	public void pular(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK) {
				event.setCancelled(true);
				Vector vector = p.getEyeLocation().getDirection();
				if (!this.naofugir.contains(p.getName())) {
					if (!this.tempo.contains(p.getName())) {
						this.tempo.add(p.getName());
						if (!p.isSneaking()) {
							p.setFallDistance(-1.5F);
							vector.multiply(0.5F);
							vector.setY(1.0D);
							p.setVelocity(vector);
						} else {
							p.setFallDistance(-1.5F);
							vector.multiply(1.5F);
							vector.setY(0.5D);
							p.setVelocity(vector);
						}
					}
				} else if (!this.tempo.contains(p.getName())) {
					this.tempo.add(p.getName());
					p.setFallDistance(0.0F);
					vector.multiply(0.0F);
					vector.setY(0.0D);
					p.setVelocity(vector);
				}
		}
	}
	  @EventHandler
	  public void onDamageds(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if (((event.getEntity() instanceof Player)) && 
	        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	        (player.getInventory().contains(Material.FIREWORK)) && 
	        (event.getDamage() >= 7.0D)) {
	        event.setDamage(7.0D);
	      }
	    }
	    }

	@EventHandler
	public void removertempo(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (this.tempo.contains(p.getName())) {
			Block b = p.getLocation().getBlock();
			if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
				this.tempo.remove(p.getName());
			}
		}
	}
	
}