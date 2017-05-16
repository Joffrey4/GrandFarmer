package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.fluid.ModFluids;
import io.github.joffrey4.grandfarmer.item.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModBlocks {

    public static BlockSaltWater saltWaterBlock;
    public static BlockClayedDirt clayedDirt;
    public static BlockSaltedDirt saltedDirt;

    public static void init() {
        saltWaterBlock = register(new BlockSaltWater(ModFluids.saltWater));
        clayedDirt = register(new BlockClayedDirt("clayedDirt"));
        saltedDirt = register(new BlockSaltedDirt("saltedDirt"));
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        if (block instanceof ItemModelProvider) {
            ((ItemModelProvider)block).registerItemModel(itemBlock);
        }

        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
