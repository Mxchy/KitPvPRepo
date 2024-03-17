package de.mxchy.kitpvp.commands;

import de.mxchy.kitpvp.arena.KitConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearArenaCoord implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        KitConfig.clearArenaCoords();
        Player player = (Player) sender;
        player.sendMessage("Cleared all arena coordinates");
        return true;
    }
}
