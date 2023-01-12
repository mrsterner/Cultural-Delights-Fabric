package dev.sterner.culturaldelights.common.registry;

import dev.sterner.culturaldelights.common.utils.Constants;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CDTags {
    public static final TagKey<Item> CORN = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "corn"));
}
