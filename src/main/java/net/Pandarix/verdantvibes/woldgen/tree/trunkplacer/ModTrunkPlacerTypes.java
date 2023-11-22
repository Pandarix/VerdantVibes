package net.Pandarix.verdantvibes.woldgen.tree.trunkplacer;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, VerdantVibes.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<LyingTrunkplacer>> LYING_TRUNK_PLACER =
            TRUNK_PLACER.register("lying_trunk_placer", () -> new TrunkPlacerType<>(LyingTrunkplacer.CODEC));
}
