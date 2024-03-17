package de.mxchy.kitpvp.listeners;


import de.mxchy.kitpvp.arena.KitConfig;
import de.mxchy.kitpvp.kit.KitManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class MoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if (KitConfig.checkIfInArena(Objects.requireNonNull(e.getTo())) && !KitConfig.checkIfInArena(e.getFrom())) {
            e.getPlayer().sendMessage(ChatColor.GREEN + "You entered the PvP Area!");
            System.out.println(KitManager.kitArrayList.get(0).getDisplayMaterial().getType());
            KitManager.equipKit(e.getPlayer(),KitManager.kitArrayList.get(0));





        } else if (!KitConfig.checkIfInArena(e.getTo()) && KitConfig.checkIfInArena(e.getFrom())) {
            e.getPlayer().sendMessage(ChatColor.GREEN + "You left the PvP Arena!");
            e.getPlayer().getInventory().clear();

        }
    }
    }