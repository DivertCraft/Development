package br.com.stompamc.event;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import br.com.stompamc.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class Tab implements Listener {
	private static int VERSION = 47;

	  @EventHandler
	  void TabDoServidor(PlayerJoinEvent evento) { final Player jogador = evento.getPlayer();
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
	      public void run() {
	    	  
	        PlayerConnection connect = ((CraftPlayer)jogador).getHandle().playerConnection;
	        IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '\n            §e§lStompa §f§lNetwork            \n            §7Conectado ao servidor §3[§bLobby§3]            \n                        '}");

			IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '\n              §bSite: §l§8» §7stompamc.weebly.com              \n              §bTS: §l§8» §7(- / -)             \n              §bFórum: §l§8» §7stompamc.weebly.com/forum              "+ "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
	        if (((CraftPlayer)jogador).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
	          return;
	        }
	        connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
	      }
	    }
	    , 0L, 20L);
	  }
}