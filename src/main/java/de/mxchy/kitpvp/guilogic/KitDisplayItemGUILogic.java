package de.mxchy.kitpvp.guilogic;

import de.mxchy.kitpvp.gui.AddKitGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitDisplayItemGUILogic {
    public static void kitDisplayItemGUILogic(InventoryClickEvent e){

        ItemStack stack = e.getCurrentItem();
        if(stack == null){
            return;
        }


        if(stack.getType() == Material.GREEN_TERRACOTTA) {
            Inventory inventory = e.getClickedInventory();
            e.setCancelled(true);
            assert inventory != null;
            ItemStack displayItem = inventory.getItem(5);


            if (displayItem != null){
                AddKitGUILogic.currentDisplayItem = displayItem;
            }
            else {
                e.getWhoClicked().sendMessage("You need to select a display-item first!");
            }

            AddKitGUI.createAddKitGUI((Player)e.getWhoClicked(),"");

        }else if(stack.getType() == Material.GRAY_STAINED_GLASS_PANE){
            e.setCancelled(true);
        }

    }
}
