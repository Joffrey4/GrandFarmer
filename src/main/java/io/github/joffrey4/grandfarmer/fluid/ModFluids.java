package io.github.joffrey4.grandfarmer.fluid;

import net.minecraftforge.fluids.FluidRegistry;


public class ModFluids {

    public static FluidSaltWater saltWater;

    public static void init() {
        saltWater = new FluidSaltWater();
        FluidRegistry.registerFluid(saltWater);
    }



}
