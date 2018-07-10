package br.com.stompamc.bungee.api;

public class ServersBungeeName {
	
	public static String all;
	public static String lobby;
	public static String ss;
	
	public static String fullpvp;
	public static String kitpvp;
	public static String rankup;
	
	public static String escolher(String server) {
		if (server.equalsIgnoreCase("all")) {
			return all;
		} else if (server.equalsIgnoreCase("lobby")) {
			return lobby;
		} else if (server.equalsIgnoreCase("kitpvp")) {
			return kitpvp;
		} else if (server.equalsIgnoreCase("ss")) {
			return ss;
		} else if (server.equalsIgnoreCase("rankup")) {
			return rankup;
		}else {
			return "§cVerifique o nome do servidor.";
		}
	}
}
