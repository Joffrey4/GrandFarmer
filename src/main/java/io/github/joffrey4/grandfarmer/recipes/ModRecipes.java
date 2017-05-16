package io.github.joffrey4.grandfarmer.recipes;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {

        // Implement vanilla's recipes of CLAY, for ModItems.clayBall;
        GameRegistry.addSmelting(ModItems.clayBall, new ItemStack(Items.BRICK), 0);
        GameRegistry.addShapedRecipe(new ItemStack(Blocks.CLAY), "CC ", "CC ", 'C', ModItems.clayBall);

        // Bacon (From Porkchop)
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bacon, 2, 0), Items.PORKCHOP);
        GameRegistry.addSmelting(ModItems.bacon, new ItemStack(ModItems.cookedBacon), 0.3F);

        // Cooked Flesh (From Rotten Flesh)
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cookedFlesh), "RR ", "RR ", "S  ", 'R', Items.ROTTEN_FLESH, 'S', Items.SUGAR);

        // Cooked Mushroom (From red and brown Mushroom)
        GameRegistry.addSmelting(Blocks.BROWN_MUSHROOM, new ItemStack(ModItems.cookedBrownMushroom), 0.3F);
        GameRegistry.addSmelting(Blocks.RED_MUSHROOM, new ItemStack(ModItems.cookedRedMushroom), 0.3F);
    }

}
