package net.Pandarix.verdantvibes.woldgen.tree.decorator;

import com.mojang.serialization.Codec;
import net.Pandarix.verdantvibes.block.custom.BracketMushroomBlock;
import net.Pandarix.verdantvibes.block.custom.VerdantVineBlock;
import net.Pandarix.verdantvibes.init.BlockInit;
import net.Pandarix.verdantvibes.init.TreeDecoratorInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class TrunkMushroomDecorator extends TreeDecorator {
    public static final Codec<TrunkMushroomDecorator> CODEC = Codec.unit(() -> {
        return TrunkMushroomDecorator.INSTANCE;
    });
    public static final TrunkMushroomDecorator INSTANCE = new TrunkMushroomDecorator();

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorInit.TRUNK_MUSHROOM.get();
    }

    public void place(Context pContext) {
        RandomSource randomsource = pContext.random();
        pContext.logs().forEach((p_226075_) -> {
            if (randomsource.nextInt(4) == 0) {
                BlockPos blockpos = p_226075_.west();
                if (pContext.isAir(blockpos)) {
                    pContext.setBlock(blockpos, BlockInit.BRACKET_MUSHROOM.get().defaultBlockState().setValue(BracketMushroomBlock.FACING, Direction.EAST));
                }
            }

            if (randomsource.nextInt(4) == 0) {
                BlockPos blockpos1 = p_226075_.east();
                if (pContext.isAir(blockpos1)) {
                    pContext.setBlock(blockpos1, BlockInit.BRACKET_MUSHROOM.get().defaultBlockState().setValue(BracketMushroomBlock.FACING, Direction.WEST));
                }
            }

            if (randomsource.nextInt(4) == 0) {
                BlockPos blockpos2 = p_226075_.north();
                if (pContext.isAir(blockpos2)) {
                    pContext.setBlock(blockpos2, BlockInit.BRACKET_MUSHROOM.get().defaultBlockState().setValue(BracketMushroomBlock.FACING, Direction.SOUTH));
                }
            }

            if (randomsource.nextInt(4) == 0) {
                BlockPos blockpos3 = p_226075_.south();
                if (pContext.isAir(blockpos3)) {
                    pContext.setBlock(blockpos3, BlockInit.BRACKET_MUSHROOM.get().defaultBlockState().setValue(BracketMushroomBlock.FACING, Direction.NORTH));
                }
            }
        });
    }
}
