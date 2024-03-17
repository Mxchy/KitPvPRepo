package de.mxchy.kitpvp;

import de.mxchy.kitpvp.arena.KitConfig;
import de.mxchy.kitpvp.commands.AddKit;
import de.mxchy.kitpvp.commands.ClearArenaCoord;
import de.mxchy.kitpvp.commands.SetArenaCoord;
import de.mxchy.kitpvp.listeners.InteractListener;
import de.mxchy.kitpvp.listeners.MenuClickListener;
import de.mxchy.kitpvp.listeners.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;

public final class Kitpvp extends JavaPlugin {
    public static Plugin plugin;


    @Override
    public void onEnable() {

        plugin = this;
        try {
            KitConfig.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        KitConfig.loadKits();
        registerEvents();
        registerCommands();

        System.out.println("plugin started");

    }

    @Override
    public void onDisable() {
        System.out.println("plugin stopped");

    }




    void registerCommands(){
        Objects.requireNonNull(getCommand("setarena")).setExecutor(new SetArenaCoord());
        Objects.requireNonNull(getCommand("cleararena")).setExecutor(new ClearArenaCoord());
        getCommand("addkit").setExecutor(new AddKit());
    }
    void registerEvents(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new InteractListener(), this);
        pluginManager.registerEvents(new MoveListener(),this);
        pluginManager.registerEvents(new MenuClickListener(),this);

    }

}
