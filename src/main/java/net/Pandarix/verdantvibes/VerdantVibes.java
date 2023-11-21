package net.Pandarix.verdantvibes;

import com.mojang.logging.LogUtils;
import net.Pandarix.verdantvibes.init.*;
import net.Pandarix.verdantvibes.particles.BurnweedParticles;
import net.Pandarix.verdantvibes.particles.ParticleInit;
import net.Pandarix.verdantvibes.woldgen.VillageBuildings;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VerdantVibes.MOD_ID)
public class VerdantVibes
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "verdantvibes";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "verdantvibes" namespace

    public VerdantVibes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BlockInit.BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ItemInit.ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        ItemGroupInit.CREATIVE_MODE_TABS.register(modEventBus);

        TreeDecoratorInit.DECORATORS.register(modEventBus);
        ParticleInit.PARTICLE_TYPES.register(modEventBus);

        VillagerInit.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(()-> {
            addPlants();
        });
    }

    private static void addPlants(){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.MONSTERA.get()), BlockInit.POTTED_MONSTERA);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.SNAKE_PLANT.get()), BlockInit.POTTED_SNAKE_PLANT);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.PARLOUR_PALM.get()), BlockInit.POTTED_PARLOUR_PALM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.MONEY_TREE.get()), BlockInit.POTTED_MONEY_TREE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.LOBELIA.get()), BlockInit.POTTED_LOBELIA);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.DRAGON_TREE.get()), BlockInit.POTTED_DRAGON_TREE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.IVY.get()), BlockInit.POTTED_IVY);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(BlockInit.BURNWEED.get()), BlockInit.POTTED_BURNWEED);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
