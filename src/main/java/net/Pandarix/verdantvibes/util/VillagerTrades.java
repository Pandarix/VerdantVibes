package net.Pandarix.verdantvibes.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.init.BlockInit;
import net.Pandarix.verdantvibes.init.VillagerInit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = VerdantVibes.MOD_ID)
public class VillagerTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerInit.GARDENER.get()) {
            Int2ObjectMap<List<net.minecraft.world.entity.npc.VillagerTrades.ItemListing>> trades = event.getTrades();

            //LVL 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.MONSTERA.get(), 1),
                    8, 4, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.IVY.get(), 4),
                    16, 4, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.LOBELIA.get(), 1),
                    8, 4, 0.02f));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.SNAKE_PLANT.get(), 1),
                    8, 4, 0.02f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.DRAGON_TREE.get(), 1),
                    8, 8, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.PARLOUR_PALM.get(), 1),
                    8, 8, 0.02f));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(BlockInit.MONEY_TREE.get(), 1),
                    8, 8, 0.02f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.BONE, 16),
                    new ItemStack(Items.EMERALD, 1),
                    8, 4, 0.02f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Blocks.PODZOL, 2),
                    16, 8, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(Blocks.LILY_PAD, 4),
                    16, 4, 0.02f));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(Blocks.VINE, 4),
                    16, 4, 0.02f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(Blocks.FLOWER_POT, 2),
                    8, 8, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Blocks.MOSS_BLOCK, 1),
                    16, 4, 0.02f));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(Blocks.SMALL_DRIPLEAF, 2),
                    8, 4, 0.02f));
        }
    }
}
