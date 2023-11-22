package net.Pandarix.verdantvibes.woldgen;

import com.google.common.collect.ImmutableList;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.woldgen.tree.decorator.TrunkIvyDecorator;
import net.Pandarix.verdantvibes.woldgen.tree.decorator.TrunkMushroomDecorator;
import net.Pandarix.verdantvibes.woldgen.tree.trunkplacer.LyingTrunkplacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import static net.minecraft.data.worldgen.features.TreeFeatures.createStraightBlobTree;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_IVY_KEY = registerKey("birch_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_IVY_KEY = registerKey("oak_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_MUSHROOM_KEY = registerKey("spruce_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LYING_BIRCH_MUSHROOM_KEY = registerKey("lying_birch_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LYING_SPRUCE_MUSHROOM_KEY = registerKey("lying_spruce_mushroom");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, BIRCH_IVY_KEY, Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 4, 2, 0, 2)
                .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, OAK_IVY_KEY, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2)
                .decorators(ImmutableList.of(TrunkIvyDecorator.INSTANCE)).build());

        register(context, SPRUCE_MUSHROOM_KEY, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3),
                UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().decorators(ImmutableList.of(TrunkMushroomDecorator.INSTANCE)).build());

        register(context, LYING_BIRCH_MUSHROOM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new LyingTrunkplacer(3, 1, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BlobFoliagePlacer(ConstantInt.of(0),
                ConstantInt.of(0), 0), new TwoLayersFeatureSize(1, 0, 1))
                .decorators(ImmutableList.of(TrunkMushroomDecorator.INSTANCE)).build());

        register(context, LYING_SPRUCE_MUSHROOM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new LyingTrunkplacer(4, 1, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new BlobFoliagePlacer(ConstantInt.of(0),
                ConstantInt.of(0), 0), new TwoLayersFeatureSize(1, 0, 1))
                .decorators(ImmutableList.of(TrunkMushroomDecorator.INSTANCE)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(VerdantVibes.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
