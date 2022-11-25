package net.dctime.eecraft.item.custom;

import net.dctime.eecraft.EEcraft;
import net.dctime.eecraft.tags.ModTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ModLevitationSwordItem extends SwordItem {

    private static final Logger LOGGER = LogManager.getLogger();
    // When hurt emeny, if its creeper, float it and gain absorption and resistance
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (ModTags.EntityType.entity_affect_by_mod_levitation.contains(pTarget.getType()))
        {
            ModLevitationSwordItem.LOGGER.info("levitation activated");
            pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 10, 3));
            pAttacker.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 24 * 5, 5));
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    public ModLevitationSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
}
