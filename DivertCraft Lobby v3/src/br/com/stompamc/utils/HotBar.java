package br.com.stompamc.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class HotBar {
	
	public static void pegaritens(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		ItemStack stack = new ItemStack(Material.COMPASS);
		ItemMeta meta = stack.getItemMeta();
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7  ");
		lore.add("§7Clique com o botão direito para");
		lore.add("§7abrir a lista de servidores.");
		meta.setLore(lore);
		
		meta.setDisplayName("§aServidores §7[Clique]");
		stack.setItemMeta(meta);
		
		
		//
		
		ItemStack stack1 = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		
		SkullMeta skull = (SkullMeta) stack1.getItemMeta();
		skull.setOwner(player.getName());
		
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add("§7  ");
		lore1.add("§7Clique com o botão direito para");
		lore1.add("§7abrir o menu com suas informações.");
		skull.setLore(lore1);
		
		skull.setDisplayName("§aSeu Perfil §7[Clique]");
		stack1.setItemMeta(skull);
		
		//
		
		//ItemStack stack4 = new ItemStack(Material.NAME_TAG);
		//ItemMeta meta4 = stack4.getItemMeta();
		//
		//ArrayList<String> lore4 = new ArrayList<String>();
		//lore4.add("§7  ");
		//lore4.add("§7Clique com o botão direito para");
		//lore4.add("§7abrir o menu informativo sobre o servidor.");
		//meta4.setLore(lore4);
		//
		//meta4.setDisplayName("§aInformaçoes §7[Clique]");
		//stack4.setItemMeta(meta4);
		
        //
		
		//ItemStack stack7 = new ItemStack(Material.FIREWORK);
		//ItemMeta meta7 = stack7.getItemMeta();
		
		//ArrayList<String> lore7 = new ArrayList<String>();
		//lore7.add("§7  ");
		//lore7.add("§7Clique com o botão direito para");
		//lore7.add("§7dar double jumps pelo mapa.");
		//meta7.setLore(lore7);
		
		//meta7.setDisplayName("§aKangaroo §7[Diversão]");
		//stack7.setItemMeta(meta7);
		

        //
		
		//ItemStack stackn = new ItemStack(Material.GLASS, 1, (short) 14);
		//ItemMeta metan = stackn.getItemMeta();
		//
		//ArrayList<String> loren = new ArrayList<String>();
		//loren.add("§7  ");
		//loren.add("§7Esse item ainda não foi");
		//loren.add("§7adicionado ao servidor.");
		//metan.setLore(loren);
		//
		//metan.setDisplayName("§cEm Breve §7(Diversão)");
		//stackn.setItemMeta(metan);
		
		
		
		player.getInventory().setItem(6, stack);
		
		//player.getInventory().setItem(3, stackn);
		player.getInventory().setItem(5, stack1);
		//player.getInventory().setItem(5, stack7);
		
		//player.getInventory().setItem(7, stack4);
	}

}