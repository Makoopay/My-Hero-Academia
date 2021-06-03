package com.makoopay.filetest.filetest;

import net.minecraft.server.v1_16_R3.AxisAlignedBB;
import net.minecraft.server.v1_16_R3.ItemStack;
import net.minecraft.server.v1_16_R3.ParticleType;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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

import java.util.*;

public final class Filetest extends JavaPlugin implements Listener {

    FileConfiguration config = getConfig();

    public static final HashMap<UUID, Integer> DragonTeam = new HashMap<>();

    @Override
    public void onEnable() {
        config.addDefault("youAreAwesome", true);
        config.options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("DragonTeam").setExecutor(new Commands());
        this.getCommand("Bakugo").setExecutor(new Commands());
        this.getCommand("Deku").setExecutor(new Commands());
        this.getCommand("Todoroki").setExecutor(new Commands());
        this.getCommand("Froppy").setExecutor(new Commands());
        this.getCommand("Tokoyami").setExecutor(new Commands());
        this.getCommand("Endavour").setExecutor(new Commands());
        this.getCommand("Uraraka").setExecutor(new Commands());
        this.getCommand("Kirishima").setExecutor(new Commands());
        this.getCommand("Lida").setExecutor(new Commands());
        this.getCommand("Quirk").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void hit2(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        double t = Math.PI / 8;
        Location loc = player.getLocation();
        Vector direction = player.getLocation().getDirection();

        if (player.getDisplayName().equalsIgnoreCase("lida")) {
            player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, loc, 0, 0, 0, 0);
            player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, loc, 0, 0, 0, 0);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000000, 4));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000000, 10));
        }

    }


    @EventHandler
    public void hit1(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (p.isSneaking()) {
            if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
                if (p.getDisplayName().equalsIgnoreCase("lida")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 20));
                }
            }
        }
        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (p.getDisplayName().equalsIgnoreCase("todoroki")) {
                new BukkitRunnable() {
                    double t = Math.PI / 8;
                    Location loc = p.getLocation();
                    Vector direction = p.getLocation().getDirection();

                    public void run() {
                        t = t + 1 * Math.PI;
                        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
                            double x = direction.getX() * t;
                            double y = direction.getY() * t + 1.5;
                            double z = direction.getZ() * t;
                            loc.add(x, y, z);
                            p.getWorld().spawnParticle(Particle.SNOW_SHOVEL, loc, 0, 0, 0, 0, 1);

                            for (Entity e : loc.getChunk().getEntities()) {
                                if (e.getLocation().distance(loc) < 2.0) {
                                    if (e instanceof LivingEntity) {
                                        if (!e.equals(p)) {
                                            ((LivingEntity) e).damage(3);
                                            ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1));
                                        }

                                    }
                                }
                            }
                            loc.subtract(x, y, z);
                            theta = theta + Math.PI / 64;

                        }
                        if (t > 30) {
                            this.cancel();
                        }
                    }

                }.runTaskTimer(this, 0, 1);
            }
        }

        if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            final Player player = event.getPlayer();

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
            if (p.getDisplayName().equalsIgnoreCase("Froppy")) {
                new BukkitRunnable() {
                    double t = Math.PI / 8;
                    Location loc = player.getLocation();
                    Vector direction = player.getLocation().getDirection();

                    public void run() {
                        t = t + 1 * Math.PI;
                        for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 32) {
                            double x = direction.getX() * t;
                            double y = direction.getY() * t + 1.5;
                            double z = direction.getZ() * t;
                            loc.add(x, y, z);
                            player.getWorld().spawnParticle(Particle.DRAGON_BREATH, loc, 0, 0, 0, 0, 1);

                            for (Entity e : loc.getChunk().getEntities()) {
                                if (e.getLocation().distance(loc) < 2.0) {
                                    if (e instanceof LivingEntity) {
                                        if (!e.equals(player)) {
                                            e.setVelocity(player.getLocation().getDirection().multiply(-2));
                                        }
                                    }
                                }
                            }
                            loc.subtract(x, y, z);
                            theta = theta + Math.PI / 64;

                        }
                        if (t > 30) {
                            this.cancel();
                        }
                    }

                }.runTaskTimer(this, 0, 1);
            }
            if (p.getDisplayName().equalsIgnoreCase("Endavour")) {
                Vector direction = p.getLocation().getDirection();
                p.launchProjectile(Fireball.class, direction);
                ;
            }
            if (p.getDisplayName().equalsIgnoreCase("Deku")) {

                for (Entity e : p.getNearbyEntities(5, 5, 5)) {
                    if (e instanceof Player) {
                        ((Player) e).damage(10);
                    }
                }
            }
            if (p.getDisplayName().equalsIgnoreCase("Tokoyami")) {
                Bukkit.getScheduler().cancelTasks(this);
            }
        }
    }

    @EventHandler
    public void Shift(PlayerToggleSneakEvent event) {
        if (event.getPlayer().isSneaking()) {
            if (event.getPlayer().getDisplayName().equalsIgnoreCase("todoroki")) {
                event.getPlayer().launchProjectile(Fireball.class);
            }

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
                if (p.getDisplayName().equalsIgnoreCase("deku")) {
                    p.getLocation().add(0, 1, 0);
                    p.getWorld().spawnParticle(Particle.CRIT_MAGIC, p.getLocation(), 10);
                    Vector direction = p.getLocation().getDirection();
                    p.setVelocity(direction.multiply(3));
                }
                if (p.getDisplayName().equalsIgnoreCase("Froppy")) {
                    if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                        p.removePotionEffect(PotionEffectType.INVISIBILITY);
                    } else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 1));
                    }
                }
                if (p.getDisplayName().equalsIgnoreCase("Tokoyami")) {
                    Player player = event.getPlayer();

                    new BukkitRunnable() {
                        double t = 0;

                        public void run() {
                            t = t + 0.5;
                            Location loc = p.getLocation();
                            Vector direction = loc.getDirection().normalize();
                            double x = direction.getX() * t;
                            double y = direction.getY() * t + 1.5;
                            double z = direction.getZ() * t;
                            loc.add(x, y, z);
                            p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 0, 0, 0, 0, 1);
                            p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 0, 0, 0, 0, 1);
                            p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc, 0, 0, 0, 0, 1);
                            for (Entity e : loc.getChunk().getEntities()) {
                                if (e.getLocation().distance(loc) < 2.0) {
                                    if (e instanceof LivingEntity) {
                                        if (!e.equals(player)) {
                                            ((LivingEntity) e).damage(10);
                                        }
                                    }
                                }
                            }

                            loc.subtract(x, y, z);
                            if (t > 30) {
                                this.cancel();
                            }
                        }
                    }.runTaskTimer(this, 0, 1);
                    createDarkShadow(p);
                }
                if (p.getDisplayName().equalsIgnoreCase("Endavour")) {
                    surroundFlames(p.getLocation(), 1);
                    surroundFlames(p.getLocation(), 2);
                    surroundFlames(p.getLocation(), 3);
                    surroundFlames(p.getLocation(), 4);
                }
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
            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 1));
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

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (config.getBoolean("youAreAwesome")) {
            player.sendMessage("Hello Welcome To My Hero Academia To Pick A Quirk Do /Quirk");
        } else {
            player.sendMessage("You are not awesome...");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onFallDamage(EntityDamageEvent event) {
        Player p = (Player) event.getEntity();
        if (p.getDisplayName().equalsIgnoreCase("bakugo")) {
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)
                event.setCancelled(true);
        }
        if (p.getDisplayName().equalsIgnoreCase("todoroki")) {
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)
                event.setCancelled(true);
        }
        if (p.getDisplayName().equalsIgnoreCase("deku")) {
            if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)
                event.setCancelled(true);
        }
    }

    private void createDarkShadow(final Player p) {
        new BukkitRunnable() {
            double alpha = 0;

            public void run() {
                // Each cycle alpha gets increase by pi / 16 which divides the whole circle into 32 sections
                alpha += Math.PI / 8;

                /*
                 * You can add to the location based on the coordinates of a point on the circumference on a circle
                 * The y location is meanwhile altering in a slightly shifted sine curve
                 */
                // You can add to the location based on the coordinates of a point on the circumference on a circle
                Location loc = p.getLocation();
                Location firstLocation = loc.clone().add(Math.cos(alpha), Math.sin(alpha) + 1, Math.sin(alpha));
                Location secondLocation = loc.clone().add(Math.cos(alpha + Math.PI), Math.sin(alpha) + 1, Math.sin(alpha + Math.PI));
                p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, firstLocation, 0, 0, 0, 0, 0);
                p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, secondLocation, 0, 0, 0, 0, 0);
            }
        }.runTaskTimer(this, 0, 1);
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


    public static Entity getNearestEntityInSight(Player player, int range) {
        ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
        ArrayList<Block> sightBlock = (ArrayList<Block>) player.getLineOfSight((Set<Material>) null, range);
        ArrayList<Location> sight = new ArrayList<Location>();
        for (int i = 0; i < sightBlock.size(); i++)
            sight.add(sightBlock.get(i).getLocation());
        for (int i = 0; i < sight.size(); i++) {
            for (int k = 0; k < entities.size(); k++) {
                if (Math.abs(entities.get(k).getLocation().getX() - sight.get(i).getX()) < 1.3) {
                    if (Math.abs(entities.get(k).getLocation().getY() - sight.get(i).getY()) < 1.5) {
                        if (Math.abs(entities.get(k).getLocation().getZ() - sight.get(i).getZ()) < 1.3) {
                            return entities.get(k);
                        }
                    }
                }
            }
        }
        return null;
    }
}
