package de.mxchy.kitpvp.commands;

import de.mxchy.kitpvp.gui.AddKitGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddKit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        AddKitGUI.createAddKitGUI((Player) sender,"");
        return true;
    }

}
