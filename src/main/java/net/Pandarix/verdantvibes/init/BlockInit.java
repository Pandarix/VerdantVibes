package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.block.custom.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class BlockInit {
    // Create a Deferred Register to hold Blocks which will all be registered under the "VerdantVibes" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VerdantVibes.MOD_ID);

    // -----------BLOCKS--------------------------------------------------------------------------//
    // -----------Gardening Table
    public static final RegistryObject<Block> GARDENING_TABLE = registerBlock("gardening_table",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));

    // -----------Plants
    public static final RegistryObject<Block> MONSTERA = registerBlock("monstera",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.AZALEA).offsetType(BlockBehaviour.OffsetType.XZ), List.of(), Block.box(3, 0, 3, 13, 15, 13)));

    public static final RegistryObject<Block> SNAKE_PLANT = registerBlock("snake_plant",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.SAND, Blocks.RED_SAND), Block.box(2, 0, 2, 14, 16, 14)));

    public static final RegistryObject<Block> PARLOUR_PALM = registerBlock("parlour_palm",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.SAND), Block.box(2, 0, 2, 14, 22, 14)));

    public static final RegistryObject<Block> MONEY_TREE = registerWaterPlaceableBlock("money_tree",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.MUD), Block.box(3, 0, 3, 13, 10, 13)));

    public static final RegistryObject<Block> LOBELIA = registerBlock("lobelia",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(), Block.box(3, 0, 3, 13, 14, 13)));

    public static final RegistryObject<Block> TALL_DRAGON_TREE = registerBlockWithoutItem("tall_dragon_tree",
            () -> new VerdantTallPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()).sound(SoundType.GRASS).strength(0.2f), List.of(Blocks.SAND), Block.box(2, 0, 3, 13, 16, 13)));

    public static final RegistryObject<Block> DRAGON_TREE = registerBlock("dragon_tree",
            () -> new VerdantGrowablePlantBlock(BlockBehaviour.Properties.copy(TALL_DRAGON_TREE.get()), List.of(Blocks.SAND), Block.box(2, 0, 3, 13, 23, 13), (VerdantTallPlantBlock) TALL_DRAGON_TREE.get()));

    public static final RegistryObject<Block> CANDY_TUFT = registerBlock("candy_tuft",
            () -> new VerdantPetalPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().sound(SoundType.FLOWERING_AZALEA), List.of(Blocks.GRAVEL, Blocks.COARSE_DIRT), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)));

    public static final RegistryObject<Block> PERIWINKLE = registerBlock("periwinkle",
            () -> new VerdantPetalPlantBlock(BlockBehaviour.Properties.copy(CANDY_TUFT.get()), List.of(), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)));

    public static final RegistryObject<Block> IVY = registerBlock("ivy",
            () -> new VerdantVineBlock(BlockBehaviour.Properties.copy(Blocks.VINE)));

    // -----------Potted
    public static final RegistryObject<Block> POTTED_MONSTERA = registerBlockWithoutItem("potted_monstera", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONSTERA, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_SNAKE_PLANT = registerBlockWithoutItem("potted_snake_plant", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), SNAKE_PLANT, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_PARLOUR_PALM = registerBlockWithoutItem("potted_parlour_palm", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), PARLOUR_PALM, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_MONEY_TREE = registerBlockWithoutItem("potted_money_tree", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONEY_TREE, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_DRAGON_TREE = registerBlockWithoutItem("potted_dragon_tree", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), DRAGON_TREE, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_LOBELIA = registerBlockWithoutItem("potted_lobelia", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONEY_TREE, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_IVY = registerBlockWithoutItem("potted_ivy", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), IVY, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    // -----------REGISTRATION--------------------------------------------------------------------------//
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ItemGroupInit.BEAUTIFY_TAB)));
    }

    private static <T extends Block> RegistryObject<T> registerWaterPlaceableBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerWaterPlaceableBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerWaterPlaceableBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties().tab(ItemGroupInit.BEAUTIFY_TAB)));
    }
}
