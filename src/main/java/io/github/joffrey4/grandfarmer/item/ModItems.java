package io.github.joffrey4.grandfarmer.item;

import io.github.joffrey4.grandfarmer.block.BlockSaltWater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class ModItems {

    public static ItemFood bacon;
    public static ItemFood cookedBacon;
    public static ItemFood cookedFlesh;
    public static ItemFood cookedBrownMushroom;
    public static ItemFood cookedRedMushroom;

    private static ModelResourceLocation fluidLocation = new ModelResourceLocation(modId.toLowerCase() + ":" + BlockSaltWater.name, "fluid");

    public static Item saltWaterItem;

    public static void init() {

        bacon = register(new ItemFood("bacon", 1, 0.3F, true));
        cookedBacon = register(new ItemFood("cookedBacon", 3, 0.8F, true));
        cookedFlesh = register(new ItemFood("cookedFlesh", 4, 0.8F, true));
        cookedBrownMushroom = register(new ItemFood("cookedBrownMushroom", 1, 0.4F, false));
        cookedRedMushroom = register(new ItemFood("cookedRedMushroom", 1, 0.4F, false));

        saltWaterItem = Item.getItemFromBlock(BlockSaltWater.instance);
        ModelBakery.registerItemVariants(saltWaterItem);

        ModelLoader.setCustomMeshDefinition(saltWaterItem, new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return fluidLocation;
            }
        });

        ModelLoader.setCustomStateMapper(BlockSaltWater.instance, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return fluidLocation;
            }
        });

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }

        return item;
    }

}
