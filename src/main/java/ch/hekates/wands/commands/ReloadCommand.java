package ch.hekates.wands.commands;

import ch.hekates.wands.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("reloadWnS")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§c" + Main.getPlugin(Main.class).getConfig().getString("command-exsecuter-not-player"));
                return true;
            }
            Player player = (Player) sender;
            Main.getPlugin(Main.class).reloadConfig();
            player.sendMessage("Config wurde neu geladen.");

            return true;
        }
        return false;
    }
}
