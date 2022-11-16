package net.dctime.eecraft.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class ModVerticalEnergyEmitterItem extends Item
{

    public ModVerticalEnergyEmitterItem(Properties pProperties) {
        super(pProperties);
    }

    // When Vertical Energy Emitter is clicked on the ground
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos emit_pos = pContext.getClickedPos();
        Level emit_level = pContext.getLevel();

        emit_level.destroyBlock(emit_pos, true);
        return super.useOn(pContext);
    }
}
