package net.dctime.eecraft.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class ModCoalCokeItem extends Item
{
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 2400;
    }

    public ModCoalCokeItem(Properties pProperties) {
        super(pProperties);
    }
}
