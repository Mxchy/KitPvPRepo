package de.mxchy.kitpvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitArmorGUI {
    public static void createKitArmorGUI(Player player){
        Inventory gui = Bukkit.createInventory(player,27,"Set the Armor of the Kit"+ ChatColor.GREEN);

        ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta paneMeta = pane.getItemMeta();
        assert paneMeta != null;
        paneMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        paneMeta.setDisplayName(ChatColor.BLUE+"");
        pane.setItemMeta(paneMeta);

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        assert chestplateMeta != null;
        chestplateMeta.setDisplayName("Drag the chestplate under this slot");
        chestplate.setItemMeta(chestplateMeta);

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        assert helmetMeta != null;
        helmetMeta.setDisplayName("Drag the helmet under this slot");
        helmet.setItemMeta(helmetMeta);

        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        assert leggingsMeta != null;
        leggingsMeta.setDisplayName("Drag the leggings under this slot");
        leggings.setItemMeta(leggingsMeta);

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        assert bootsMeta != null;
        bootsMeta.setDisplayName("Drag the boots under this slot");
        boots.setItemMeta(bootsMeta);

        ItemStack confirm = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta confirmMeta = confirm.getItemMeta();
        assert confirmMeta != null;
        confirmMeta.setDisplayName("Click to confirm"+ChatColor.GREEN);
        confirm.setItemMeta(confirmMeta);

        for (int i = 0; i<27 ;i++){
            gui.setItem(i,pane);
        }
        gui.setItem(1,helmet);
        gui.setItem(3,chestplate);
        gui.setItem(5,leggings);
        gui.setItem(7,boots);
        gui.setItem(26,confirm);
        gui.setItem(10,null);
        gui.setItem(12,null);
        gui.setItem(14,null);
        gui.setItem(16,null);

        player.openInventory(gui);
    }
}

