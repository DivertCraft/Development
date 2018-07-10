package br.com.stompamc.api;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.ProtocolInjector;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import br.com.stompamc.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;

public class API {
	
	public static void TranferirJogador(Player p, String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		p.sendPluginMessage(Main.plugin, "BungeeCord", out.toByteArray());
	}
	
	public static void checarTag(Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				if (p.hasPermission("tag.dono")) {
					p.chat("/tag dono");
				} else if (p.hasPermission("tag.coder")) {
					p.chat("/tag coder");
				} else if (p.hasPermission("tag.gerente")) {
					p.chat("/tag gerente");
				} else if (p.hasPermission("tag.admin")) {
					p.chat("/tag admin");
				} else if (p.hasPermission("tag.mod")) {
					p.chat("/tag mod");
				} else if (p.hasPermission("tag.trial")) {
					p.chat("/tag trialmod");
				} else if (p.hasPermission("tag.builder")) {
					p.chat("/tag builder");
				} else if (p.hasPermission("tag.ajudante")) {
					p.chat("/tag ajudante");
				} else if (p.hasPermission("tag.youtuber")) {
					p.chat("/tag youtuber");
				} else if (p.hasPermission("divert.tag.vip")) {
					p.chat("/tag vip");
				} else if (p.hasPermission("divert.tag.normal")) {
					p.chat("/tag normal");
				}	
			}
		}, 2L);
	}
	
	public static void checarNameTag(Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				boolean SetarGrupo = true;

					SetarGrupo = false;
				}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				checarTag(p);
			}
		}, 2L);
	}
	
	private static HashMap<Player, String> Warp = new HashMap<>();

	public static String getWarp(Player p) {

		if (Warp.containsKey(p)) {
			return Warp.get(p);
		} else {
			return "Spawn";
		}
	}

	public static void setWarp(Player p, String warp) {
		Warp.put(p, warp);
	}
	
	public static void mandarTitulo(Player player, String titulo) {
		if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() < 45) {
			return;
		}
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}

	public static void mandarSubTitulo(Player player, String titulo) {
		if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() < 45) {
			return;
		}
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(
				ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}

}
