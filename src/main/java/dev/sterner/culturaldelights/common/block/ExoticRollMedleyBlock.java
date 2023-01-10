package dev.sterner.culturaldelights.common.block;

import com.nhoryzon.mc.farmersdelight.block.FeastBlock;
import dev.sterner.culturaldelights.common.registry.CDObjects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ExoticRollMedleyBlock extends FeastBlock {
    public static final IntProperty ROLL_SERVINGS = IntProperty.of("servings", 0, 8);
    protected static final VoxelShape PLATE_SHAPE = VoxelShapes.cuboid(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape FOOD_SHAPE;
    public final List<Item> riceRollServings;

    public ExoticRollMedleyBlock() {
        super(Settings.copy(Blocks.CAKE), CDObjects.TROPICAL_ROLL, true);
        this.riceRollServings = Arrays.asList(
                CDObjects.PUFFERFISH_ROLL,
                CDObjects.PUFFERFISH_ROLL,
                CDObjects.TROPICAL_ROLL,
                CDObjects.TROPICAL_ROLL,
                CDObjects.TROPICAL_ROLL,
                CDObjects.CHICKEN_ROLL_SLICE,
                CDObjects.CHICKEN_ROLL_SLICE,
                CDObjects.CHICKEN_ROLL_SLICE);
    }

    @Override
    public IntProperty getServingsProperty() {
        return ROLL_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 8;
    }

    @Override
    public ItemStack getServingStack(BlockState state) {
        return new ItemStack(riceRollServings.get(state.get(getServingsProperty()) - 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, ROLL_SERVINGS);
    }


    static {
        FOOD_SHAPE = VoxelShapes.combine(PLATE_SHAPE, VoxelShapes.cuboid(2.0, 2.0, 2.0, 14.0, 4.0, 14.0), BooleanBiFunction.OR);
    }
}
