package dev.sterner.culturaldelights;

import dev.sterner.culturaldelights.common.registry.CDObjects;
import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class CulturalDelights implements ModInitializer {

	@Override
	public void onInitialize() {
		CDObjects.init();
		CDWorldGenerators.init();

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.CUCUMBER), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.EGGPLANT), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.CORN_COB), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.AVOCADO), 1, 10, 2, 0.2F));
		});
	}

	public static class EmeraldToItemOffer implements TradeOffers.Factory {

		private final ItemStack sell;
		private final int price;
		private final int maxUses;
		private final int experience;
		private final float multiplier;

		public EmeraldToItemOffer(ItemStack stack, int price, int maxUses, int experience, float multiplier) {
			this.sell = stack;
			this.price = price;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = multiplier;
		}

		public TradeOffer create(Entity entity, Random random) {
			return new TradeOffer(new ItemStack(Items.EMERALD, this.price + random.nextInt(3)), sell, this.maxUses, this.experience, this.multiplier);
		}
	}
}
