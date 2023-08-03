package dev.sterner.culturaldelights.common.registry;

import dev.sterner.culturaldelights.CulturalDelights;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public enum CDConfiguredFeatures {
    PATCH_WILD_CORN("patch_wild_corn"),
    PATCH_WILD_CUCUMBERS("patch_wild_cucumbers"),
    PATCH_WILD_EGGPLANTS("patch_wild_eggplants");

    private final Identifier featureIdentifier;
    private RegistryKey<ConfiguredFeature<?, ?>> configuredFeatureRegistryKey;
    private RegistryKey<PlacedFeature> featureRegistryKey;

    CDConfiguredFeatures(String featurePathName) {
        this.featureIdentifier = new Identifier(CulturalDelights.MOD_ID, featurePathName);
    }

    public static void registerAll() {
        for (CDConfiguredFeatures value : values()) {
            value.configuredFeatureRegistryKey = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, value.featureIdentifier);
            value.featureRegistryKey = RegistryKey.of(RegistryKeys.PLACED_FEATURE, value.featureIdentifier);
        }
    }

    public RegistryKey<ConfiguredFeature<? extends FeatureConfig, ?>> configKey() {
        return configuredFeatureRegistryKey;
    }

    public RegistryKey<PlacedFeature> key() {
        return featureRegistryKey;
    }

    public Identifier identifier() {
        return featureIdentifier;
    }
}
