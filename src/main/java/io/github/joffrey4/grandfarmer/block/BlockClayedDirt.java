package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockClayedDirt extends BlockBase {

    private static int AGE = 0;

    public BlockClayedDirt(String name) {
        super(Material.GROUND, name);

        setTickRandomly(true);
        setHardness(0.5F);
        setResistance(2.5F);
        setSoundType(SoundType.GROUND);
    }

    // Return a list of dropped items (dirt and clay ball)
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        Item itemDirt = Item.getItemFromBlock(Blocks.DIRT);
        Item itemClay = ModItems.clayBall;

        if (itemDirt != null && itemClay != null)
        {
            ret.add(new ItemStack(itemDirt, 1));
            ret.add(new ItemStack(itemClay, 1));
        }
        return ret;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        BlockPos blockup = pos.up();
        if (worldIn.getBlockState(blockup).getBlock() == ModBlocks.saltWaterBlock) {

            int age = AGE;
            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockup, state, true)) {

                if (age >= 1) {
                    AGE = 0;
                    worldIn.setBlockState(blockup, ModBlocks.evaporatedSalt.getDefaultState());
                } else {
                    AGE += 1;
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            }
        }
    }


}
