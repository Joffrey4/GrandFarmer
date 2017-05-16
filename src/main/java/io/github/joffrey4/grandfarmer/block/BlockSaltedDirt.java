package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class BlockSaltedDirt extends BlockBase {

    public BlockSaltedDirt(String name) {
        super(Material.GROUND, name);

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
        Item itemSalt = ModItems.salt;

        if (itemDirt != null && itemClay != null)
        {
            ret.add(new ItemStack(itemDirt, 1));
            ret.add(new ItemStack(itemClay, 1));
            ret.add(new ItemStack(itemSalt, 1));
        }
        return ret;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        BlockPos blockup = pos.up();
        if (playerIn.getHeldItem(EnumHand.MAIN_HAND) != null) {

            Item equipedItem = playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem();
            if (equipedItem == Items.DIAMOND_SHOVEL || equipedItem == Items.GOLDEN_SHOVEL || equipedItem == Items.IRON_SHOVEL || equipedItem == Items.STONE_SHOVEL || equipedItem == Items.WOODEN_SHOVEL) {

                if(!worldIn.isRemote) {

                    ItemStack itemstack = new ItemStack(ModItems.salt, 1);
                    EntityItem entityitem = new EntityItem(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY() + 1.5D, (double) pos.getZ() + 0.5D, itemstack);
                    worldIn.spawnEntityInWorld(entityitem);

                    // worldIn.setBlockState(blockup, worldIn.getBlockState(blockup).withProperty(SALT, false));
                    //worldIn.setBlockState(blockup, ModBlocks.saltWaterBlock.getDefaultState().withProperty(LEVEL, 0).withProperty(SALT, false));

                    //worldIn.setBlockState(blockup, ModBlocks.unsaltedWaterBlock.getDefaultState());
                    worldIn.setBlockState(pos, ModBlocks.clayedDirt.getDefaultState());
                }
            }
        }
        return false;
    }
}
