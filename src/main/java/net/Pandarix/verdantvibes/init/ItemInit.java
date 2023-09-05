package net.Pandarix.verdantvibes.init;

import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    // Create a Deferred Register to hold Items which will all be registered under the "VerdantVibes" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VerdantVibes.MOD_ID);

    // -----------ITEMS--------------------------------------------------------------------------//
    // -----------Category
    //public static final RegistryObject<Item> ARTIFACT_SHARDS = ITEMS.register("artifact_shards", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
}