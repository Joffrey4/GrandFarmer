package io.github.joffrey4.grandfarmer.fluid;

import io.github.joffrey4.grandfarmer.block.BlockSaltWater;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFluids {

    public static FluidSaltWater saltWater;

    public static void init() {
        saltWater = new FluidSaltWater();
        FluidRegistry.registerFluid(saltWater);
        GameRegistry.register(new ItemBlock(BlockSaltWater.instance).setRegistryName(BlockSaltWater.instance.getRegistryName()));
    }

}
