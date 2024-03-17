package de.mxchy.kitpvp.guilogic;

import de.mxchy.kitpvp.gui.AddKitGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;


public class NameKitGUILogic {

    public static void kitNameItemGUILogic(InventoryClickEvent e){

        ItemStack stack = e.getCurrentItem();
        if(stack == null){
            return;
        }


        if(stack.getType() == Material.GREEN_TERRACOTTA) {
            Inventory inventory = e.getClickedInventory();

            assert inventory != null;
            ItemStack displayItem = inventory.getItem(5);


            if (displayItem != null){
                ItemMeta meta = displayItem.getItemMeta();


                AddKitGUILogic.currentKitName = meta.getDisplayName();
                AddKitGUI.createAddKitGUI((Player)e.getWhoClicked(),"");

            }
            else {
                e.getWhoClicked().sendMessage("You need to set the name of the kit first!");
            }

            e.setCancelled(true);

        }else if(stack.getType() == Material.GRAY_STAINED_GLASS_PANE){
            e.setCancelled(true);
        }

    }
}
