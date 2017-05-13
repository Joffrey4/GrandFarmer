package io.github.joffrey4.grandfarmer.item;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import net.minecraft.item.Item;

public class ItemFood extends net.minecraft.item.ItemFood implements ItemModelProvider {

    protected String name;
    public ItemFood(String name, int amount, float saturation, boolean isWolfFood) {

        super(amount, saturation, isWolfFood);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(GrandFarmerMod.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        GrandFarmerMod.proxy.registerItemRenderer(this, 0, name);
    }
}
