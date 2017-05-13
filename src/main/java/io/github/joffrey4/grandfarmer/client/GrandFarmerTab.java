package io.github.joffrey4.grandfarmer.client;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class GrandFarmerTab extends CreativeTabs {

    public GrandFarmerTab() {
        super(GrandFarmerMod.modId);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.GRASS);
    }

}
