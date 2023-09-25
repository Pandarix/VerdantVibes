package net.Pandarix.verdantvibes.woldgen;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BIRCH_IVY_PLACED_KEY = createKey("birch_ivy_placed");
    public static final ResourceKey<PlacedFeature> OAK_IVY_PLACED_KEY = createKey("oak_ivy_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BIRCH_IVY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIRCH_IVY_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(4), Blocks.BIRCH_SAPLING));

        register(context, OAK_IVY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OAK_IVY_KEY),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(4), Blocks.OAK_SAPLING));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(VerdantVibes.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
