package net.dctime.eecraft.block;

import net.dctime.eecraft.EEcraft;
import net.dctime.eecraft.block.custom.ModSpeedyBlock;
import net.dctime.eecraft.item.ModCreativeModeTab;
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

    // the object which stores object which has been registered.
    // don't need new because it forces you to use of() method
    // of() method returns a new object.
    // and then you can use builder pattern to keep building up your BlockBehaviour.Properties object
    // Block class contains block action such as piston not properties
    public static final RegistryObject<Block> CITRINE_BLOCK = BLOCKS.register("citrine_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()));

    // The item form of the block should be registered too.
    // remember that it's an BlockItem, not an Item
    // so the supplier should change too
    public static final RegistryObject<Item> CITRINE_BLOCK_ITEM =
            ModItems.ITEMS.register("citrine_block", () -> new BlockItem(CITRINE_BLOCK.get(),
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // Raw Citrine Block Item & Block
    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = BLOCKS.register("raw_citrine_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> RAW_CITRINE_BLOCK_ITEM = ModItems.ITEMS.register("raw_citrine_block", () -> new
            BlockItem(RAW_CITRINE_BLOCK.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // Citrine Ore
    public static final RegistryObject<Block> CITRINE_ORE = BLOCKS.register("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> CITRINE_ORE_ITEM = ModItems.ITEMS.register("citrine_ore",
            () -> new BlockItem(CITRINE_ORE.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // deepslate citrine ore
    public static final RegistryObject<Block> DEEPSLATE_CITRINE_ORE = BLOCKS.register("deepslate_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> DEEPSLATE_CITRINE_ORE_ITEM = ModItems.ITEMS.register("deepslate_citrine_ore",
            () -> new BlockItem(DEEPSLATE_CITRINE_ORE.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // netherrack citrine ore
    public static final RegistryObject<Block> NETHERRACK_CITRINE_ORE = BLOCKS.register("netherrack_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> NETHERRACK_CITRINE_ORE_ITEM = ModItems.ITEMS.register("netherrack_citrine_ore",
            () -> new BlockItem(NETHERRACK_CITRINE_ORE.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // endstone citrine ore
    public static final RegistryObject<Block> ENDSTONE_CITRINE_ORE = BLOCKS.register("endstone_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Item> ENDSTONE_CITRINE_ORE_ITEM = ModItems.ITEMS.register("endstone_citrine_ore",
            () -> new BlockItem(ENDSTONE_CITRINE_ORE.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Block> SPEEDY_BLOCK = BLOCKS.register("speedy_block",
            () -> new ModSpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f)));

    public static final RegistryObject<Item> SPEEDY_BLOCK_ITEM = ModItems.ITEMS.register("speedy_block",
            () -> new BlockItem(SPEEDY_BLOCK.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));



    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
