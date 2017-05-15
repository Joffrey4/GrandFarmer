package io.github.joffrey4.grandfarmer.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class ClientProxy extends CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modId + ":" + id, "inventory"));
    }

}
