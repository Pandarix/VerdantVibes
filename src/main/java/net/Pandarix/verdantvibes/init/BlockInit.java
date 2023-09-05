package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.block.TurnableFlowerPotBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit  {
    // Create a Deferred Register to hold Blocks which will all be registered under the "VerdantVibes" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VerdantVibes.MOD_ID);

    // -----------BLOCKS--------------------------------------------------------------------------//
    // -----------Category
    public static final RegistryObject<Block> POTTED_LARGE_FERN = BLOCKS.register("potted_large_fern", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), () -> Blocks.LARGE_FERN, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

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
