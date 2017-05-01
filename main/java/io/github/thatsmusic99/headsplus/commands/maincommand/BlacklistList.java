package io.github.thatsmusic99.headsplus.commands.maincommand;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.HeadsPlusCommand;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;

public class BlacklistList {
	
	static String prefix = HeadsPlus.getInstance().translateMessages(ChatColor.translateAlternateColorCodes('&', HeadsPlusConfig.getMessages().getString("prefix")));
	
	public static void blacklistListNoArgs(CommandSender sender) {
		if (sender.hasPermission("headsplus.maincommand.blacklist.list")) {
			int headsN = 1;
			List<String> bl = HeadsPlus.getInstance().getConfig().getStringList("blacklist");
			int bls = bl.size();
			if (bls < 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("empty-bl"))));
				return;
			}
			while (bls > 8) {
				headsN++;
				bls = bls - 8;
			}
			sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "Blacklist: " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + "1/" + headsN + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========" );
			int TimesSent = 0;
			for (String key : bl) {
				if (TimesSent <= 7) {
					sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
					TimesSent++;
				}
			}
	    } else {
	    	sender.sendMessage(HeadsPlusCommand.noPerms);
	    }
	}
	public static void blacklistList(CommandSender sender, String i) {
		if (sender.hasPermission("headsplus.maincommand.blacklist.list")) {
			   if (i.matches("^[0-9]+$")) {
				   List<String> bl = HeadsPlus.getInstance().getConfig().getStringList("blacklist");
				   int entries = 8;
				   int page = Integer.parseInt(i);
				   int sIndex = (page - 1) * entries;
				   int eIndex = entries + sIndex;
				   if (eIndex > bl.size()) {
				 	   eIndex = bl.size();
				   }
				   int pages = 1;
				   int bls = bl.size();
				   while (bls > 8) {
					   pages++;
					   bls = bls - 8;
				   }
				  
				   if ((page > pages) || (0 >= page)) {
					   sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("invalid-pg-no"))));
				   } else {
					   sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + "============ " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor2")) + "Blacklist: " + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor3")) + page + "/" + pages + ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor1")) + " ==========");
			           List<String> blsl = bl.subList(sIndex, eIndex);
				       for (String key : blsl) {
				           sender.sendMessage(ChatColor.valueOf(HeadsPlus.getInstance().getConfig().getString("themeColor4")) + key);
				       }
				   }
	       } else {
		       sender.sendMessage(prefix + " " + ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(HeadsPlusConfig.getMessages().getString("invalid-input-int"))));	  
		   }
	} else {
    	sender.sendMessage(HeadsPlusCommand.noPerms);
    }
	}

}
