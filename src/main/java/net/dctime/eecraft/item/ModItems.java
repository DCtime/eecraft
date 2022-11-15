package net.dctime.eecraft.item;

import net.dctime.eecraft.EEcraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IRegistryDelegate;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    // A list of your items creating for my mod
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EEcraft.MOD_ID);

    /* Make a new item */
    // class Properties is in class item
    // The Item class constructor needs the class properties
    // The supplier will become a value in a map, storing the items properties
    // The name must not repeat or it will throw an exception
    // The name will combine with modid, becomes [modid, name] string array
    // ITEM.register returns RegistryObject object
    public static final RegistryObject<Item> CITRINE =
            ITEMS.register("citrine", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // register the DeferredRegister
    // This method must be called in the tutorial mod's class, because the eventBus is at the ModItems Class
    // Because EEcraft class has the event bus
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
