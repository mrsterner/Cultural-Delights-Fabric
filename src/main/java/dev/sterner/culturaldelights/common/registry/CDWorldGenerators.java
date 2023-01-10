package dev.sterner.culturaldelights.common.registry;

import com.google.common.collect.ImmutableList;
import dev.sterner.culturaldelights.common.utils.Constants;
import dev.sterner.culturaldelights.common.world.AvocadoBundleTreeDecorator;
import dev.sterner.culturaldelights.mixin.SimpleBlockStateProviderAccessor;
import dev.sterner.culturaldelights.mixin.TreeDecoratorTypeInvoker;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class CDWorldGenerators {
    private static final FeatureSize EMPTY_SIZE = new TwoLayersFeatureSize(0, 0, 0);
    public static final TreeDecoratorType<AvocadoBundleTreeDecorator> AVOCADO_BUNDLE_TREE_DECORATOR_TYPE = TreeDecoratorTypeInvoker.register("avocado", AvocadoBundleTreeDecorator.CODEC);

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> AVOCADO_TREE =
            ConfiguredFeatures.register("culturaldelights:avocado_tree",
                    Feature.TREE,
                    new TreeFeatureConfig.Builder(
                            SimpleBlockStateProviderAccessor.callInit(CDObjects.AVOCADO_LOG.getDefaultState()),
                            new StraightTrunkPlacer(5, 0, 0),
                            SimpleBlockStateProviderAccessor.callInit(CDObjects.AVOCADO_LEAVES.getDefaultState()),
                            new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0)),
                            EMPTY_SIZE)
                            .decorators(ImmutableList.of(new AvocadoBundleTreeDecorator(1)))
                            .ignoreVines()
                            .build());


    public static final RegistryEntry<PlacedFeature> AVOCADO_PLACED =
            PlacedFeatures.register("culturaldelights:avocado_tree_with_chance", AVOCADO_TREE,
                    VegetationPlacedFeatures.modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
                            CDObjects.AVOCADO_SAPLING));


    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> AVOCADO_PIT =
            ConfiguredFeatures.register("culturaldelights:avocado_pit",
                    Feature.TREE,
                    new TreeFeatureConfig.Builder(
                            SimpleBlockStateProviderAccessor.callInit(CDObjects.AVOCADO_SAPLING.getDefaultState()),
                            new StraightTrunkPlacer(3, 2, 0),
                            SimpleBlockStateProviderAccessor.callInit(CDObjects.AVOCADO_SAPLING.getDefaultState()),
                            new AcaciaFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)),
                            new TwoLayersFeatureSize(1, 0, 1))
                            .build());



    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WILD_CORN =
            ConfiguredFeatures.register("wild_corn", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(SimpleBlockStateProviderAccessor.callInit(CDObjects.WILD_CORN.getDefaultState())))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WILD_EGGPLANTS =
            ConfiguredFeatures.register("wild_eggplants", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(SimpleBlockStateProviderAccessor.callInit(CDObjects.WILD_EGGPLANTS.getDefaultState())))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WILD_CUCUMBERS =
            ConfiguredFeatures.register("wild_cucumbers", Feature.FLOWER,
                    new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(SimpleBlockStateProviderAccessor.callInit(CDObjects.WILD_CUCUMBERS.getDefaultState())))));

    public static final RegistryEntry<PlacedFeature> WILD_CORN_PLACED = PlacedFeatures.register("wild_corn_placed",
            WILD_CORN, RarityFilterPlacementModifier.of(25),
            SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> WILD_EGGPLANTS_PLACED = PlacedFeatures.register("wild_eggplants_placed",
            WILD_EGGPLANTS, RarityFilterPlacementModifier.of(25),
            SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> WILD_CUCUMBERS_PLACED = PlacedFeatures.register("wild_cucumbers_placed",
            WILD_CUCUMBERS, RarityFilterPlacementModifier.of(25),
            SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,  BiomePlacementModifier.of());

    public static void init() {


        BiomeModification worldGen = BiomeModifications.create(Constants.id("world_features"));

        worldGen.add(ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                context -> context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, AVOCADO_PLACED.getKey().get()));

        worldGen.add(ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(ConventionalBiomeTags.PLAINS),
                context -> context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, WILD_CORN_PLACED.getKey().get()));

        worldGen.add(ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(ConventionalBiomeTags.SWAMP),
                context -> {
                    context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, WILD_EGGPLANTS_PLACED.getKey().get());
                    context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, WILD_CUCUMBERS_PLACED.getKey().get());
                });

        worldGen.add(ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(ConventionalBiomeTags.JUNGLE),
                context -> context.getGenerationSettings().addFeature(GenerationStep.Feature.VEGETAL_DECORATION, WILD_EGGPLANTS_PLACED.getKey().get()));
    }
}
