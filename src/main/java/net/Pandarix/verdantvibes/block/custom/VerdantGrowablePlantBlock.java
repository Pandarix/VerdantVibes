package net.Pandarix.verdantvibes.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class VerdantGrowablePlantBlock extends VerdantPlantBlock {
    private final VerdantTallPlantBlock grownPlant;
    public VerdantGrowablePlantBlock(Properties pProperties, List<Block> mayPlaceOn, VoxelShape pVoxelShape, VerdantTallPlantBlock pGrownPlant) {
        super(pProperties, mayPlaceOn, pVoxelShape);
        grownPlant = pGrownPlant;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        if(pLevel.getBlockState(pPos.above()).isAir()){
            pLevel.setBlock(pPos, grownPlant.defaultBlockState().setValue(FACING, pState.getValue(FACING)).setValue(VerdantTallPlantBlock.HALF, DoubleBlockHalf.LOWER), 3);
            pLevel.setBlock(pPos.above(), grownPlant.defaultBlockState().setValue(FACING, pState.getValue(FACING)).setValue(VerdantTallPlantBlock.HALF, DoubleBlockHalf.UPPER), 3);
        }
    }
}