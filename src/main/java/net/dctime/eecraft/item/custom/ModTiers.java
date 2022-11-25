package net.dctime.eecraft.item.custom;

import net.dctime.eecraft.item.ModItems;
import net.dctime.eecraft.tags.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

// final class cannot be inherent
public class ModTiers
{
    public static final ForgeTier CITRINE = new ForgeTier(2, 150, 1.5f, 3.0f, 20,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.CITRINE.get()));
}