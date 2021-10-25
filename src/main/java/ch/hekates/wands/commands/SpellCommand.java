package ch.hekates.wands.commands;

import ch.hekates.wands.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpellCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("spell")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§c" + Main.getPlugin(Main.class).getConfig().getString("command-exsecuter-not-player"));
                return true;
            }
            Player player = (Player) sender;
            if (args.length > 0) {
                player.sendMessage(args[0]);

            }else{
                player.sendMessage("§cDu musst einen Zauberspruch eingeben, um ihn zu aktivieren!");
                player.sendMessage("/spell [spell]");
            }
            return true;
        }
        return false;
    }
}
