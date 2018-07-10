package br.com.stompamc.event;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;

public class Eventos implements Listener {
	
	private Map<String, Long> timeout = new HashMap<>();
	
	  @EventHandler
	  public void onMoveVoid(PlayerMoveEvent e) {
	   Player p = e.getPlayer();
	   if(p.getLocation().getY() < 0) {
		   p.chat("/spawn");
	   }
	  }
	  
	  @EventHandler
		public void onMotd(ServerListPingEvent e) {

			if (Bukkit.hasWhitelist()) {
				e.setMotd(
						"                 &6&lREDE DIVERTCRAFT &7(1.7x e 1.8x)                      \r\n" + "  \n     ßcßlMANUTEN«√Oßc: Voltamos em breve!");
			} else {
				e.setMotd(
						"                 &6&lREDE DIVERTCRAFT &7(1.7x e 1.8x)  \n     &fAbertura oficial ßeßlRANKUP");
			}
		}
	  
	  @EventHandler
		public void onChatDelay(AsyncPlayerChatEvent e) {
			Player p = e.getPlayer();
			if ((this.timeout.containsKey(p.getName()))
					&& (((Long) this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
				if (p.hasPermission("divert.lobby.admin")) {
					return;
				}
				p.sendMessage("ßcFale mais devagar...");
				e.setCancelled(true);
				return;
			}
			this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));
		}
	  
	    @EventHandler
	    public void noInfos(PlayerCommandPreprocessEvent e) {
	     Player p = e.getPlayer();
	     if(e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/plugins") || e.getMessage().toLowerCase().startsWith("/bukkit:pl") || e.getMessage().toLowerCase().startsWith("/bukkit:plugins") || e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().startsWith("/ver") || e.getMessage().toLowerCase().startsWith("/bukkit:about") || e.getMessage().toLowerCase().startsWith("/bukkit:ver") || e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/?") || e.getMessage().toLowerCase().startsWith("/bukkit:?") || e.getMessage().toLowerCase().startsWith("/bukkit:help")) {
	      p.sendMessage(" ");
	      p.sendMessage("ßfComando inexistente.");
	      p.sendMessage(" ");
	      e.setCancelled(true);
	     }
	    }
	    
	  @EventHandler
		public void onChat(AsyncPlayerChatEvent e) {
			Player p = e.getPlayer();

			if (!p.hasPermission("divert.lobby.vip") ) {
				e.setFormat(p.getDisplayName() + " ß7ª "
						+ e.getMessage().replaceAll("%", "").replaceAll("%", ""));
			} else {
				e.setFormat(p.getDisplayName() + " ß7ª ßf"
						+ e.getMessage().replaceAll("&", "ß").replaceAll("%", ""));
			}
		}
	  
	  @EventHandler
		public void onPlayerColor(SignChangeEvent e) {
		  Player p = e.getPlayer();
		  if (p.hasPermission("lobby.admin") ) {
			  if (e.getLine(0).contains("&")) {
					e.setLine(0, e.getLine(0).replace("&", "ß"));
				}
				if (e.getLine(1).contains("&")) {
					e.setLine(1, e.getLine(1).replace("&", "ß"));
				}
				if (e.getLine(2).contains("&")) {
					e.setLine(2, e.getLine(2).replace("&", "ß"));
				}
				if (e.getLine(3).contains("&"))
					e.setLine(3, e.getLine(3).replace("&", "ß"));
		  }	  
		}

		@EventHandler
		public void onSleep(PlayerBedEnterEvent event) {
			event.setCancelled(true);
		}
		
		@EventHandler
		public void onMe(PlayerCommandPreprocessEvent event) {
			Player p = event.getPlayer();
			if ((event.getMessage().toLowerCase().startsWith("/me") || event.getMessage().toLowerCase().startsWith("/bukkit:me"))) {
				event.setCancelled(true);
				p.kickPlayer("ßcConex√£o Perdida! \n Ouve um erro com estabelecimento do proxy \n Reloge-se...");
			}
		}
		
		@EventHandler
		public void onDamage(EntityDamageEvent e) {

			e.setCancelled(true);
		}

		@EventHandler
		public void onFood(FoodLevelChangeEvent e) {

			e.setCancelled(true);
		}

		@EventHandler
		public void onWeater(WeatherChangeEvent e) {

			e.setCancelled(true);
		}

		@EventHandler
		public void onMob(CreatureSpawnEvent e) {

			e.setCancelled(true);
		}

		@EventHandler
		public void onBreak(BlockBreakEvent e) {
			Player p = e.getPlayer();
			if(p.getGameMode() != GameMode.CREATIVE) {
				
				e.setCancelled(true);
				
			}
		}

		@EventHandler
		public void onPlace(BlockPlaceEvent e) {
			Player p = e.getPlayer();
			if(p.getGameMode() != GameMode.CREATIVE) {
				
				e.setCancelled(true);
				
			}
		}

		@EventHandler
		public void onInteract(PlayerInteractEvent e) {
			Player p = e.getPlayer();
			if(p.getGameMode() != GameMode.CREATIVE) {
				
				e.setCancelled(true);
				
			}
		}
	  
	  @EventHandler
		public void onInvalid(PlayerCommandPreprocessEvent e) {
			Player p = e.getPlayer();

			if (!e.isCancelled()) {

				String cmd = e.getMessage().split(" ")[0];
				HelpTopic help = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);

				if (help == null) {
					p.sendMessage("ßfComando inexistente.");
					e.setCancelled(true);
				}
			}
		}
	  
	  @SuppressWarnings("deprecation")
		@EventHandler
		public void onReload(PlayerCommandPreprocessEvent event) {
			Player p = event.getPlayer();

			String msg = event.getMessage();
			if (((msg.equalsIgnoreCase("/rl")) || (msg.equalsIgnoreCase("/reload"))) && p.hasPermission("divert.lobby.dono") ) {
				event.setCancelled(true);

				Bukkit.reload();
				p.getInventory().clear();
				Player[] arrayOfPlayer;
				int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
				for (int i = 0; i < j; i++) {
					Player all = arrayOfPlayer[i];
					all.kickPlayer("ßcReiniciamos o Servidor [Lobby] \n ßcpara o melhor desenpenho de nossas maquinas \n ßcJa Ja° Voltamos...");
				}
			}
		}
	  
		@SuppressWarnings("deprecation")
		@EventHandler(priority = EventPriority.MONITOR)
		private void NoaoDroparItens(PlayerDropItemEvent e) {
			if (e.getItemDrop().getItemStack().getType() != Material.BOWL
					&& e.getItemDrop().getItemStack().getType() != Material.MUSHROOM_SOUP
					&& e.getItemDrop().getItemStack().getType() != Material.getMaterial(39)
					&& e.getItemDrop().getItemStack().getType() != Material.getMaterial(40)) {
				e.setCancelled(true);
			}
		}

}
