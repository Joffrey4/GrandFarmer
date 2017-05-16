package io.github.joffrey4.grandfarmer.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class FluidSaltWater extends Fluid {

    public static String name = "saltWater";

    public FluidSaltWater() {
        super(name, new ResourceLocation(modId + ":blocks/water_still"), new ResourceLocation(modId + ":blocks/water_flow"));

        setDensity(250);
    }

    @Override
    public int getColor()
    {
        return 0xFF00FF00;
    }
}
