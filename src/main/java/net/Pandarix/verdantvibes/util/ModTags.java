package net.Pandarix.verdantvibes.util;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> VERDANT_PLANTS = tag("verdantvibes_plants");

        private  static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(VerdantVibes.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> VERDANT_PLANTS = tag("verdantvibes_plants");

        private  static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(VerdantVibes.MOD_ID, name));
        }
    }
}
