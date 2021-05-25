package com.makoopay.filetest.filetest;

import net.minecraft.server.v1_16_R3.ItemStack;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Filetest extends JavaPlugin implements Listener {

    public static final HashMap<UUID, Integer> DragonTeam = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("DragonTeam").setExecutor(new Commands());
        this.getCommand("Bakugo").setExecutor(new Commands());
        this.getCommand("Deku").setExecutor(new Commands());
        this.getCommand("Todoroki").setExecutor(new Commands());
        this.getCommand("Froppy").setExecutor(new Commands());
        this.getCommand("Tokoyami").setExecutor(new Commands());
        this.getCommand("Endavour").setExecutor(new Commands());
        this.getCommand("Uraraka").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void hit(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            Player p = event.getPlayer();

            if (p.getDisplayName().equalsIgnoreCase("dragon team")) {
                p.getLocation().add(0, 1, 0);
                Vector direction = p.getLocation().getDirection();
                p.launchProjectile(ShulkerBullet.class, direction);
            }
            if (p.getDisplayName().equalsIgnoreCase("bakugo")) {
                Vector loc = p.getEyeLocation().getDirection();

                TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
                tnt.setVelocity(loc.multiply(10));
                tnt.setFuseTicks(1);
            }
            if (p.getDisplayName().equalsIgnoreCase("todoroki")) {
                Vector loc = p.getEyeLocation().getDirection();
                Snowball tnt = (Snowball) p.getWorld().spawnEntity(p.getLocation(), EntityType.SNOWBALL);
                tnt.setVelocity(loc.multiply(5));
            }
            if (p.getDisplayName().equalsIgnoreCase("Froppy")) {
                if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                }
            }
            if (p.getDisplayName().equalsIgnoreCase("Endavour")) {
                Vector direction = p.getLocation().getDirection();
                p.launchProjectile(Fireball.class, direction);;
            }
            if (p.getDisplayName().equalsIgnoreCase("Deku")) {
                for (Entity e : p.getNearbyEntities(5, 5, 5)) {
                    if (e instanceof Player) {
                        ((Player) e).damage(10);
                    }
                }
            }
        }
    }

    @EventHandler
    public void Shift(PlayerToggleSneakEvent event) {
        if (event.getPlayer().isSneaking()) {
            Player p = event.getPlayer();
            if (p.getDisplayName().equalsIgnoreCase("dragon team")) {
                p.getLocation().add(0, 1, 0);
                Vector direction = p.getLocation().getDirection();
                p.launchProjectile(DragonFireball.class, direction);
            }
            if (p.getDisplayName().equalsIgnoreCase("bakugo")) {
                Vector loc = p.getLocation().getDirection();

                TNTPrimed tnt = (TNTPrimed) p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
                p.setVelocity(loc.multiply(3));
                tnt.setFuseTicks(0);
            }
            if (p.getDisplayName().equalsIgnoreCase("todoroki")) {
                p.getLocation().add(0, 1, 0);
                Vector direction = p.getLocation().getDirection();
                p.launchProjectile(Fireball.class, direction);
            }
            if (p.getDisplayName().equalsIgnoreCase("deku")) {
                p.getLocation().add(0, 1, 0);
                p.getWorld().spawnParticle(Particle.CRIT_MAGIC, p.getLocation(), 10);
                Vector direction = p.getLocation().getDirection();
                p.setVelocity(direction.multiply(3));
            }
            if (p.getDisplayName().equalsIgnoreCase("Froppy")) {
                if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                }
                ;
                p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000, 1));
            }
            if (p.getDisplayName().equalsIgnoreCase("Tokoyami")) {
                createFlameRings(p);
                for (Entity e : p.getNearbyEntities(3, 3, 3)) {
                    if (e instanceof Player) {
                        ((Player) e).damage(5);
                    }
                }
            }
            if (p.getDisplayName().equalsIgnoreCase("Endavour")) {
                surroundFlames(p.getLocation(), 1);
                surroundFlames(p.getLocation(), 2);
                surroundFlames(p.getLocation(), 3);
                surroundFlames(p.getLocation(), 4);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerRespawn(EntityDamageByEntityEvent e) {
        Player pk = (Player) e.getDamager();
        Player p = (Player) e.getEntity();
        Entity ent = e.getEntity();
        if (pk.getDisplayName().equalsIgnoreCase("deku")) {
            Vector pkvec = pk.getLocation().getDirection();
            p.setVelocity(pkvec.multiply(5));
            p.damage(10);
            pk.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 10));
        }
        if (pk.getDisplayName().equalsIgnoreCase("todoroki")) {
            if ((e.getDamager().equals(EntityType.SNOWBALL)))
                if ((e.getEntity() instanceof Player)) {
                    double damage = 100;
                    ((Player) e.getEntity()).damage(100);
                }
        }
        if (pk.getDisplayName().equalsIgnoreCase("uraraka")) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,1));
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerRespawn1(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if (e.getEntity() instanceof Player) {
            if (p.getDisplayName().equalsIgnoreCase("bakugo")) {
                if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                    e.setDamage(0);
                }
            }
        }

    }

    @EventHandler
    public void onPlayerRespawn2(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.isOnline()) {
            p.sendMessage(ChatColor.GREEN + "Pick a Quirk");
        }

    }

    private void createFlameRings(final Player p) {
        new BukkitRunnable() {
            double alpha = 0;

            public void run() {
                // Each cycle alpha gets increase by pi / 16 which divides the whole circle into 32 sections
                alpha += Math.PI / 16;

                /*
                 * You can add to the location based on the coordinates of a point on the circumference on a circle
                 * The y location is meanwhile altering in a slightly shifted sine curve
                 */
                // You can add to the location based on the coordinates of a point on the circumference on a circle
                Location loc = p.getLocation();
                Location firstLocation = loc.clone().add(Math.cos(alpha), Math.sin(alpha) + 1, Math.sin(alpha));
                Location secondLocation = loc.clone().add(Math.cos(alpha + Math.PI), Math.sin(alpha) + 1, Math.sin(alpha + Math.PI));
                p.spawnParticle(Particle.SMOKE_NORMAL, firstLocation, 0, 0, 0, 0, 0);
                p.spawnParticle(Particle.SMOKE_NORMAL, secondLocation, 0, 0, 0, 0, 0);
            }
        }.runTaskTimer((JavaPlugin.getPlugin(Filetest.class)), 0, 1);
    }

    public List<Block> getBlocks(Location center, int radius,
                                 boolean hollow, boolean sphere) {
        List<Location> locs = circle(center, radius, radius, hollow, sphere, 0);
        List<Block> blocks = new ArrayList<Block>();

        for (Location loc : locs) {
            blocks.add(loc.getBlock());
        }

        return blocks;
    }

    public List<Location> circle(Location loc, int radius, int height,
                                 boolean hollow, boolean sphere, int plusY) {
        List<Location> circleblocks = new ArrayList<Location>();
        int cx = loc.getBlockX();
        int cy = loc.getBlockY();
        int cz = loc.getBlockZ();

        for (int x = cx - radius; x <= cx + radius; x++) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                for (int y = (sphere ? cy - radius : cy); y < (sphere ? cy
                        + radius : cy + height); y++) {
                    double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z)
                            + (sphere ? (cy - y) * (cy - y) : 0);

                    if (dist < radius * radius
                            && !(hollow && dist < (radius - 1) * (radius - 1))) {
                        Location l = new Location(loc.getWorld(), x, y + plusY,
                                z);
                        circleblocks.add(l);
                    }
                }
            }
        }

        return circleblocks;
    }

    public void surroundFlames(Location l, int r) {
        for (Block b : getBlocks(l, r, true, false)) {
            b.setType(Material.FIRE);
        }
    }
}
