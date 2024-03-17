package de.mxchy.kitpvp.guilogic;

import de.mxchy.kitpvp.gui.AddKitGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitItemsGUILogic {
    public static void kitItemsGUILogic(InventoryClickEvent e){

        ItemStack stack = e.getCurrentItem();
        if(stack == null){
            return;
        }


        if(stack.getType() == Material.GREEN_TERRACOTTA) {
            Inventory inventory = e.getClickedInventory();
            e.setCancelled(true);
            assert inventory != null;
            ItemStack[] stacks = new ItemStack[9];
            for(int i = 0; i<9 ;i++){
                stacks[i] = inventory.getItem(i);
            }
            AddKitGUILogic.currentKitItems = stacks;
            AddKitGUI.createAddKitGUI((Player)e.getWhoClicked(),"");

        }else if(stack.getType() == Material.GRAY_STAINED_GLASS_PANE){
            e.setCancelled(true);
        }

    }
}
