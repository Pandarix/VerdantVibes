package net.Pandarix.verdantvibes.init;

import com.google.common.collect.ImmutableSet;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillagerInit {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VerdantVibes.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, VerdantVibes.MOD_ID);

    public static final RegistryObject<PoiType> GARDENING_POI = POI_TYPES.register("gardening_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockInit.GARDENING_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> GARDENER =
            VILLAGER_PROFESSIONS.register("gardener", () -> new VillagerProfession("soundmaster",
                    holder -> holder.get() == GARDENING_POI.get(), holder -> holder.get() == GARDENING_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.FLOWERING_AZALEA_HIT));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
