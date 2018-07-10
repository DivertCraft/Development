package br.com.stompamc.comando;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.stompamc.Strings;

public class Tell implements CommandExecutor {
	
	  public static HashMap<Player, Player> gettell = new HashMap<>();
	  public static ArrayList<Player> telloff = new ArrayList<>();

	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if (label.equalsIgnoreCase("tell")) {
	      if (args.length == 0) {
	        p.sendMessage(Strings.prefix + "§cUse: /tell <nick> <messagem>");
	        return true;
	      }
	      Player target = Bukkit.getPlayer(args[0]);
	      if (args[0].toLowerCase().equalsIgnoreCase("on")) {
	        telloff.remove(p);
	        p.sendMessage(Strings.prefix + "§aO seu tell foi ativo.");
	      } else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
	        telloff.add(p);
	        p.sendMessage(Strings.prefix + "§cO seu tell foi desativado.");
	      }
	      if (args.length > 1) {
	        if (target == null) {
	          p.sendMessage(Strings.prefix + "§cO jagador esta offline ou nao existe.");
	          return true;
	        }
	        if (telloff.contains(target)) {
	          p.sendMessage(Strings.prefix + "§cO jogador: §7" + target.getName() + " §cesta com o tell desativado.");
	          return true;
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i = 1; i < args.length; i++) {
	          sb.append(args[i]).append(" ");
	        }
	        String allArgs = sb.toString().trim();
	        p.sendMessage("§b§lTELL §f" + target.getName() + "§8: §7" + allArgs);
	        target.sendMessage("§b§lTELL §f" + p.getName() + "§8: §7" + allArgs);
	        gettell.put(p, target);
	        gettell.put(target, p);
	      }
	    } else if (label.equalsIgnoreCase("r")) {
	      if (args.length == 0) {
	        p.sendMessage(Strings.prefix + "§cUse: /r <messagem>");
	        return true;
	      }
	      if (!gettell.containsKey(p)) {
	        p.sendMessage(Strings.prefix + "§cVocê não tem ninguém para responder");
	        return true;
	      }
	      Player deslogo = (Player)gettell.get(p);
	      if (deslogo == null) {
	        p.sendMessage(Strings.prefix + "§cO jagador esta offline ou nao existe.");
	        return true;
	      }
	      if (telloff.contains(deslogo)) {
	        p.sendMessage(Strings.prefix + "§cO jogador: §7" + deslogo.getName() + " §cesta com o tell desativado.");
	        return true;
	      }
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < args.length; i++) {
	        sb.append(args[i]).append(" ");
	      }
	      String allArgs = sb.toString().trim();
	      p.sendMessage("§b§lTELL §f" + deslogo.getName() + "§8: §7" + allArgs);
	      deslogo.sendMessage("§b§lTELL §f" + p.getName() + "§8: §7" + allArgs);
	    }
	    return false;
	  }

}