package io.github.joffrey4.grandfarmer.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWaterRegulator extends BlockBase {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool OPENEND = PropertyBool.create("opened");

    public BlockWaterRegulator(String name) {
        super(Material.ROCK, name);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPENEND, Boolean.valueOf(false)));
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(OPENEND, Boolean.valueOf(false));
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(OPENEND, Boolean.valueOf(false)));

        if (!worldIn.isRemote)
        {
            this.checkforOpen(worldIn, pos, state);
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote && worldIn.getTileEntity(pos) == null)
        {
            this.checkforOpen(worldIn, pos, state);
        }
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (!worldIn.isRemote)
        {
            this.checkforOpen(worldIn, pos, state);
        }
    }

    private void checkforOpen(World worldIn, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

        boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());
        boolean flag1 = ((Boolean)state.getValue(OPENEND)).booleanValue();

        if (flag && !flag1)
        {
            worldIn.addBlockEvent(pos, this, 1, enumfacing.getIndex());
        }
        else if (!flag && flag1)
        {
            worldIn.addBlockEvent(pos, this, 0, enumfacing.getIndex());
        }
    }

    /**
     * Called on both Client and Server when World#addBlockEvent is called. On the Server, this may perform additional
     * changes to the world, like pistons replacing the block with an extended base. On the client, the update may
     * involve replacing tile entities, playing sounds, or performing other visual actions to reflect the server side
     * changes.
     */
    @Override
    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        Block blockNorth = worldIn.getBlockState(pos.north()).getBlock();

        if (!worldIn.isRemote)
        {
            if (id == 1)
            {
                worldIn.setBlockState(pos, state.withProperty(OPENEND, Boolean.valueOf(true)));
                worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.25F + 0.6F);

                switch (enumfacing) {
                    case NORTH:
                        if (worldIn.getBlockState(pos.north()).getBlock() == Blocks.WATER) {
                            worldIn.setBlockState(pos.south(), ModBlocks.saltWaterBlock.getDefaultState());
                        }
                    case SOUTH:
                        if (worldIn.getBlockState(pos.south()).getBlock() == Blocks.WATER) {
                            worldIn.setBlockState(pos.north(), ModBlocks.saltWaterBlock.getDefaultState());
                        }
                    case WEST:
                        if (worldIn.getBlockState(pos.west()).getBlock() == Blocks.WATER) {
                            worldIn.setBlockState(pos.east(), ModBlocks.saltWaterBlock.getDefaultState());
                        }
                    case EAST:
                        if (worldIn.getBlockState(pos.east()).getBlock() == Blocks.WATER) {
                            worldIn.setBlockState(pos.west(), ModBlocks.saltWaterBlock.getDefaultState());
                        }
                }

                return false;
            }

            if (id == 0)
            {
                worldIn.setBlockState(pos, state.withProperty(OPENEND, Boolean.valueOf(false)));
                worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.15F + 0.6F);
                return false;
            }
        }

        /*
        if (id == 0)
        {
            worldIn.setBlockState(pos, state.withProperty(OPENEND, Boolean.valueOf(false)));
            worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.25F + 0.6F);
        }

        else if (id == 1)
        {
            worldIn.setBlockState(pos, state.withProperty(OPENEND, Boolean.valueOf(true)));
            worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_PISTON_CONTRACT, SoundCategory.BLOCKS, 0.5F, worldIn.rand.nextFloat() * 0.15F + 0.6F);
        }
        */

        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(OPENEND, Boolean.valueOf((meta & 8) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

        if (((Boolean)state.getValue(OPENEND)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, OPENEND});
    }
}
