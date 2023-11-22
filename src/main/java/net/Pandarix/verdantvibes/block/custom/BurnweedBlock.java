package net.Pandarix.verdantvibes.block.custom;

import net.Pandarix.verdantvibes.particles.ParticleInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class BurnweedBlock extends VerdantTallPlantBlock implements BonemealableBlock {
    private static final IntegerProperty SIZE = IntegerProperty.create("size", 0, 2);

    public BurnweedBlock(Properties pProperties, List<Block> mayPlaceOn, VoxelShape pVoxelShape) {
        super(pProperties, mayPlaceOn, pVoxelShape);
        this.registerDefaultState(this.defaultBlockState().setValue(SIZE, 0));
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(HALF) == DoubleBlockHalf.UPPER && pLevel.isClientSide()
                && pRandom.nextIntBetweenInclusive(0, 3) == 0)
        {
            Vec3 pos = pPos.getCenter();
            pLevel.addParticle(ParticleInit.BURNWEED_PARTICLES.get(), pos.x, pos.y + (0.5 * pRandom.nextDouble()), pos.z, 0, 0, 0);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(blockpos, copyWaterloggedFrom(pLevel, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING ,pLevel.getBlockState(pPos).getValue(FACING)).setValue(SIZE, pLevel.getBlockState(pPos).getValue(SIZE))), 3);
    }

    public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags) {
        BlockPos blockpos = pPos.above();
        pLevel.setBlock(pPos, copyWaterloggedFrom(pLevel, pPos, pState.setValue(HALF, DoubleBlockHalf.LOWER)), pFlags);
        pLevel.setBlock(blockpos, copyWaterloggedFrom(pLevel, blockpos, pState.setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING , pLevel.getBlockState(pPos).getValue(FACING)).setValue(SIZE, pLevel.getBlockState(pPos).getValue(SIZE))), pFlags);
    }

    //  reverting the slow because water already slows enough
    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(SIZE, pContext.getLevel().getRandom().nextIntBetweenInclusive(0,2));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return voxelShape.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SIZE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        popResource(pLevel, pPos, new ItemStack(this));
    }
}