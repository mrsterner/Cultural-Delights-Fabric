package dev.sterner.culturaldelights.common.block;

import com.nhoryzon.mc.farmersdelight.block.BuddingBushBlock;
import com.nhoryzon.mc.farmersdelight.registry.BlocksRegistry;
import com.nhoryzon.mc.farmersdelight.util.BlockStateUtils;
import dev.sterner.culturaldelights.common.registry.CDObjects;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CornBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty AGE;
    public static final BooleanProperty SUPPORTING;
    private static final VoxelShape[] SHAPE_BY_AGE;
    public static final int GROWTH_CHANCE = 10;

    public CornBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AGE, 0).with(SUPPORTING, false));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState stateIn, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState state = super.getStateForNeighborUpdate(stateIn, direction, neighborState, world, pos, neighborPos);
        if (!state.isAir()) {
            if (direction == Direction.UP) {
                return state.with(SUPPORTING, this.isSupportingCornUpper(neighborState));
            }
        }
        return state;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND) || floor.isOf(BlocksRegistry.RICH_SOIL_FARMLAND.get());
    }

    public IntProperty getAgeProperty() {
        return AGE;
    }

    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(CDObjects.CORN_KERNELS);
    }


    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), age);
    }

    public boolean isMaxAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, SUPPORTING);
    }

    public boolean isSupportingCornUpper(BlockState topState) {
        return topState.getBlock() == CDObjects.CORN_UPPER;
    }


    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        BlockState upperState = world.getBlockState(pos.up());
        if (upperState.getBlock() instanceof CornUpperBlock) {
            return !((CornUpperBlock)upperState.getBlock()).isMature(upperState);
        } else {
            return true;
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        BlockState upperState = world.getBlockState(pos.up());
        if (upperState.getBlock() instanceof CornUpperBlock) {
            return !((CornUpperBlock)upperState.getBlock()).isMature(upperState);
        } else {
            return true;
        }
    }

    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.random, 1, 4);
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(worldIn), 7);
        if (ageGrowth <= this.getMaxAge()) {
            worldIn.setBlockState(pos, state.with(AGE, ageGrowth));
        } else {
            BlockState top = worldIn.getBlockState(pos.up());
            if (top.getBlock() == CDObjects.CORN_UPPER) {
                Fertilizable growable = (Fertilizable)worldIn.getBlockState(pos.up()).getBlock();
                if (growable.isFertilizable(worldIn, pos.up(), top, false)) {
                    growable.grow(worldIn, worldIn.random, pos.up(), top);
                }
            } else {
                CornUpperBlock cornUpper = (CornUpperBlock) CDObjects.CORN_UPPER;
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (cornUpper.getDefaultState().canPlaceAt(worldIn, pos.up()) && worldIn.isAir(pos.up())) {
                    worldIn.setBlockState(pos, state.with(AGE, this.getMaxAge()));
                    worldIn.setBlockState(pos.up(), cornUpper.getDefaultState().with(CornUpperBlock.CORN_AGE, remainingGrowth), 2);
                }
            }
        }

    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.randomTick(state, worldIn, pos, rand);

        if (!worldIn.isRegionLoaded(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            return;
        }

        if (worldIn.getLightLevel(pos.up(), 0) >= 6 && this.getAge(state) <= this.getMaxAge() && rand.nextInt(3) == 0) {
            randomGrowTick(state, worldIn, pos, rand);
        }
    }

    private void randomGrowTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int currentAge = this.getAge(state);
        if (currentAge <= this.getMaxAge() && rand.nextInt((int) (25.0F / GROWTH_CHANCE) + 1) == 0) {
            if (currentAge == this.getMaxAge()) {
                CornUpperBlock cornUpper = (CornUpperBlock) CDObjects.CORN_UPPER;
                if (cornUpper.getDefaultState().canPlaceAt(worldIn, pos.up()) && worldIn.isAir(pos.up())) {
                    worldIn.setBlockState(pos.up(), cornUpper.getDefaultState());
                }
            } else {
                worldIn.setBlockState(pos, state.with(AGE, this.getAge(state)+1));
            }
        }
    }

    static {
        AGE = Properties.AGE_3;
        SUPPORTING = BooleanProperty.of("supporting");
        SHAPE_BY_AGE = new VoxelShape[]{
                Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
                Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
                Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
                Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D)};
    }
}
