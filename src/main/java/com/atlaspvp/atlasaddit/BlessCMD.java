package com.atlaspvp.atlasaddit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
// Bless command code, Remember that the notes are there for you to change things for future versions
public class BlessCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by a player.");
            return true;
        }
 // Revisit hashsets when more knowledgeable to improve this code as it is your first time
 // This code was added in version 1.1 - Recode
        Player player = (Player) sender;
        Collection<PotionEffect> activeEffects = player.getActivePotionEffects();
        Set<PotionEffectType> debuffEffects = new HashSet<>();

        Set<PotionEffectType> knownDebuffTypes = new HashSet<>();
        knownDebuffTypes.add(PotionEffectType.BLINDNESS);
        knownDebuffTypes.add(PotionEffectType.CONFUSION);
        knownDebuffTypes.add(PotionEffectType.HARM);
        knownDebuffTypes.add(PotionEffectType.HUNGER);
        knownDebuffTypes.add(PotionEffectType.POISON);
        knownDebuffTypes.add(PotionEffectType.SLOW);
        knownDebuffTypes.add(PotionEffectType.SLOW_DIGGING);
        knownDebuffTypes.add(PotionEffectType.UNLUCK);
        knownDebuffTypes.add(PotionEffectType.WEAKNESS);
        knownDebuffTypes.add(PotionEffectType.WITHER);
// knownDebuffTypes is just the name of the hashset so adding all the "known"
// debuff potion types allows the if statement to check if any of these "known"
// effects are active on the player then executes the following code for "for" and "else"
        for (PotionEffect effect : activeEffects) {
            PotionEffectType type = effect.getType();
            if (knownDebuffTypes.contains(type)) { // Check if the effect type is a known debuff type
                debuffEffects.add(type);
            }
        }
// Change this to support minimessage and be configurable in a later version - V1.1 - Recode
        if (debuffEffects.isEmpty()) {
            player.sendMessage(ChatColor.YELLOW + "You have no debuff potion effects.");
        } else {
            StringBuilder message = new StringBuilder();
            message.append(ChatColor.YELLOW + "The following effects have been removed:");
            for (PotionEffectType type : debuffEffects) {
                String effectName = type.getName();
                message.append("\n").append(ChatColor.YELLOW).append(effectName);
                player.removePotionEffect(type);
            }
            player.sendMessage(message.toString());
        }

        return true;
    }
}
