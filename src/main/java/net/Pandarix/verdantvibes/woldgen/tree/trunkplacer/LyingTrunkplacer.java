package net.Pandarix.verdantvibes.woldgen.tree.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class LyingTrunkplacer extends TrunkPlacer {
    public static final Codec<LyingTrunkplacer> CODEC = RecordCodecBuilder.create((p_70261_) -> {
        return trunkPlacerParts(p_70261_).apply(p_70261_, LyingTrunkplacer::new);
    });

    public LyingTrunkplacer(int p_70248_, int p_70249_, int p_70250_) {
        super(p_70248_, p_70249_, p_70250_);
    }

    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.LYING_TRUNK_PLACER.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);

        if(pRandom.nextBoolean()){
            for(int i = 0; i < pFreeTreeHeight; ++i) {
               pBlockSetter.accept(pPos.north(i - 2), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
            }
        } else {
            for(int i = 0; i < pFreeTreeHeight; ++i) {
                pBlockSetter.accept(pPos.east(i - 2), ((BlockState)
                        Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
            }
        }

        return ImmutableList.of();
    }
}
