package dev.sterner.culturaldelights.common.block;

import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class AvocadoPitBlock extends SaplingBlock {
    private static final VoxelShape SHAPE_PIT = Block.createCuboidShape(6, 0, 6, 10, 3, 10);

    public AvocadoPitBlock(SaplingGenerator treeIn, AbstractBlock.Settings properties) {
        super(treeIn, properties);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_PIT;
    }
}
