package net.Pandarix.verdantvibes.woldgen;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, VerdantVibes.MOD_ID);

    public static final RegistryObject<PlacedFeature> BIRCH_IVY_PLACED_KEY = PLACED_FEATURES.register("birch_ivy_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BIRCH_IVY_KEY.getHolder().get(),
            VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), Blocks.BIRCH_SAPLING)));

    public static final RegistryObject<PlacedFeature> OAK_IVY_PLACED_KEY = PLACED_FEATURES.register("oak_ivy_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.OAK_IVY_KEY.getHolder().get(),
                    VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(2), Blocks.OAK_SAPLING)));
}
