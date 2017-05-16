package io.github.joffrey4.grandfarmer.item;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import io.github.joffrey4.grandfarmer.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    // Food Items
    public static ItemFood bacon;
    public static ItemFood cookedBacon;
    public static ItemFood cookedFlesh;
    public static ItemFood cookedBrownMushroom;
    public static ItemFood cookedRedMushroom;

    // Other Items
    public static ItemClay clayBall;
    public static ItemBase salt;

    public static void init() {

        // Remove vanilla CLAY_BALL from creativeTab, and replace with this mod's clay.
        Items.CLAY_BALL.setCreativeTab(null);
        clayBall = register(new ItemClay("clayBall"));

        // Other Items
        salt = register(new ItemBase("salt")).setCreativeTab(GrandFarmerMod.creativeTab);

        // Food Items
        bacon = register(new ItemFood("bacon", 1, 0.3F, true));
        cookedBacon = register(new ItemFood("cookedBacon", 3, 0.8F, true));
        cookedFlesh = register(new ItemFood("cookedFlesh", 4, 0.8F, true));
        cookedBrownMushroom = register(new ItemFood("cookedBrownMushroom", 1, 0.4F, false));
        cookedRedMushroom = register(new ItemFood("cookedRedMushroom", 1, 0.4F, false));

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
