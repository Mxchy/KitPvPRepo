package de.mxchy.kitpvp.kit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Kit {
    String name;

    public String getName() {
        return name;
    }

    public ItemStack getDisplayMaterial() {
        return displayMaterial;
    }

    public ItemStack[] getItems() {
        return items;
    }

    public ItemStack[] getArmorContent() {
        return armorContent;
    }

    ItemStack displayMaterial;
    ItemStack[] items = new ItemStack[9];

    ItemStack[] armorContent = new ItemStack[4];

   public Kit(String _name, ItemStack _displayMaterial, ItemStack[] _items,ItemStack[] _armorContent){
        this.name = _name;
        this.displayMaterial = _displayMaterial;

        System.arraycopy(_armorContent, 0, this.armorContent, 0, _armorContent.length);
        System.arraycopy(_items,0,this.items,0,_items.length);
    }


}
