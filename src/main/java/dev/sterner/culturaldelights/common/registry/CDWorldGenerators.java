package dev.sterner.culturaldelights.common.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class CDWorldGenerators {

    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO = ConfiguredFeatures.of("culturaldelights:avocado");
    public static final RegistryKey<PlacedFeature> TREE_AVOCADO = PlacedFeatures.of("culturaldelights:tree_avocado");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO_PIT = ConfiguredFeatures.of("culturaldelights:avocado_pit");
    public static final RegistryKey<PlacedFeature> TREE_AVOCADO_PIT = PlacedFeatures.of("culturaldelights:tree_avocado_pit");

    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, TREE_AVOCADO);
    }
}
