package dev.sterner.culturaldelights.common.world;

import com.mojang.serialization.Codec;
import dev.sterner.culturaldelights.common.registry.CDObjects;
import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AvocadoBundleTreeDecorator extends TreeDecorator {

    public static final Codec<AvocadoBundleTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(AvocadoBundleTreeDecorator::new, (thing) -> thing.probability).codec();
    private final float probability;

    public AvocadoBundleTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return CDWorldGenerators.AVOCADO_BUNDLE_TREE_DECORATOR_TYPE;
    }

    @Override
    public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
        if ((random.nextFloat() < this.probability)) {
            if (!leavesPositions.isEmpty()) {
                List<BlockPos> list3 = leavesPositions.stream()
                        .filter((pos) -> Feature.isAir(world, pos.down()) && Feature.isAir(world, pos.down(2)) && Feature.isAir(world, pos.down(3)))
                        .collect(Collectors.toList());
                if (!list3.isEmpty()) {
                    for(Direction direction : Direction.Type.HORIZONTAL) {
                        if (random.nextFloat() <= 0.25F) {
                            Collections.shuffle(list3);
                            Optional<BlockPos> optional = list3.stream().findFirst();
                            if (optional.isPresent()) {
                                replacer.accept(optional.get().down(), CDObjects.AVOCADO_BUNDLE.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
    }
}
