package net.Pandarix.verdantvibes.util;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.init.BlockInit;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VerdantVibes.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorHandler
{
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        //Foliage Coloring
        event.getBlockColors().register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
                BlockInit.PARLOUR_PALM.get(), BlockInit.DRAGON_TREE.get(), BlockInit.MONSTERA.get(), BlockInit.CANDY_TUFT.get(), BlockInit.PERIWINKLE.get(), BlockInit.LOBELIA.get(), BlockInit.IVY.get(), BlockInit.MONEY_TREE.get(), BlockInit.TALL_DRAGON_TREE.get(), BlockInit.CATTAILS.get(), BlockInit.BURNWEED.get());
    }
}