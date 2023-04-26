package com.atlaspvp.atlasaddit;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

// To improve this implementation with ought mini message
// change the List to a ComponentBuilder this poses all the same benefits to a list but
// Also allows us to utilize hover, and click events
public class HelpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        // Create a list to store the messages
        List<String> messages = new ArrayList<>();

        // Add messages to the list, Changing this to a list sends a single packet rather than a packet for every 'player.sendMessage'
        messages.add(ChatColor.BOLD + "--------------HelpMenu-------------");
        messages.add(ChatColor.of("#3972E5") + "• /Armorset " + ChatColor.YELLOW + "- Opens GUI with all currently available armor sets");
        messages.add(ChatColor.of("#3972E5") + "• /items " + ChatColor.YELLOW + "- Opens GUI with all currently available admin items");
        messages.add(ChatColor.of("#3972E5") + "• /events " + ChatColor.YELLOW + "- Open GUI with all the events and their timers");
        messages.add(ChatColor.of("#3972E5") + "• /minigames " + ChatColor.YELLOW + "- Open GUI with all the mini games and their timers");
        messages.add(ChatColor.of("#3972E5") + "• /KOTH " + ChatColor.YELLOW + "- Shows all the exact details of the KOTH event");
        messages.add(ChatColor.of("#3972E5") + "• /enchanter " + ChatColor.YELLOW + "- Opens the enchanter GUI to buy enchant books.");
        messages.add(ChatColor.of("#3972E5") + "• /tinkerer " + ChatColor.YELLOW + "- Tinker items and books into XP or Dust for books");
        messages.add(ChatColor.of("#3972E5") + "• /kits " + ChatColor.YELLOW + "- Opens KIT GUI");
        messages.add(ChatColor.of("#3972E5") + "• /bless " + ChatColor.YELLOW + "- Removes all debuffs");
        messages.add(ChatColor.of("#3972E5") + "• /discord " + ChatColor.YELLOW + "- Provides you with our Discord link");
        messages.add(ChatColor.of("#3972E5") + "• /report " + ChatColor.YELLOW + "- Report a player for breaking the rules");
        messages.add(ChatColor.of("#3972E5") + "• /staff " + ChatColor.YELLOW + "- View staff currently online");
        messages.add(ChatColor.of("#3972E5") + "• /invsee " + ChatColor.YELLOW + "- See your opponent's inventory");

        // Convert the list to an array and send as a single packet
        player.sendMessage(messages.toArray(new String[0]));

        return true;
    }
}
