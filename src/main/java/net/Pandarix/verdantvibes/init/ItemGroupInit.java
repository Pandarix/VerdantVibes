package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemGroupInit {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "VerdantVibes" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VerdantVibes.MOD_ID);

    // Creates a creative tab with the id "VerdantVibes:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> VERDANT_VIBES_ITEMGROUP = CREATIVE_MODE_TABS.register("verdantvibes", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BlockInit.MONEY_TREE.get())).title(Component.translatable("itemGroup." + VerdantVibes.MOD_ID))
            .displayItems((parameters, output) -> {
                // Category
                output.accept(BlockInit.MONSTERA.get());
                output.accept(BlockInit.SNAKE_PLANT.get());
                output.accept(BlockInit.PARLOUR_PALM.get());
                output.accept(BlockInit.MONEY_TREE.get());
                output.accept(BlockInit.CANDY_TUFT.get());
                output.accept(BlockInit.PERIWINKLE.get());
            }).build());
}
