package de.mxchy.kitpvp.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AddKitGUI {
    public static void createAddKitGUI(Player p,String kitName){
        Inventory gui = Bukkit.createInventory(p,27,"Create Kit"+ ChatColor.GREEN);

        ItemStack pane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta paneMeta = pane.getItemMeta();
        assert paneMeta != null;
        paneMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        paneMeta.setDisplayName(ChatColor.BLUE+"");
        pane.setItemMeta(paneMeta);


        ItemStack kitNameStack = new ItemStack(Material.OAK_SIGN);
        ItemMeta kitNameMeta = kitNameStack.getItemMeta();
        assert kitNameMeta != null;
        if(kitName.equals("")) {
            kitNameMeta.setDisplayName(ChatColor.BLUE + "");
        }
        else{
            kitNameMeta.setDisplayName(kitName);
        }
        List<String> kitNameLore = new ArrayList<>();
        kitNameLore.add("Click to set the Kits Name"+ChatColor.GREEN);
        kitNameMeta.setLore(kitNameLore);
        kitNameStack.setItemMeta(kitNameMeta);

        ItemStack kitDisplay = new ItemStack(Material.ITEM_FRAME);
        ItemMeta kitDisplayMeta = kitDisplay.getItemMeta();
        assert kitDisplayMeta != null;
        kitDisplayMeta.setDisplayName(ChatColor.BLUE+"");
        List<String> kitDisplayLore = new ArrayList<>();
        kitDisplayLore.add("Click to set the Kits display item"+ChatColor.GREEN);
        kitDisplayMeta.setLore(kitDisplayLore);
        kitDisplay.setItemMeta(kitDisplayMeta);

        ItemStack kitArmor = new ItemStack(Material.ARMOR_STAND);
        ItemMeta kitArmorMeta = kitArmor.getItemMeta();
        assert kitArmorMeta != null;
        kitArmorMeta.setDisplayName("Click to set the kits armor");
        kitArmor.setItemMeta(kitArmorMeta);

        ItemStack kitInventory = new ItemStack(Material.CHEST);
        ItemMeta kitInventoryItemMeta = kitInventory.getItemMeta();
        assert kitInventoryItemMeta != null;
        kitInventoryItemMeta.setDisplayName("Click to set the kits inventory content");
        kitInventory.setItemMeta(kitInventoryItemMeta);

        ItemStack createKit = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta createKitMeta = createKit.getItemMeta();
        assert createKitMeta != null;
        createKitMeta.setDisplayName("Create Kit");
        createKit.setItemMeta(createKitMeta);

        for (int i = 0; i<27 ;i++){
            gui.setItem(i,pane);
        }
        gui.setItem(10,kitNameStack);
        gui.setItem(12,kitDisplay);
        gui.setItem(14,kitArmor);
        gui.setItem(16,kitInventory);
        gui.setItem(26,createKit);

        p.openInventory(gui);
    }
}
