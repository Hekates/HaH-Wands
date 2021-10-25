package ch.hekates.wands.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import ch.hekates.wands.spells.Protego;

public class ProtegoListener implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) return;
        if (event.getItem() == null) return;
        if (event.getItem().getType() != Material.STICK) return;
        if (!event.getItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_ENCHANTS)) return;

        Protego.use(event.getPlayer());
    }

}
