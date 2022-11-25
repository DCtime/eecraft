package net.dctime.eecraft.item.custom;

import net.dctime.eecraft.tags.ModTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;

public class ModCitrineArmorItem extends ArmorItem
{
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected)
    {
        int citrine_armor_pieces_counter = 0;

        if (!pLevel.isClientSide())
        {
            if (pEntity instanceof LivingEntity && !((LivingEntity) pEntity).hasEffect(MobEffects.FIRE_RESISTANCE))
            {
                LOGGER.debug("Citrine Armor in inventory");
                for (ItemStack itemStack : pEntity.getArmorSlots())
                {
                    LOGGER.debug("Detecting Item: " + itemStack.getItem().toString());
                    if (ModTags.Items.CITRINE_ARMOR_PIECES.contains(itemStack.getItem()))
                    {
                        LOGGER.debug("Detected a piece of armor which is made of citrine");
                        citrine_armor_pieces_counter++;
                        LOGGER.debug("Now Counter = " + citrine_armor_pieces_counter);
                    }
                }

                LOGGER.debug("Detection finished");

                if (citrine_armor_pieces_counter == 4)
                {
                    LOGGER.info("Detected full citrine armor");

                    LivingEntity pLivingEntity = (LivingEntity) pEntity;
                    pLivingEntity.addEffect(new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE, 24 * 5, 0, false, false, false));

                }
            }


        }
    }

    public ModCitrineArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties)
    {
        super(pMaterial, pSlot, pProperties);
    }
}
