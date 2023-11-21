package net.Pandarix.verdantvibes.particles;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, VerdantVibes.MOD_ID);

    public static final RegistryObject<SimpleParticleType> BURNWEED_PARTICLES =
            PARTICLE_TYPES.register("burnweed_particles", () -> new SimpleParticleType(true));
}
