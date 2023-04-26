package com.atlaspvp.atlasaddit;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // "/bless"
        getCommand("bless").setExecutor(new BlessCMD());
        getCommand("help").setExecutor(new HelpCMD());
        // Basic Enable Message
        System.out.println("Enabled Successfully!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
