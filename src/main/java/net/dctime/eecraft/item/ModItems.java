package net.dctime.eecraft.item;

import net.dctime.eecraft.EEcraft;
import net.dctime.eecraft.item.custom.ModCoalCokeItem;
import net.dctime.eecraft.item.custom.ModDowsingRodItem;
import net.dctime.eecraft.item.custom.ModVerticalEnergyEmitterItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

public class ModItems
{
    // A list of your items creating for my mod
    // Make a Register for items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EEcraft.MOD_ID);

    /* Make item here */
    // class Properties is in class Item
    // The Item class constructor needs the class properties
    // The supplier will become a value in a map, storing the items properties
    // The name must not repeat or it will throw an exception
    // The name will combine with modid, becomes [modid, name] string array
    // ITEM.register returns RegistryObject object
    // After this is done, the item is added to the game

    // citrine is added to the register ITEMS
    public static final RegistryObject<Item> CITRINE =
            ITEMS.register("citrine", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // raw_citrine is added to the register ITEM
    public static final RegistryObject<Item> RAW_CITRINE =
            ITEMS.register("raw_citrine", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // this is a dust form of tnt
    public static final RegistryObject<Item> TRINITROTOLUENE =
            ITEMS.register("trinitrotoluene", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EECRAFT_TAB)));

    // I made an item to go BOOM!!
    public static final RegistryObject<Item> VERTICAL_ENERGY_EMITTER =
            ITEMS.register("vertical_energy_emitter", () -> new ModVerticalEnergyEmitterItem(new Item.Properties().tab(ModCreativeModeTab.EECRAFT_TAB)));

    // A item which detects ores
    public static final RegistryObject<Item> DOWSING_ROD =
            ITEMS.register("dowsing_rod", () -> new ModDowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).defaultDurability(15)));

    public static final RegistryObject<Item> CUCUMBER =
            ITEMS.register("cucumber", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            () -> new ModCoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // register the DeferredRegister
    // This method must be called in the tutorial mod's class, because the eventBus is at the ModItems Class
    // EEcraft class has the event bus
    // This must be called or it cannot work

    // The ITEMS register is listened by the eventBus

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
