package com.makoopay.filetest.filetest;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sdr, Command cmd, String s, String[] strings) {
        if (sdr instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("DragonTeam")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage("Your In Dragon Team Now");
                p.setDisplayName("Dragon Team");

            }
            if (cmd.getName().equalsIgnoreCase("Bakugo")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.RED + "Your Bakugo Now");
                p.setDisplayName("Bakugo");
            }
            if (cmd.getName().equalsIgnoreCase("Deku")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.GREEN + "Your Deku Now");
                p.setDisplayName("Deku");
            }
            if (cmd.getName().equalsIgnoreCase("Todoroki")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.BLUE + "Your Todoroki Now");
                p.setDisplayName("Todoroki");
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100000000, 10));
            }
            if (cmd.getName().equalsIgnoreCase("Froppy")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.GREEN + "Your Froppy Now");
                p.setDisplayName("Froppy");
                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 1000000, 3));
            }
            if (cmd.getName().equalsIgnoreCase("Tokoyami")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.BLACK + "Your Tokoyami Now");
                p.setDisplayName("Tokoyami");
            }
            if (cmd.getName().equalsIgnoreCase("Endavour")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.RED + "Your Endavour Now");
                p.setDisplayName("Endavour");
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, 3));
            }
            if (cmd.getName().equalsIgnoreCase("Uraraka")) {
                Player p = (Player) sdr;
                Filetest.DragonTeam.put(p.getUniqueId(), 1);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "Your Uraraka Now");
                p.setDisplayName("Uraraka");
            }
            if (cmd.getName().equalsIgnoreCase("Kirishima")) {
                Player player = (Player) sdr;
                Filetest.DragonTeam.put(player.getUniqueId(), 1);
                player.sendMessage(ChatColor.DARK_RED + "Your Kirishima Now");
                player.setDisplayName("Kirishima");
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 1));
            }
            if (cmd.getName().equalsIgnoreCase("Lida")) {
                Player player = (Player) sdr;
                Filetest.DragonTeam.put(player.getUniqueId(), 1);
                player.sendMessage(ChatColor.DARK_RED + "Your Lida Now");
                player.setDisplayName("Lida");
            }
            if (cmd.getName().equalsIgnoreCase("Quirk")) {
                Player p = (Player) sdr;
                p.sendMessage("/Tokoyami" +
                        "/Todoroki" +
                        "/Deku" +
                        "/Bakugo" +
                        "/Endeavour" +
                        "/Froppy" +
                        "/Uraraka" +
                        "/Kirishima" +
                        "/Lida");
            }
        }
        return true;
    }
}
