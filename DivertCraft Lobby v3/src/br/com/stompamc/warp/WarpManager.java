package br.com.stompamc.warp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class WarpManager implements Listener{
	
	public static ArrayList<String> segundos = new ArrayList<>();
	
	
	@EventHandler
	public void andou(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(segundos.contains(p.getName())){
			segundos.remove(p.getName());
			
			p.sendMessage("§cTeleporte foi cancelado, pois você se moveu.");
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.BLINDNESS);
		}
	}
	
	public static void Set(Player p,String Warp){
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".X", p.getLocation().getX());
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".Y", p.getLocation().getY());
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".Z", p.getLocation().getZ());
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".Pitch", p.getLocation().getPitch());
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".Yaw", p.getLocation().getYaw());
		WarpConfiguration.getConfig().config().set("Warps." + Warp + ".World", p.getLocation().getWorld().getName());
		WarpConfiguration.getConfig().saveConfigs();
	}
	
	public static void Ir(Player p,String Warp){
		
		if(WarpConfiguration.getConfig().config().contains("Warps." + Warp)){
			
			double x = WarpConfiguration.getConfig().config().getDouble("Warps." + Warp + ".X");
			double y = WarpConfiguration.getConfig().config().getDouble("Warps." + Warp + ".Y");
			double z = WarpConfiguration.getConfig().config().getDouble("Warps." + Warp + ".Z");
			float Pitch = (float)WarpConfiguration.getConfig().config().getDouble("Warps." + Warp + ".Pitch");
			float Yaw = (float)WarpConfiguration.getConfig().config().getDouble("Warps." + Warp + ".Yaw");
			World world = Bukkit.getWorld(WarpConfiguration.getConfig().config().getString("Warps." + Warp + ".World"));
			Location loc = new Location(world, x, y, z, Yaw, Pitch);
			
			p.teleport(loc);
		}else{
			p.sendMessage("§cWarp não identificada.");
		}
	}
}