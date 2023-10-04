package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroupInit {
    // Creates a creative tab with the id "VerdantVibes:example_tab" for the example item, that is placed after the combat tab
    public static final CreativeModeTab BEAUTIFY_TAB = new CreativeModeTab(VerdantVibes.MOD_ID) { // itemGroup.beautify
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.DRAGON_TREE.get());
        }
    };
}
