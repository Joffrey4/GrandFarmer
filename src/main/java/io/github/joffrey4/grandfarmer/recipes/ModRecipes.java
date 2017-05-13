package io.github.joffrey4.grandfarmer.recipes;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init() {

        // Bacon (From Porkchop)
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bacon, 2, 0), Items.PORKCHOP);
        GameRegistry.addSmelting(ModItems.bacon, new ItemStack(ModItems.cookedBacon), 0.3f);

        // Cooked Flesh (From Rotten Flesh)
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cookedFlesh), "RR ", "RR ", "S  ", 'R', Items.ROTTEN_FLESH, 'S', Items.SUGAR);

    }

}
