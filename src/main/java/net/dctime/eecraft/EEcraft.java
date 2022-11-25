package net.dctime.eecraft;

import net.dctime.eecraft.block.ModBlocks;
import net.dctime.eecraft.item.ModItems;
import net.dctime.eecraft.painting.ModPaintings;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EEcraft.MOD_ID)
public class EEcraft
{
    // The journey has started
    public static final String MOD_ID = "eecraft";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public EEcraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // add items to the game when started
        ModItems.register(eventBus);
        // add blocks to the game when started
        ModBlocks.register(eventBus);
        // add paintings to minecraft
        ModPaintings.register(eventBus);

        // Register the setup and clientSetup function for mod loading
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ((FlowerPotBlock) (Blocks.FLOWER_POT)).addPlant(ModBlocks.PINK_ROSE_ITEM.getId(), ModBlocks.POTTED_PINK_ROSE);
        });

        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void clientSetup(final FMLCommonSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());

    }
}
