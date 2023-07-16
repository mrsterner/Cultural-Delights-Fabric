package dev.sterner.culturaldelights.common.registry;

import dev.sterner.culturaldelights.common.utils.Constants;
import dev.sterner.culturaldelights.common.world.AvocadoBundleTreeDecorator;
import dev.sterner.culturaldelights.mixin.TreeDecoratorTypeInvoker;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class CDWorldGenerators {

    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO = ConfiguredFeatures.of("culturaldelights:avocado");
    public static final RegistryKey<PlacedFeature> TREE_AVOCADO = PlacedFeatures.of("culturaldelights:tree_avocado");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AVOCADO_PIT = ConfiguredFeatures.of("culturaldelights:avocado_pit");
    public static final RegistryKey<PlacedFeature> TREE_AVOCADO_PIT = PlacedFeatures.of("culturaldelights:tree_avocado_pit");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_CORN = ConfiguredFeatures.of("culturaldelights:wild_corn");
    public static final RegistryKey<PlacedFeature> WILD_CORN_PLACED = PlacedFeatures.of("culturaldelights:wild_corn");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_CUCUMBERS = ConfiguredFeatures.of("culturaldelights:wild_cucumbers");
    public static final RegistryKey<PlacedFeature> WILD_CUCUMBERS_PLACED = PlacedFeatures.of("culturaldelights:wild_cucumbers");

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_EGGPLANTS = ConfiguredFeatures.of("culturaldelights:wild_eggplants");
    public static final RegistryKey<PlacedFeature> WILD_EGGPLANTS_PLACED = PlacedFeatures.of("culturaldelights:wild_eggplants");


    public static void init() {
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, TREE_AVOCADO);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, WILD_CORN_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.SWAMP), GenerationStep.Feature.VEGETAL_DECORATION, WILD_EGGPLANTS_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.SWAMP), GenerationStep.Feature.VEGETAL_DECORATION, WILD_CUCUMBERS_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, WILD_EGGPLANTS_PLACED);
    }
}
