package io.github.thatsmusic99.headsplus.events;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.maincommand.DebugPrint;
import io.github.thatsmusic99.headsplus.util.DebugFileCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlaceEvent implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        try {
            if (HeadsPlus.getInstance().isStoppingPlaceableHeads()) {
                if (e.getItemInHand().getType() == Material.SKULL || e.getItemInHand().getType() == Material.SKULL_ITEM) {
                    if (!e.getPlayer().hasPermission("headsplus.bypass.preventplacement")) {
                        if (e.getItemInHand().getItemMeta().getLore() != null) {
                            List<String> ls = new ArrayList<>();
                            for (String str : HeadsPlus.getInstance().getConfig().getStringList("lore")) {
                                ls.add(ChatColor.translateAlternateColorCodes('&', ChatColor.stripColor(str)));
                            }
                            if (e.getItemInHand().getItemMeta().getLore().equals(ls)) {
                                e.setCancelled(true);
                                e.getPlayer().sendMessage(HeadsPlus.getInstance().getMessagesConfig().getString("block-place-denied"));
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            new DebugPrint(ex, "Event (PlaceEvent)", false, null);
        }
    }
}
