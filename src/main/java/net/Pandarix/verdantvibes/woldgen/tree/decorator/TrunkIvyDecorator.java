package net.Pandarix.verdantvibes.woldgen.tree.decorator;

import com.mojang.serialization.Codec;
import net.Pandarix.verdantvibes.block.custom.VerdantVineBlock;
import net.Pandarix.verdantvibes.init.BlockInit;
import net.Pandarix.verdantvibes.init.TreeDecoratorInit;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class TrunkIvyDecorator extends TreeDecorator {
    public static final Codec<TrunkIvyDecorator> CODEC = Codec.unit(() -> {
        return TrunkIvyDecorator.INSTANCE;
    });
    public static final TrunkIvyDecorator INSTANCE = new TrunkIvyDecorator();

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorInit.TRUNK_IVY.get();
    }

    public void place(TreeDecorator.Context pContext) {
        RandomSource randomsource = pContext.random();
        pContext.logs().forEach((p_226075_) -> {
            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos = p_226075_.west();
                if (pContext.isAir(blockpos)) {
                    pContext.setBlock(blockpos, BlockInit.IVY.get().defaultBlockState().setValue(VerdantVineBlock.EAST, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos1 = p_226075_.east();
                if (pContext.isAir(blockpos1)) {
                    pContext.setBlock(blockpos1, BlockInit.IVY.get().defaultBlockState().setValue(VerdantVineBlock.WEST, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos2 = p_226075_.north();
                if (pContext.isAir(blockpos2)) {
                    pContext.setBlock(blockpos2, BlockInit.IVY.get().defaultBlockState().setValue(VerdantVineBlock.SOUTH, Boolean.valueOf(true)));
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos3 = p_226075_.south();
                if (pContext.isAir(blockpos3)) {
                    pContext.setBlock(blockpos3, BlockInit.IVY.get().defaultBlockState().setValue(VerdantVineBlock.NORTH, Boolean.valueOf(true)));
                }
            }
        });
    }
}
