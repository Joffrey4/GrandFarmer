package io.github.joffrey4.grandfarmer.item;

import io.github.joffrey4.grandfarmer.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class ModFluidItems {

    public static void init() {
        registerFluid(ModBlocks.saltWaterBlock, "saltWater");
    }

    private static void registerFluid(BlockFluidClassic block, String name) {

        Item item = Item.getItemFromBlock(block);
        ModelBakery.registerItemVariants(item);

        final ModelResourceLocation loc = new ModelResourceLocation(modId + ":fluid", name);

        ModelLoader.setCustomMeshDefinition(item, stack -> loc);
        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {

            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return loc;
            }
        });
    }

}
