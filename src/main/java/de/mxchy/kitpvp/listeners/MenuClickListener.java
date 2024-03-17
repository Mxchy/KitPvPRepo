package de.mxchy.kitpvp.listeners;


import de.mxchy.kitpvp.guilogic.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

public class MenuClickListener implements Listener {
    @EventHandler
    public void OnMenuClick(InventoryClickEvent e) throws IOException {

        if(e.getCurrentItem() == null){
            return;
        }
        Player player = (Player) e.getWhoClicked();
        String title = e.getView().getTitle();
        if(title.equals("Create Kit"+ ChatColor.GREEN)){
            AddKitGUILogic.addKitGUILogic(e,null);
        }
        else if(title.equals("Set the Armor of the Kit"+ ChatColor.GREEN)){
            KitArmorGUILogic.kitArmorGUILogic(e);
        }
        else if(title.equals("Set the DisplayItem of the Kit"+ ChatColor.GREEN)){
            KitDisplayItemGUILogic.kitDisplayItemGUILogic(e);
        }
        else if(title.equals("Put an Item with the Name of the Kit in the free slot"+ ChatColor.GREEN)){
            NameKitGUILogic.kitNameItemGUILogic(e);
        }
        else if(title.equals("Put the Items for the Hotbar here"+ ChatColor.GREEN)){
            KitItemsGUILogic.kitItemsGUILogic(e);
        }


    }

}
