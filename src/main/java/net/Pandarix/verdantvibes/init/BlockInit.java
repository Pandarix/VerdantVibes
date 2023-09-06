package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.block.custom.VerdantPlantBlock;
import net.Pandarix.verdantvibes.block.custom.TurnableFlowerPotBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit  {
    // Create a Deferred Register to hold Blocks which will all be registered under the "VerdantVibes" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VerdantVibes.MOD_ID);

    // -----------BLOCKS--------------------------------------------------------------------------//
    // -----------Plants
    public static final RegistryObject<Block> MONSTERA = registerBlock("monstera",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CHERRY_SAPLING).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    // -----------Potted
    public static final RegistryObject<Block> POTTED_MONSTERA = registerBlock("potted_monstera", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), () -> MONSTERA.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    // -----------REGISTRATION--------------------------------------------------------------------------//
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
