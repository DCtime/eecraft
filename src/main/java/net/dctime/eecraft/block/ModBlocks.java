package net.dctime.eecraft.block;

import net.dctime.eecraft.EEcraft;
import net.dctime.eecraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    // Make a register for blocks called BLOCKS
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EEcraft.MOD_ID);

    // the object which stores object which has been registered
    // dont need new because it forces you to use of() method
    // of() method returns a new object
    // and then you can use builder pattern to keep building up your BlockBehaviour.Properties object
    // Block class contains block action such as piston not properties
    public static final RegistryObject<Block> CITRINE_BLOCK = BLOCKS.register("citrine_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()));

    // The item form of the block should be registered too.
    // remember that it's an BlockItem, not an Item
    // so the supplier should change too
    public static final RegistryObject<Item> CITRINE_BLOCK_ITEM =
            ModItems.ITEMS.register("citrine_block", () -> new BlockItem(CITRINE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = BLOCKS.register("raw_citrine_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> RAW_CITRINE_BLOCK_ITEM = ModItems.ITEMS.register("raw_citrine_block", () -> new
            BlockItem(RAW_CITRINE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
