package io.github.thatsmusic99.headsplus.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.HeadsPlusConfig;
import io.github.thatsmusic99.headsplus.HeadsPlusConfigHeads;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class SellHead implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			PlayerInventory inv = ((Player) sender).getInventory();
		    ItemStack invi = inv.getItemInMainHand();
		    if (invi.equals(Material.SKULL_ITEM)) {
		    	ItemStack skull = new ItemStack(Material.SKULL_ITEM, (byte) 3);
		    	SkullMeta skullM = (SkullMeta) skull.getItemMeta();
		    	String owner = skullM.getOwner();
		    	if (skullM.getLore().get(0) == " ") {
		    		Economy econ = null;
		    		if (owner == HeadsPlusConfigHeads.getHeads().getString("zombieHeadN")) {
		    			Double price = HeadsPlusConfigHeads.getHeads().getDouble("zombieHeadP");
		    			String senderName = sender.getName();
						@SuppressWarnings({ "deprecation", "null" })
						EconomyResponse zr = econ.depositPlayer(senderName, price);
						String success = HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("sell-success"));
						success = ChatColor.translateAlternateColorCodes('&', success);
						String fail = HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("sell-fail"));
						fail = ChatColor.translateAlternateColorCodes('&', fail);
						if (zr.transactionSuccess()) {
							((Player) sender).getInventory().remove(skull);
							sender.sendMessage(success);
						} else {
							sender.sendMessage(fail + ": " + zr.errorMessage);
						}
		    		} else {
		    		    sender.sendMessage("Ping"); // TODO Add undefined message.
		    	    }
		    	} else {
		    		String falseHead = HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("false-head"));
		    		falseHead = ChatColor.translateAlternateColorCodes('&', falseHead);
		    		sender.sendMessage(falseHead);
		    	} 
		    	
		    } else {
		    	sender.sendMessage("Pong"); // TODO Add incorrect item message
		    	sender.sendMessage(invi.toString());
		    }
		
		} else {
			sender.sendMessage("[HeadsPlus] You must be a player to send this command!");
		}
		return false;
	}

}