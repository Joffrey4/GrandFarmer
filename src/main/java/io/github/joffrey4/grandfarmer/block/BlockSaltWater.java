package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.GrandFarmerMod;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import static io.github.joffrey4.grandfarmer.GrandFarmerMod.modId;

public class BlockSaltWater extends BlockFluidClassic {

    public static String name = "saltWaterBlock";

    public BlockSaltWater(Fluid fluid) {
        super(fluid, Material.WATER);

        // General information
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(modId, name));
        setQuantaPerBlock(2); // Max number of block that the liquid spread.

        //TODO: Enlever la creative tab
        setCreativeTab(GrandFarmerMod.creativeTab);
    }

    @Override
    public float getFluidHeightForRender(IBlockAccess world, BlockPos pos)
    {
        IBlockState here = world.getBlockState(pos);
        IBlockState up = world.getBlockState(pos.down(densityDir));

        if (here.getBlock() == this)
        {
                return 0.25F;
        }

        if (here.getBlock() instanceof BlockLiquid)
        {
            return Math.min(1 - BlockLiquid.getLiquidHeightPercent(here.getValue(BlockLiquid.LEVEL)), 0.25F);
        }

        return !here.getMaterial().isSolid() && up.getBlock() == this ? 1 : this.getQuantaPercentage(world, pos) * 0.25F;
    }

    @Override
    protected boolean canFlowInto(IBlockAccess world, BlockPos pos)
    {
        return world.isAirBlock(pos);

        /*
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == this)
        {
            return true;
        }

        if (displacements.containsKey(state.getBlock()))
        {
            return displacements.get(state.getBlock());
        }

        Material material = state.getMaterial();
        if (material.blocksMovement()  ||
                material == Material.WATER ||
                material == Material.LAVA  ||
                material == Material.PORTAL)
        {
            return false;
        }

        int density = getDensity(world, pos);
        if (density == Integer.MAX_VALUE)
        {
            return true;
        }

        if (this.density > density)
        {
            return true;
        }
        else
        {
            return false;
        }
        */
    }
}
