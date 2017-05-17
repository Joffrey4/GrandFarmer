package io.github.joffrey4.grandfarmer.block;

import io.github.joffrey4.grandfarmer.item.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockEvaporatedSalt extends BlockBase {

    private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(0, 0, 0, 1.0, 0.25, 1.0);

    public BlockEvaporatedSalt(String name) {
        super(Material.SAND, name);

        setHardness(0.2F);
        setResistance(1.0F);
        setSoundType(SoundType.SAND);
    }

    @Override
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.salt;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return COLLISION_BOX;
    }

    @Override
    @Deprecated
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, COLLISION_BOX);
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
