package dev.sterner.culturaldelights.common.world;

import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AvocadoSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CDWorldGenerators.AVOCADO_TREE;
    }
}
