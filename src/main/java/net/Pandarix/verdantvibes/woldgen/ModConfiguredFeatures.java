package net.Pandarix.verdantvibes.woldgen;

import com.google.common.collect.ImmutableList;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.woldgen.tree.decorator.TrunkIvyDecorator;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.worldgen.features.TreeFeatures.createStraightBlobTree;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, VerdantVibes.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_IVY_KEY = CONFIGURED_FEATURES.register("birch_ivy",
            () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 4, 2, 0, 2)
                    .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_IVY_KEY = CONFIGURED_FEATURES.register("oak_ivy",
            () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2)
                    .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build()));
}
