package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class BlockSaltWater extends BlockFluidClassic {

    public static final String name = "saltWaterBlock";

    public BlockSaltWater(Fluid fluid) {
        super(fluid, Material.WATER);

        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(modId, name));

        //TODO: Enlever la creative tab
        setCreativeTab(GrandFarmerMod.creativeTab);
    }

}
