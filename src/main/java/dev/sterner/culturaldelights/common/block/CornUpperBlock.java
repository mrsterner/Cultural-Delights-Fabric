package dev.sterner.culturaldelights.common.block;

import dev.sterner.culturaldelights.common.registry.CDObjects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CornUpperBlock extends CropBlock {
    public static final IntProperty CORN_AGE;
    private static final VoxelShape[] SHAPE_BY_AGE;

    public CornUpperBlock(Settings settings) {
        super(settings);
    }

    public IntProperty getAgeProperty() {
        return CORN_AGE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return CDObjects.CORN_KERNELS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CORN_AGE);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.getBlock() == CDObjects.CORN_CROP;
    }


    protected int getGrowthAmount(World worldIn) {
        return super.getGrowthAmount(worldIn) / 3;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getBaseLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && world.getBlockState(pos.down()).getBlock() == CDObjects.CORN_CROP;
    }

    static {
        CORN_AGE = Properties.AGE_3;
        SHAPE_BY_AGE = new VoxelShape[]{Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
                Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
                Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
                Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D)};
    }
}
