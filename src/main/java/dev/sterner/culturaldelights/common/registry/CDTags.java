package dev.sterner.culturaldelights.common.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CDTags {
    public static final TagKey<Item> CORN = TagKey.of(RegistryKeys.ITEM, new Identifier("c", "corn"));
}
