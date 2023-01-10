package dev.sterner.culturaldelights.common.world;

import com.mojang.serialization.Codec;
import dev.sterner.culturaldelights.common.registry.CDObjects;
import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        if ((random.nextFloat() < this.probability)) {
            List<BlockPos> list = generator.getLeavesPositions();
            if (!list.isEmpty()) {
                List<BlockPos> list3 = list.stream().filter((pos) -> generator.isAir(pos.down()) && generator.isAir(pos.down(2)) && generator.isAir(pos.down(3))).collect(Collectors.toList());
                if (!list3.isEmpty()) {
                    for(Direction direction : Direction.Type.HORIZONTAL) {
                        if (random.nextFloat() <= 0.25F) {
                            Collections.shuffle(list3);
                            Optional<BlockPos> optional = list3.stream().findFirst();
                            if (optional.isPresent()) {
                                generator.replace(optional.get().down(), CDObjects.AVOCADO_BUNDLE.getDefaultState());
                            }
                        }
                    }

                }
            }
        }

    }
}
