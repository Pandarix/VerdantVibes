package net.Pandarix.verdantvibes.events;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = VerdantVibes.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(BlockInit.MONSTERA.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockInit.POTTED_MONSTERA.get(), RenderType.cutout());
        }
    }
}
