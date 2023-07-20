package dev.sterner.culturaldelights.common.registry;

import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.nhoryzon.mc.farmersdelight.block.WildCropBlock;
import com.nhoryzon.mc.farmersdelight.registry.BlocksRegistry;
import dev.sterner.culturaldelights.common.block.*;
import dev.sterner.culturaldelights.common.utils.Constants;
import dev.sterner.culturaldelights.common.world.AvocadoPitGenerator;
import dev.sterner.culturaldelights.common.world.AvocadoSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class CDObjects {
    public static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    public static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();



    public static final Item AVOCADO = register("avocado", new Item(settings().food(CDFoodComponents.AVOCADO)));
    public static final Item CUT_AVOCADO = register("cut_avocado", new Item(settings().food(CDFoodComponents.CUT_AVOCADO)));
    public static final Item CUCUMBER = register("cucumber", new Item(settings().food(CDFoodComponents.CUCUMBER)));
    public static final Item PICKLE = register("pickle", new Item(settings().food(CDFoodComponents.PICKLE)));
    public static final Item CUT_CUCUMBER = register("cut_cucumber", new Item(settings().food(CDFoodComponents.CUT_CUCUMBER)));
    public static final Item CUT_PICKLE = register("cut_pickle", new Item(settings().food(CDFoodComponents.CUT_PICKLE)));
    public static final Item EGGPLANT = register("eggplant", new Item(settings().food(CDFoodComponents.EGGPLANT)));
    public static final Item CUT_EGGPLANT = register("cut_eggplant", new Item(settings().food(CDFoodComponents.CUT_EGGPLANT)));
    public static final Item SMOKED_EGGPLANT = register("smoked_eggplant", new Item(settings().food(CDFoodComponents.SMOKED_EGGPLANT)));
    public static final Item SMOKED_TOMATO = register("smoked_tomato", new Item(settings().food(CDFoodComponents.SMOKED_TOMATO)));
    public static final Item SMOKED_CORN = register("smoked_corn", new Item(settings().food(CDFoodComponents.SMOKED_CORN)));
    public static final Item SMOKED_CUT_EGGPLANT = register("smoked_cut_eggplant", new Item(settings().food(CDFoodComponents.SMOKED_CUT_EGGPLANT)));
    public static final Item SMOKED_WHITE_EGGPLANT = register("smoked_white_eggplant", new Item(settings().food(CDFoodComponents.SMOKED_WHITE_EGGPLANT)));
    public static final Item WHITE_EGGPLANT = register("white_eggplant", new Item(settings().food(CDFoodComponents.WHITE_EGGPLANT)));
    public static final Item CORN_COB = register("corn_cob", new Item(settings().food(CDFoodComponents.CORN_COB)));
    public static final Item SQUID = register("squid", new Item(settings().food(CDFoodComponents.SQUID)));
    public static final Item COOKED_SQUID = register("cooked_squid", new Item(settings().food(CDFoodComponents.COOKED_SQUID)));
    public static final Item GLOW_SQUID = register("glow_squid", new Item(settings().food(CDFoodComponents.GLOW_SQUID)));
    public static final Item RAW_CALAMARI = register("raw_calamari", new Item(settings().food(CDFoodComponents.RAW_CALAMARI)));
    public static final Item COOKED_CALAMARI = register("cooked_calamari", new Item(settings().food(CDFoodComponents.COOKED_CALAMARI)));

    public static final Item POPCORN = register("popcorn", new Item(settings().food(CDFoodComponents.POPCORN)));
    public static final Item CORN_DOUGH = register("corn_dough", new Item(settings().food(CDFoodComponents.CORN_DOUGH)));
    public static final Item TORTILLA = register("tortilla", new Item(settings().food(CDFoodComponents.TORTILLA)));
    public static final Item TORTILLA_CHIPS = register("tortilla_chips", new Item(settings().food(CDFoodComponents.TORTILLA_CHIPS)));
    public static final Item ELOTE = register("elote", new Item(settings().food(CDFoodComponents.ELOTE)));
    public static final Item HEARTY_SALAD = register("hearty_salad", new StewItem(settings().food(CDFoodComponents.HEARTY_SALAD)));
    public static final Item BEEF_BURRITO = register("beef_burrito", new Item(settings().food(CDFoodComponents.BEEF_BURRITO)));
    public static final Item MUTTON_SANDWICH = register("mutton_sandwich", new Item(settings().food(CDFoodComponents.MUTTON_SANDWICH)));
    public static final Item FRIED_EGGPLANT_PASTA = register("fried_eggplant_pasta", new StewItem(settings().food(CDFoodComponents.FRIED_EGGPLANT_PASTA)));
    public static final Item EGGPLANT_BURGER = register("eggplant_burger", new Item(settings().food(CDFoodComponents.EGGPLANT_BURGER)));
    public static final Item AVOCADO_TOAST = register("avocado_toast", new Item(settings().food(CDFoodComponents.AVOCADO_TOAST)));
    public static final Item CREAMED_CORN = register("creamed_corn", new StewItem(settings().food(CDFoodComponents.CREAMED_CORN)));
    public static final Item CHICKEN_TACO = register("chicken_taco", new Item(settings().food(CDFoodComponents.CHICKEN_TACO)));
    public static final Item SPICY_CURRY = register("spicy_curry", new StewItem(settings().food(CDFoodComponents.SPICY_CURRY)));
    public static final Item PORK_WRAP = register("pork_wrap", new Item(settings().food(CDFoodComponents.PORK_WRAP)));
    public static final Item FISH_TACO = register("fish_taco", new Item(settings().food(CDFoodComponents.FISH_TACO)));
    public static final Item MIDORI_ROLL = register("midori_roll", new Item(settings().food(CDFoodComponents.MIDORI_ROLL)));
    public static final Item MIDORI_ROLL_SLICE = register("midori_roll_slice", new Item(settings().food(CDFoodComponents.MIDORI_ROLL_SLICE)));
    public static final Item EGG_ROLL = register("egg_roll", new Item(settings().food(CDFoodComponents.EGG_ROLL)));
    public static final Item CHICKEN_ROLL = register("chicken_roll", new Item(settings().food(CDFoodComponents.CHICKEN_ROLL)));
    public static final Item CHICKEN_ROLL_SLICE = register("chicken_roll_slice", new Item(settings().food(CDFoodComponents.CHICKEN_ROLL_SLICE)));
    public static final Item PUFFERFISH_ROLL = register("pufferfish_roll", new Item(settings().food(CDFoodComponents.PUFFERFISH_ROLL)));
    public static final Item TROPICAL_ROLL = register("tropical_roll", new Item(settings().food(CDFoodComponents.TROPICAL_ROLL)));
    public static final Item RICE_BALL = register("rice_ball", new Item(settings().food(CDFoodComponents.RICE_BALL)));
    public static final Item CALAMARI_ROLL = register("calamari_roll", new Item(settings().food(CDFoodComponents.CALAMARI_ROLL)));



    public static final Block AVOCADO_BUNDLE = register("avocado_bundle", new Block(FabricBlockSettings.copy(Blocks.PUMPKIN)), settings(), true);

    public static final Block WILD_CUCUMBERS = register("wild_cucumbers", new WildCropBlock(), settings(), true);
    public static final Block WILD_CORN = register("wild_corn", new WildCropBlock(), settings(), true);
    public static final Block WILD_EGGPLANTS = register("wild_eggplants", new WildCropBlock(), settings(), true);

    public static final Block AVOCADO_LOG = register("avocado_log", new PillarBlock(FabricBlockSettings.copy(Blocks.JUNGLE_LOG)), settings(), true);
    public static final Block AVOCADO_WOOD = register("avocado_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.JUNGLE_WOOD)), settings(), true);
    public static final Block AVOCADO_LEAVES = register("avocado_leaves", new PillarBlock(FabricBlockSettings.copy(Blocks.JUNGLE_LEAVES)), settings(), true);

    public static final Block AVOCADO_SAPLING = register("avocado_sapling", new SaplingBlock(new AvocadoSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)), settings(), true);

    public static final Block CUCUMBER_CROP = register("cucumbers", new CucumbersBlock(FabricBlockSettings.copy(Blocks.WHEAT)), settings(), false);
    public static final Block EGGPLANT_CROP = register("eggplants", new EggplantBlock(FabricBlockSettings.copy(Blocks.WHEAT)), settings(), false);

    public static final Block CORN_CROP = register("corn", new CornBlock(FabricBlockSettings.copy(Blocks.WHEAT)), settings(), false);
    public static final Block CORN_UPPER = register("corn_upper", new CornUpperBlock(FabricBlockSettings.copy(Blocks.WHEAT)), settings(), false);

    public static final Block AVOCADO_PIT = register("avocado_pit", new AvocadoPitBlock(new AvocadoPitGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)), settings(), true);

    public static final Block AVOCADO_CRATE = register("avocado_crate", new Block(FabricBlockSettings.copy(BlocksRegistry.CARROT_CRATE.get())), settings(), true);
    public static final Block CUCUMBER_CRATE = register("cucumber_crate", new Block(FabricBlockSettings.copy(BlocksRegistry.CARROT_CRATE.get())), settings(), true);
    public static final Block PICKLE_CRATE = register("pickle_crate", new Block(FabricBlockSettings.copy(BlocksRegistry.CARROT_CRATE.get())), settings(), true);
    public static final Block CORN_COB_CRATE = register("corn_cob_crate", new Block(FabricBlockSettings.copy(BlocksRegistry.CARROT_CRATE.get())), settings(), true);
    public static final Block EGGPLANT_CRATE = register("eggplant_crate", new Block(FabricBlockSettings.copy(BlocksRegistry.CARROT_CRATE.get())), settings(), true);


    public static final Block EXOTIC_ROLL_MEDLEY = register("exotic_roll_medley", new ExoticRollMedleyBlock(), settings(), true);

    public static final Item CUCUMBER_SEEDS = register("cucumber_seeds", new AliasedBlockItem(CUCUMBER_CROP ,settings()));
    public static final Item CORN_KERNELS = register("corn_kernels", new AliasedBlockItem(CORN_CROP, settings()));
    public static final Item EGGPLANT_SEEDS = register("eggplant_seeds", new AliasedBlockItem(EGGPLANT_CROP, settings()));

    private static Item.Settings settings() {
        return new Item.Settings().group(FarmersDelightMod.ITEM_GROUP);
    }

    private static <T extends Item> T register(String name, T item) {
        ITEMS.put(item, Constants.id(name));
        return item;
    }

    private static <T extends Block> T register(String name, T block, Item.Settings settings, boolean createItem) {
        BLOCKS.put(block, Constants.id(name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, settings), BLOCKS.get(block));
        }
        return block;
    }

    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));

        FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();
        flammableRegistry.add(AVOCADO_LEAVES, 30, 60);
        flammableRegistry.add(AVOCADO_LOG, 5, 5);
        flammableRegistry.add(AVOCADO_WOOD, 5, 5);

        CompostingChanceRegistry compostRegistry = CompostingChanceRegistry.INSTANCE;
        compostRegistry.add(CUCUMBER_SEEDS, 0.3f);
        compostRegistry.add(CORN_KERNELS, 0.3f);
        compostRegistry.add(EGGPLANT_SEEDS, 0.3f);
        compostRegistry.add(AVOCADO_PIT, 0.3f);

        compostRegistry.add(CUT_CUCUMBER, 0.5f);
        compostRegistry.add(CUT_AVOCADO, 0.5f);
        compostRegistry.add(CUT_EGGPLANT, 0.5f);

        compostRegistry.add(AVOCADO, 0.65f);
        compostRegistry.add(CUCUMBER, 0.65f);
        compostRegistry.add(CORN_COB, 0.65f);
        compostRegistry.add(EGGPLANT, 0.65f);
        compostRegistry.add(WILD_CUCUMBERS, 0.65f);
        compostRegistry.add(WILD_CORN, 0.65f);
        compostRegistry.add(WILD_EGGPLANTS, 0.65f);
        compostRegistry.add(AVOCADO_LEAVES, 0.65f);
        compostRegistry.add(AVOCADO_SAPLING, 0.65f);

        compostRegistry.add(POPCORN, 0.85f);

        compostRegistry.add(AVOCADO_BUNDLE, 1f);
    }
}
