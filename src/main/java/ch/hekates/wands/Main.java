package ch.hekates.wands;

import ch.hekates.wands.commands.GiveWandCommand;
import ch.hekates.wands.commands.ReloadCommand;
import ch.hekates.wands.commands.SpellCommand;
import ch.hekates.wands.commands.SpellTabComplete;
import ch.hekates.wands.listeners.ProtegoListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getCommand("spell").setExecutor(new SpellCommand());
        getCommand("spell").setTabCompleter(new SpellTabComplete());
        getCommand("givewand").setExecutor(new GiveWandCommand());
        getCommand("reloadWnS").setExecutor(new ReloadCommand());

        Bukkit.getPluginManager().registerEvents(new ProtegoListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
