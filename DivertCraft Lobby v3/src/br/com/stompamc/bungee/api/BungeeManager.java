package br.com.stompamc.bungee.api;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;



public class BungeeManager {
	
	public static int servidorQueVoceDeseja;
	
	public static void writeCount(String server) {


	    ByteArrayDataOutput out = ByteStreams.newDataOutput();
	    out.writeUTF("PlayerCount");
	    out.writeUTF(server);
	   // fake.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}
}
