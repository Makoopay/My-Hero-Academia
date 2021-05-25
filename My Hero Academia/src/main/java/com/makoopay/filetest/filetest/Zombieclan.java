package com.makoopay.filetest.filetest;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Zombie;

public class Zombieclan extends EntityZombie {
    public Zombieclan(World world) {
        super(world);

        Zombie craftZombie = (Zombie) this.getBukkitEntity();

        this.setBaby(true);
        this.setOnFire(1 ,false);
        this.setHealth(50);
        this.setCustomNameVisible(true);
        this.setCustomName(new ChatComponentText(ChatColor.RED + "Wizard's Zombie"));

        this.targetSelector.a(0, new PathfinderGoalNearestAttackableTarget<EntityHuman>(this, EntityHuman.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntitySkeleton>(this, EntitySkeleton.class, true));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget<EntityCreeper>(this, EntityCreeper.class, true));
        this.getWorld().addEntity(this);
        this.setFireTicks(0);
    }

}
