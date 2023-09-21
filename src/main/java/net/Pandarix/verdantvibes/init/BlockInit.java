package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.block.custom.TurnableFlowerPotBlock;
import net.Pandarix.verdantvibes.block.custom.VerdantPetalPlantBlock;
import net.Pandarix.verdantvibes.block.custom.VerdantPlantBlock;
import net.Pandarix.verdantvibes.block.custom.VerdantVineBlock;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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
    // -----------Plants
    public static final RegistryObject<Block> MONSTERA = registerBlock("monstera",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.CHERRY_SAPLING).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY), List.of(), Block.box(3, 0, 3, 13, 15, 13)));

    public static final RegistryObject<Block> SNAKE_PLANT = registerBlock("snake_plant",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.SAND, Blocks.RED_SAND), Block.box(2, 0, 2, 14, 16, 14)));

    public static final RegistryObject<Block> PARLOUR_PALM = registerBlock("parlour_palm",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.SAND), Block.box(2, 0, 2, 14, 22, 14)));

    public static final RegistryObject<Block> MONEY_TREE = registerWaterPlaceableBlock("money_tree",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(Blocks.MUD), Block.box(3, 0, 3, 13, 10, 13)));

    public static final RegistryObject<Block> LOBELIA = registerWaterPlaceableBlock("lobelia",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()), List.of(), Block.box(3, 0, 3, 13, 14, 13)));

    public static final RegistryObject<Block> DRAGON_TREE = registerWaterPlaceableBlock("dragon_tree",
            () -> new VerdantPlantBlock(BlockBehaviour.Properties.copy(MONSTERA.get()).sound(SoundType.GRASS), List.of(), Block.box(2, 0, 3, 13, 23, 13)));

    public static final RegistryObject<Block> CANDY_TUFT = registerBlock("candy_tuft",
            () -> new VerdantPetalPlantBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS), List.of(Blocks.GRAVEL, Blocks.COARSE_DIRT), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)));

    public static final RegistryObject<Block> PERIWINKLE = registerBlock("periwinkle",
            () -> new VerdantPetalPlantBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS), List.of(), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)));

    public static final RegistryObject<Block> IVY = registerBlock("ivy",
            () -> new VerdantVineBlock(BlockBehaviour.Properties.copy(Blocks.VINE)));

    // -----------Potted
    public static final RegistryObject<Block> POTTED_MONSTERA = registerBlock("potted_monstera", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONSTERA, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_SNAKE_PLANT = registerBlock("potted_snake_plant", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), SNAKE_PLANT, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_PARLOUR_PALM = registerBlock("potted_parlour_palm", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), PARLOUR_PALM, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_MONEY_TREE = registerBlock("potted_money_tree", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONEY_TREE, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    public static final RegistryObject<Block> POTTED_LOBELIA = registerBlock("potted_lobelia", () -> new TurnableFlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), MONEY_TREE, BlockBehaviour.Properties.copy(Blocks.POTTED_CORNFLOWER)));

    // -----------REGISTRATION--------------------------------------------------------------------------//
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerWaterPlaceableBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerWaterPlaceableBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerWaterPlaceableBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
    }
}
