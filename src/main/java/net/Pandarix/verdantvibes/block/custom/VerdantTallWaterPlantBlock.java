package net.Pandarix.verdantvibes.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;
import java.util.List;

public class VerdantTallWaterPlantBlock extends VerdantTallPlantBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public VerdantTallWaterPlantBlock(Properties pProperties, List<Block> mayPlaceOn, VoxelShape pVoxelShape) {
        super(pProperties, mayPlaceOn, pVoxelShape);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    /*
    returns true if:
    - Custom specified List of Blocks contains the Block to be placed on or if it is a normal supporting Block for WaterPlants
    - The Block above the Lower half to be placed is Air (so the tip is above water)
     */
    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        if(mayPlaceOn.contains(pState.getBlock()) || pState.is(BlockTags.DIRT) || pState.is(Blocks.SAND) || pState.is(Blocks.GRAVEL)){
            return pLevel.getBlockState(pPos.above(2)).is(Blocks.AIR);
        }
        return false;
    }

    //  reverting the slow because water already slows enough
    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
    }

    // makes Block Waterlogged if placed inside of Water
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.isSourceOfType(Fluids.WATER))).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    /*
    return true if:
    - If Block is upper half: below is lower half and upper is not waterlogged
    - If Block is lower half: block below can support this plant and lower half is waterlogged
     */
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        if (pState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState belowState = pLevel.getBlockState(pPos.below());
            return belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER && !pState.getValue(WATERLOGGED);
        } else {
            if(pState.is(this)){
                return pState.getValue(WATERLOGGED) && this.mayPlaceOn(pLevel.getBlockState(pPos.below()), pLevel, pPos);
            }
            FluidState fluidstate = pLevel.getFluidState(pPos);
            return super.canSurvive(pState, pLevel, pPos) && fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8;
        }
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.BEACH;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(WATERLOGGED);
    }
}