package io.github.thatsmusic99.headsplus.events;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.api.*;
import io.github.thatsmusic99.headsplus.commands.maincommand.DebugPrint;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;
import java.util.logging.Logger;

public class LBEvents implements Listener {

    @EventHandler
    public void onHeadDrop(EntityHeadDropEvent e) {
        try {
            if (!e.isCancelled()) {
                if (HeadsPlus.getInstance().isUsingLeaderboards()) {
                    if (HeadsPlus.getInstance().getConfig().getBoolean("smite-player-if-they-get-a-head")) {
                        for (int i = 0; i < 5; i++) {
                            e.getLocation().getWorld().strikeLightning(e.getPlayer().getLocation());
                        }
                    }
                    HeadsPlus.getInstance().getMySQLAPI().addOntoValue(e.getPlayer(), e.getEntityType().name(), "headspluslb", 1);
                }
            }
        } catch (Exception ex) {
            new DebugPrint(ex, "Event (LBEvents)", false, null);
        }

    }

    @EventHandler
    public void onPHeadDrop(PlayerHeadDropEvent e) {
        try {
            if (!e.isCancelled()) {
                if (HeadsPlus.getInstance().isUsingLeaderboards()) {
                    if (HeadsPlus.getInstance().getConfig().getBoolean("smite-player-if-they-get-a-head")) {
                        for (int i = 0; i < 5; i++) {
                            e.getLocation().getWorld().strikeLightning(e.getKiller().getLocation());
                        }
                    }
                    HeadsPlus.getInstance().getMySQLAPI().addOntoValue(e.getKiller(), "player", "headspluslb", 1);
                }
            }
        } catch (Exception ex) {
            new DebugPrint(ex, "Event (LBEvents)", false, null);
        }

    }

    @EventHandler
    public void onHeadSold(SellHeadEvent e) {
        try {
            if (!e.isCancelled()) {
                if (HeadsPlus.getInstance().hasChallengesEnabled()) {
                    for (int is : e.getEntityAmounts().values()) {
                        HPPlayer.getHPPlayer(e.getPlayer()).addXp(20 * is);
                    }
                    for (String s : e.getEntityAmounts().keySet()) {
                        for (int i : e.getEntityAmounts().values()) {
                            if (e.getEntityAmounts().get(s) == i) {
                                HeadsPlus.getInstance().getMySQLAPI().addOntoValue(e.getPlayer(), s, "headsplussh", i);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            new DebugPrint(ex, "Event (LBEvents)", false, null);
        }
    }

    @EventHandler
    public void onHeadCraft(HeadCraftEvent e) {
        try {
            if (!e.isCancelled()) {
                if (HeadsPlus.getInstance().hasChallengesEnabled()) {
                    if (e.getEntityType() != null) {
                        if (!e.getEntityType().equalsIgnoreCase("invalid")) {
                            HPPlayer.getHPPlayer(e.getPlayer()).addXp(30 * e.getHeadsCrafted());
                            HeadsPlus.getInstance().getMySQLAPI().addOntoValue(e.getPlayer(), e.getEntityType(), "headspluscraft", e.getHeadsCrafted());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            new DebugPrint(ex, "Event (LBEvents)", false, null);
        }
    }
}
