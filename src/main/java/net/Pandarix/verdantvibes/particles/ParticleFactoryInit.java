package net.Pandarix.verdantvibes.particles;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VerdantVibes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryInit {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleInit.BURNWEED_PARTICLES.get(),
                BurnweedParticles.Provider::new);
    }
}
