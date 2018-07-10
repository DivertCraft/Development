package br.com.stompamc.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import br.com.stompamc.Main;

public class ScoreboardUpdater {
	
	public static void Score(Player player) {
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		player.setScoreboard(scoreboard);
		  
		Main.scoreboard.put(player, new ScoreboardHelper(scoreboard, "§6§lREDE DIVERT"));	
	}

}
