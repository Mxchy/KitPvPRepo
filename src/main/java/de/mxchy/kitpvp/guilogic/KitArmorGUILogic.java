package de.mxchy.kitpvp.guilogic;

import de.mxchy.kitpvp.gui.AddKitGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitArmorGUILogic {
    public static void kitArmorGUILogic(InventoryClickEvent e){

        ItemStack stack = e.getCurrentItem();
        if(stack == null){
            return;
        }


        if(stack.getType() == Material.GREEN_TERRACOTTA){
            Inventory inventory = e.getClickedInventory();
            e.setCancelled(true);
            assert inventory != null;
            ItemStack helmet = inventory.getItem(10);
            ItemStack chestplate = inventory.getItem(12);
            ItemStack leggings = inventory.getItem(14);
            ItemStack boots = inventory.getItem(16);

            if(helmet != null )
                AddKitGUILogic.currentKitArmor[0] = helmet;
            if(chestplate != null )
                AddKitGUILogic.currentKitArmor[1] = chestplate;
            if(leggings != null )
                AddKitGUILogic.currentKitArmor[2] = leggings;
            if(boots != null )
                AddKitGUILogic.currentKitArmor[3] = boots;

            AddKitGUI.createAddKitGUI((Player)e.getWhoClicked(),"");

        }else if(stack.getType() == Material.GRAY_STAINED_GLASS_PANE){
            e.setCancelled(true);
        }

    }
}
