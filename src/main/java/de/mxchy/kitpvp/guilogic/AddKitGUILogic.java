package de.mxchy.kitpvp.guilogic;


import de.mxchy.kitpvp.gui.KitArmorGUI;
import de.mxchy.kitpvp.gui.KitDisplayItemGUI;
import de.mxchy.kitpvp.gui.KitItemsGUI;
import de.mxchy.kitpvp.gui.KitNameGUI;
import de.mxchy.kitpvp.kit.KitManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class AddKitGUILogic {
    public static ItemStack[] currentKitArmor = new ItemStack[4];
    public static ItemStack[] currentKitItems = new ItemStack[9];
    public static ItemStack currentDisplayItem;
    public static String currentKitName;

    public static void addKitGUILogic(InventoryClickEvent e, String kitName) throws IOException {
        ItemStack stack = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);
        switch (stack.getType()){
            case OAK_SIGN:
                KitNameGUI.createKitNameGUI(player);
                break;
            case ARMOR_STAND:
                KitArmorGUI.createKitArmorGUI(player);
                break;
            case GREEN_TERRACOTTA:

                KitManager.createNewKit(currentKitName,currentDisplayItem,currentKitArmor,currentKitItems);
                player.closeInventory();
                break;
            case ITEM_FRAME:
                KitDisplayItemGUI.createDisplayItemGUI(player);
                break;
            case CHEST:
                KitItemsGUI.createKitItemsGUI(player);
                break;


        }

    }


}
