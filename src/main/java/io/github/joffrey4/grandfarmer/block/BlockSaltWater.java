package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import io.github.joffrey4.grandfarmer.fluid.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class BlockSaltWater extends BlockFluidClassic {

    public static final BlockSaltWater instance = new BlockSaltWater(ModFluids.saltWater);
    public static final String name = "saltWaterBlock";

    public BlockSaltWater(Fluid fluid) {
        super(fluid, Material.WATER);

        setUnlocalizedName(modId + ":" + name);
        setRegistryName(new ResourceLocation(modId, name));
        setCreativeTab(GrandFarmerMod.creativeTab);
    }

}
