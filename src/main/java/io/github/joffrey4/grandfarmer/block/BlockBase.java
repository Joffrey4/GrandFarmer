package io.github.joffrey4.grandfarmer.block;


import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public void registerItemModel(ItemBlock itemBlock) {
        GrandFarmerMod.proxy.registerItemRenderer(itemBlock, 0, name);
    }

}
