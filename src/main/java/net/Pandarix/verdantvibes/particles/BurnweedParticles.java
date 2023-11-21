package net.Pandarix.verdantvibes.particles;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BurnweedParticles extends CherryParticle {
    private final int perParticleLifetime;

    protected BurnweedParticles(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet pSpriteSet) {
        super(pLevel, pX, pY, pZ, pSpriteSet);
        this.age = 0;
        this.xd += 0.1 * Math.sin(pLevel.random.nextDouble());
        this.zd += 0.1 * Math.cos(pLevel.random.nextDouble());
        this.perParticleLifetime = pLevel.random.nextInt(30, 70);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public void tick() {
        super.tick();
        age += 1;
        if(this.age >= this.perParticleLifetime){
            this.remove();
        }
        this.alpha = (float) Math.cos(((double) age / perParticleLifetime) * Math.PI/2);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            return new BurnweedParticles(level, x, y, z, this.sprites);
        }
    }
}
