package net.dctime.eecraft.painting;

import net.dctime.eecraft.EEcraft;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings
{
    private static DeferredRegister<Motive> PAINTINGS =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, EEcraft.MOD_ID);

    public static RegistryObject<Motive> MARATHON = PAINTINGS.register("marathon",
            () -> new Motive(16, 16));

    public static RegistryObject<Motive> FAMILY = PAINTINGS.register("family",
            () -> new Motive(16, 32));

    public static void register(IEventBus eventBus)
    {
        PAINTINGS.register(eventBus);
    }
}
