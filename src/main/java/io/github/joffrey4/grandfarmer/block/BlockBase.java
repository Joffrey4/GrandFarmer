package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import io.github.joffrey4.grandfarmer.item.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements ItemModelProvider {

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GrandFarmerMod.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        GrandFarmerMod.proxy.registerItemRenderer(item, 0, name);
    }

}
