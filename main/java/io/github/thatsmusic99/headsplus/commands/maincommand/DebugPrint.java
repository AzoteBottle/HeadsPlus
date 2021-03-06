package io.github.thatsmusic99.headsplus.commands.maincommand;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.api.HPPlayer;
import io.github.thatsmusic99.headsplus.commands.IHeadsPlusCommand;
import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.nms.NMSManager;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

public class DebugPrint implements IHeadsPlusCommand {

    public DebugPrint(Exception e, String name, boolean command, CommandSender sender) {
        Logger log = HeadsPlus.getInstance().getLogger();
        ConfigurationSection cs = HeadsPlus.getInstance().getConfiguration().getMechanics();
        if (cs.getBoolean("debug.print-stacktraces-in-console")) {
            e.printStackTrace();
        }
        if (command) {
            sender.sendMessage(HeadsPlus.getInstance().getMessagesConfig().getString("cmd-fail"));
        }

        if (cs.getBoolean("debug.create-debug-files")) {
            log.severe("HeadsPlus has failed to execute this task. An error report has been made in /plugins/HeadsPlus/debug");
            try {
                String s = new DebugFileCreator().createReport(e, name);
                log.severe("Report name: " + s);
                log.severe("Please submit this report to the developer at one of the following links:");
                log.severe("https://github.com/Thatsmusic99/HeadsPlus/issues");
                log.severe("https://discord.gg/nbT7wC2");
                log.severe("https://www.spigotmc.org/threads/headsplus-1-8-x-1-12-x.237088/");
            } catch (IOException e1) {
                if (cs.getBoolean("debug.print-stacktraces-in-console")) {
                    e1.printStackTrace();
                }
            }
        }

    }
    public DebugPrint() {

    }
    @Override
    public String getCmdName() {
        return "debug";
    }

    @Override
    public String getPermission() {
        return "headsplus.maincommand.debug";
    }

    @Override
    public String getCmdDescription() {
        return LocaleManager.getLocale().descDebug();
    }

    @Override
    public String getSubCommand() {
        return "Debug";
    }

    @Override
    public String getUsage() {
        return "/hp debug <dump|head|player> <Player IGN>";
    }

    @Override
    public HashMap<Boolean, String> isCorrectUsage(String[] args, CommandSender sender) {
        HashMap<Boolean, String> h = new HashMap<>();
        if (args.length > 1) {
            if(args[1].equalsIgnoreCase("dump")) {
                h.put(true, "");
            } else if (args[1].equalsIgnoreCase("head")) {
                if (sender instanceof Player) {
                    NMSManager nms = HeadsPlus.getInstance().getNMS();
                    if (nms.getItemInHand((Player) sender) != null) {
                        if (nms.getItemInHand((Player) sender).getType().equals(nms.getSkullMaterial(1).getType())) {
                            h.put(true, "");
                        } else {
                            h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("false-head"));
                        }
                    } else {
                        h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("false-head"));
                    }
                } else {
                    h.put(false, "[HeadsPlus] You have to be a player to run this command!");
                }
            } else if (args[1].equalsIgnoreCase("player")) {
                if (args.length > 2) {
                    HPPlayer pl = HPPlayer.getHPPlayer(Bukkit.getOfflinePlayer(args[2]));
                    if (pl.getCompleteChallenges().size() > 0) {
                        h.put(true, "");
                    } else {
                        h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("no-data"));
                    }
                } else {
                    h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("invalid-args"));
                }
            } else {
                h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("invalid-args"));
            }
        } else {
            h.put(false, HeadsPlus.getInstance().getMessagesConfig().getString("invalid-args"));
        }
        return h;
    }

    @Override
    public boolean isMainCommand() {
        return true;
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
        try {
            if (args[1].equalsIgnoreCase("dump")) {
                String s = new DebugFileCreator().createReport(null, "Debug command");
                sender.sendMessage(ChatColor.GREEN + "Report name: " + s);
            } else if (args[1].equalsIgnoreCase("head")) {
                ItemStack is = HeadsPlus.getInstance().getNMS().getItemInHand((Player) sender);
                String s = new DebugFileCreator().createHeadReport(is);
                sender.sendMessage(ChatColor.GREEN + "Report name: " + s);
            } else if (args[1].equalsIgnoreCase("player")) {
                OfflinePlayer pl = Bukkit.getOfflinePlayer(args[2]);
                String s = new DebugFileCreator().createPlayerReport(HPPlayer.getHPPlayer(pl));
                sender.sendMessage(ChatColor.GREEN + "Report name: " + s);
            }
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            if (HeadsPlus.getInstance().getConfiguration().getMechanics().getBoolean("debug.print-stacktraces-in-console")) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
