package de.mxchy.kitpvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitItemsGUI {
    public static void createKitItemsGUI(Player player){
        Inventory gui = Bukkit.createInventory(player,18,"Put the Items for the Hotbar here"+ ChatColor.GREEN);

        ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta paneMeta = pane.getItemMeta();
        assert paneMeta != null;
        paneMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        paneMeta.setDisplayName(ChatColor.BLUE+"");
        pane.setItemMeta(paneMeta);



        ItemStack confirm = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta confirmMeta = confirm.getItemMeta();
        assert confirmMeta != null;
        confirmMeta.setDisplayName("Click to confirm"+ChatColor.GREEN);
        confirm.setItemMeta(confirmMeta);

        for (int i = 9; i<18 ;i++){
            gui.setItem(i,pane);
        }

        gui.setItem(17,confirm);


        player.openInventory(gui);
    }
}
