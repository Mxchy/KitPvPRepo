package de.mxchy.kitpvp.kit;

import de.mxchy.kitpvp.arena.KitConfig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

public class KitManager {
    public static ArrayList<Kit> kitArrayList = new ArrayList<>();
    public static void createNewKit(String displayName,ItemStack displayItem,ItemStack[] armor, ItemStack[] items ) throws IOException {
     Kit kit = new Kit(displayName,displayItem,items,armor);
     kitArrayList.add(kit);
     KitConfig.saveKitConfig(kit);

    }
    public static void equipKit(Player p, Kit kit){
        System.out.println(kit.getName());
        System.out.println(kit.getDisplayMaterial().getType());
        for (ItemStack stack :
                kit.getItems()) {
            System.out.println(stack.getType());
        }
        p.getInventory().clear();
        for (ItemStack stack:kit.getItems()) {
            p.getInventory().addItem(stack);
        }
       // p.getInventory().setArmorContents(kit.getItems());
        
    }
}
