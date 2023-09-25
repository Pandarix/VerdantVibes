package net.Pandarix.verdantvibes.woldgen;

import com.google.common.collect.ImmutableList;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.woldgen.tree.decorator.TrunkIvyDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import static net.minecraft.data.worldgen.features.TreeFeatures.createStraightBlobTree;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_IVY_KEY = registerKey("birch_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_IVY_KEY = registerKey("oak_ivy");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, BIRCH_IVY_KEY, Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 4, 2, 0, 2)
                .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, OAK_IVY_KEY, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2)
                .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(VerdantVibes.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
