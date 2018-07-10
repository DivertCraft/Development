package br.com.stompamc.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

	public static ItemStack criarItem(Material mat) {
		ItemStack item = new ItemStack(mat);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, int tipo) {
		ItemStack item = new ItemStack(mat, 1, (short) tipo);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, int quantidade, String desc) {
		ItemStack item = new ItemStack(mat, quantidade);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		List<String> desc1 = new ArrayList<>();
		desc1.add(desc);
		itemm.setLore(desc1);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, int tipo, String desc) {
		ItemStack item = new ItemStack(mat, 1, (short) tipo);
		ItemMeta itemm = item.getItemMeta();
		List<String> desc1 = new ArrayList<>();
		desc1.add(desc);
		itemm.setLore(desc1);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, String desc) {
		ItemStack item = new ItemStack(mat, 1);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		List<String> desc1 = new ArrayList<>();
		desc1.add(desc);
		itemm.setLore(desc1);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, int quantidade) {
		ItemStack item = new ItemStack(mat, quantidade);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, int quantidade, int tipo) {
		ItemStack item = new ItemStack(mat, quantidade, (short) tipo);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItemInv(Material mat, String nome, int quantidade, int tipo, int slot, Inventory inv) {
		ItemStack item = new ItemStack(mat, quantidade, (short) tipo);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);

		inv.setItem(slot, item);
		return item;
	}

	public static ItemStack criarItem(Material mat, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemm = item.getItemMeta();
		itemm.addEnchant(enchant, level, true);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(mat);
		ItemMeta itemm = item.getItemMeta();
		itemm.addEnchant(enchant, level, true);
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, int tipo, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(mat, 1, (short) tipo);
		ItemMeta itemm = item.getItemMeta();
		itemm.addEnchant(enchant, level, true);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, int quantidade, Enchantment enchant, int level) {
		ItemStack item = new ItemStack(mat, quantidade);
		ItemMeta itemm = item.getItemMeta();
		itemm.addEnchant(enchant, level, true);
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItem(Material mat, String nome, int quantidade, int tipo, Enchantment enchant,
			int level) {
		ItemStack item = new ItemStack(mat, quantidade, (short) tipo);
		ItemMeta itemm = item.getItemMeta();
		itemm.addEnchant(enchant, level, true);
		itemm.setDisplayName(nome);
		item.setItemMeta(itemm);
		return item;
	}

	public static ItemStack criarItemHead(String nome, String nomeplayer) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(397));
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		item.setDurability((short) 3);
		sm.hasOwner();
		sm.setOwner(nomeplayer);
		sm.setDisplayName(nome);
		item.setItemMeta(sm);
		return item;
	}
	public static ItemStack criarItemHead(String nome, String nomeplayer, List<String> lore) {
		@SuppressWarnings("deprecation")
		ItemStack item = new ItemStack(Material.getMaterial(397));
		SkullMeta sm = (SkullMeta) item.getItemMeta();
		item.setDurability((short) 3);
	    sm.setLore(lore);
		sm.hasOwner();
		sm.setOwner(nomeplayer);
		sm.setDisplayName(nome);
		item.setItemMeta(sm);
		return item;
	}
	public static ItemStack criarArmadura(Material mat, Color cor) {
		ItemStack item = new ItemStack(mat);
		LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();
		itemm.setColor(cor);
		item.setItemMeta(itemm);
		return item;
	}

	public static int VerificarItemNoInv(Player p, Material mat) {
		int valor = 0;
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null && item.getType() == mat && item.getAmount() > 0) {
				valor += item.getAmount();
			}
		}
		return valor;
	}
}