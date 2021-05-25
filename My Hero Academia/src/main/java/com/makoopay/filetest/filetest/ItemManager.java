package com.makoopay.filetest.filetest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack wand;

    public static void init(){
        createWand();
    }
    private static void createWand(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Magic Stick");
        item.setItemMeta(meta);
        wand = item;

        ShapelessRecipe sir = new ShapelessRecipe(NamespacedKey.minecraft("wand_shapeless"), item);
        sir.addIngredient(2, Material.STICK);
        sir.addIngredient(1, Material.FLINT);
        Bukkit.getServer().addRecipe(sir);

    }


}
