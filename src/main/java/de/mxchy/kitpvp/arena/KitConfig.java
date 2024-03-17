package de.mxchy.kitpvp.arena;

import de.mxchy.kitpvp.kit.Kit;
import de.mxchy.kitpvp.kit.KitManager;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class KitConfig  {
    public static File kitConfigFile = new File("plugins/kitpvp", "kitconfig.yml");
    public static FileConfiguration kitConfig = YamlConfiguration.loadConfiguration(kitConfigFile);

    public static void save() throws IOException {
        kitConfig.save(kitConfigFile);
    }
    public static boolean setArenaCoord1(Location loc, Player p) throws IOException {
        String worldName = (String) kitConfig.get("arena.arena_pos2.world");
        if(worldName != null) {
            if (!worldName.equals(Objects.requireNonNull(loc.getWorld()).getName())) {
                p.sendMessage("The Coordinates have to be in the same world");
                return false;
            }
        }

        kitConfig.set("arena.arena_pos1.x", loc.getBlock().getLocation().getX());
        kitConfig.set("arena.arena_pos1.y", loc.getBlock().getLocation().getY());
        kitConfig.set("arena.arena_pos1.z", loc.getBlock().getLocation().getZ());
        kitConfig.set("arena.arena_pos1.world", Objects.requireNonNull(loc.getWorld()).getName());


        save();
        return true;
    }
    public static boolean setArenaCoord2(Location loc, Player p) throws IOException {
        String worldName = (String) kitConfig.get("arena.arena_pos1.world");
        if (worldName != null) {
            if (!worldName.equals(Objects.requireNonNull(loc.getWorld()).getName())) {
                p.sendMessage("The Coordinates have to be in the same world");
                return false;
            }
        }

        kitConfig.set("arena.arena_pos2.x", loc.getBlock().getLocation().getX());
        kitConfig.set("arena.arena_pos2.y", loc.getBlock().getLocation().getY());
        kitConfig.set("arena.arena_pos2.z", loc.getBlock().getLocation().getZ());
        kitConfig.set("arena.arena_pos2.world", Objects.requireNonNull(loc.getWorld()).getName());
        save();
        return true;
    }
    public static void clearArenaCoords(){
        Map<String, Object> configValues = kitConfig.getValues(false);
        for (Map.Entry<String, Object> entry : configValues.entrySet()) {
            kitConfig.set(entry.getKey(), null);
        }
    }
    public static boolean checkIfInArena(Location location) {
        int loc1X = kitConfig.getInt("arena.arena_pos1.x");
        int loc1Y = kitConfig.getInt("arena.arena_pos1.y");
        int loc1Z = kitConfig.getInt("arena.arena_pos1.z");
        //TODO
        Location loc1 = new Location(location.getWorld(), loc1X, loc1Y, loc1Z);


        int loc2X = kitConfig.getInt("arena.arena_pos2.x");
        int loc2Y = kitConfig.getInt("arena.arena_pos2.y");
        int loc2Z = kitConfig.getInt("arena.arena_pos2.z");
        //TODO
        Location loc2 = new Location(location.getWorld(), loc2X, loc2Y, loc2Z);




        if ((location.getBlockX() > loc1.getBlockX()) && (location.getBlockX() < loc2.getBlockX())) {
            if ((location.getBlockY() > loc1.getBlockY()) && (location.getBlockY() < loc2.getBlockY())) {
                if ((location.getBlockZ() > loc1.getBlockZ()) && (location.getBlockZ() < loc2.getBlockZ())) {
                    return true;
                }
            }
        }
        return false;

    }
    public static void saveKitConfig(Kit kit) throws IOException {

        List<String > kitNames = new ArrayList<>();
        for(Kit kit1 : KitManager.kitArrayList){
            kitNames.add(kit1.getName());
        }
        kitConfig.set("kits.names",kitNames);

        String kitName = kit.getName();
        kitConfig.set("kits."+kit.getName()+".name".toLowerCase(),kitName);

        ItemStack kitDisplay = kit.getDisplayMaterial();
        Map<String, Object> kitDisplayMap = kitDisplay.serialize();
        kitConfig.set("kits."+kit.getName()+".display".toLowerCase(),kitDisplayMap);

        ItemStack[] kitArmorItems = kit.getArmorContent();
        List<Map<String,Object>> kitArmorItemsMap = new ArrayList<>();
        for(ItemStack stack: kitArmorItems){
            kitArmorItemsMap.add(stack.serialize());
        }
        kitConfig.set("kits."+kit.getName()+".armor".toLowerCase(),kitArmorItemsMap);

        ItemStack[] kitItems = kit.getArmorContent();
        List<Map<String,Object>> kitItemsMap = new ArrayList<>();
        for(ItemStack stack: kitItems){
            kitItemsMap.add(stack.serialize());
        }

        kitConfig.set("kits."+kit.getName()+".inventory".toLowerCase(),kitItemsMap);
        save();

    }
    public static void loadKits(){

        List<String> names = (List<String>) kitConfig.getList("kits.names");
        if(names ==null){
            return;
        }
        for(int i = 0; i < Objects.requireNonNull(names).size(); i++){
            String name = names.get(i);
            Object map = kitConfig.get("kits."+name+"display");
            ItemStack stack = ItemStack.deserialize((Map<String, Object>) map);
            ItemStack kitDisplay = kitConfig.getItemStack("kits."+name+".display");
            System.out.println(stack.getType());
            List<Map<?, ?>> kitArmorItemsMap = kitConfig.getMapList("kits."+name+".display");
            ItemStack[] armorItems = new ItemStack[4];
            for (int j = 0; j<kitArmorItemsMap.size(); j++) {
                ItemStack armorItem = ItemStack.deserialize((Map<String, Object>) kitArmorItemsMap.get(i));
                armorItems[i] = armorItem;
            }

            List<Map<?, ?>> kitItemsMap = kitConfig.getMapList("kits."+name+".display");
            ItemStack[] items = new ItemStack[9];
            for (int j = 0; j<kitItemsMap.size(); j++) {
                ItemStack item = ItemStack.deserialize((Map<String, Object>) kitItemsMap.get(i));
                items[i] = item;
            }
            Kit kit= new Kit(name,kitDisplay,items,armorItems);
            KitManager.kitArrayList.add(kit);



        }
    }



}
