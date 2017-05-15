package io.github.joffrey4.grandfarmer.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class FluidSaltWater extends Fluid {

    public static final String name = "saltWater";
    public static final FluidSaltWater instance = new FluidSaltWater();

    public FluidSaltWater() {
        super(name, new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"));
    }

    @Override
    public int getColor()
    {
        return 0xFF00FF00;
    }
}
