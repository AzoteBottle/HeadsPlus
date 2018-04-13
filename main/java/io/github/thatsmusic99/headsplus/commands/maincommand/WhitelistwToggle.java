package io.github.thatsmusic99.headsplus.commands.maincommand;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.IHeadsPlusCommand;
import io.github.thatsmusic99.headsplus.config.HeadsPlusConfig;
import io.github.thatsmusic99.headsplus.locale.LocaleManager;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.logging.Logger;

public class WhitelistwToggle implements IHeadsPlusCommand{

    private final FileConfiguration config = HeadsPlus.getInstance().getConfig();
    private final HeadsPlusConfig hpc = HeadsPlus.getInstance().hpc;

    @Override
    public String getCmdName() {
        return "whitelistw";
    }

    @Override
    public String getPermission() {
        return "headsplus.maincommand.whitelistw.toggle";
    }

    @Override
    public String getCmdDescription() {
        return LocaleManager.getLocale().descWhitelistwToggle();
    }

    @Override
    public String getSubCommand() {
        return "Whitelistw";
    }

    @Override
    public String getUsage() {
        return "/hp whitelistw [On|Off]";
    }

    @Override
    public boolean isMainCommand() {
        return true;
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
        try {
            if (args.length == 1) {
                if (config.getBoolean("whitelistwOn")) {
                    config.set("whitelistwOn", false);
                    config.options().copyDefaults(true);
                    HeadsPlus.getInstance().saveConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-off"))));
                } else if (!config.getBoolean("whitelistwOn")) {
                    config.set("whitelistwOn", true);
                    config.options().copyDefaults(true);
                    HeadsPlus.getInstance().saveConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-on"))));
                }
            } else {
                String str = args[1];
                if (str.equalsIgnoreCase("on")) {
                    if (!config.getBoolean("whitelistwOn")) {
                        config.set("whitelistwOn", true);
                        config.options().copyDefaults(true);
                        HeadsPlus.getInstance().saveConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-on"))));
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-a-on"))));
                    }
                } else if (str.equalsIgnoreCase("off")) {
                    if (config.getBoolean("whitelistwOn")) {
                        config.set("whitelistwOn", false);
                        config.options().copyDefaults(true);
                        HeadsPlus.getInstance().saveConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-off"))));
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HeadsPlus.getInstance().translateMessages(hpc.getConfig().getString("wlw-a-off"))));
                    }
                } else {
                    sender.sendMessage(ChatColor.DARK_RED + "Usage: " + ChatColor.RED + "/headsplus whitelistw [On|Off]");
                }
            }
        } catch (Exception e) {
            if (HeadsPlus.getInstance().getConfig().getBoolean("debug.print-stacktraces-in-console")) {
                e.printStackTrace();
            }
            if (HeadsPlus.getInstance().getConfig().getBoolean("debug.create-debug-files")) {
                Logger log = HeadsPlus.getInstance().getLogger();
                log.severe("HeadsPlus has failed to execute this command. An error report has been made in /plugins/HeadsPlus/debug");
                try {
                    String s = new DebugFileCreator().createReport(e, "Subcommand (whitelistw)");
                    log.severe("Report name: " + s);
                    log.severe("Please submit this report to the developer at one of the following links:");
                    log.severe("https://github.com/Thatsmusic99/HeadsPlus/issues");
                    log.severe("https://discord.gg/nbT7wC2");
                    log.severe("https://www.spigotmc.org/threads/headsplus-1-8-x-1-12-x.237088/");
                } catch (IOException e1) {
                    if (HeadsPlus.getInstance().getConfig().getBoolean("debug.print-stacktraces-in-console")) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        return false;
    }
}
