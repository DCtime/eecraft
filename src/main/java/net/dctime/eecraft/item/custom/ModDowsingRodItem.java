package net.dctime.eecraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;

public class ModDowsingRodItem extends Item
{
    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        Player user = pContext.getPlayer();

        BlockPos effect_block_position = pContext.getClickedPos();
        Level effect_level = pContext.getLevel();

        Block checking_block = effect_level.getBlockState(new BlockPos(
                effect_block_position.getX(),
                effect_block_position.getY(),
                effect_block_position.getZ()
        )).getBlock();
        System.out.println("Clicked");

        if (isValuableBlock(checking_block))
        {
            user.displayClientMessage(new TranslatableComponent("FUCK YOU YOU FOUND SOMETHING"), true);

        }


        return super.useOn(pContext);
    }

    // check its the block is worth notice
    private boolean isValuableBlock(Block target_block)
    {
        List<Block> valuableBlockList = new ArrayList<>();
        valuableBlockList.add(Blocks.COAL_ORE);
        valuableBlockList.add(Blocks.COPPER_ORE);
        valuableBlockList.add(Blocks.GOLD_ORE);
        valuableBlockList.add(Blocks.IRON_ORE);
        valuableBlockList.add(Blocks.LAPIS_ORE);
        valuableBlockList.add(Blocks.DIAMOND_ORE);
        valuableBlockList.add(Blocks.EMERALD_ORE);

        boolean foundIt = false;

        for (Block block : valuableBlockList)
        {
            if (block == target_block)
            {
                foundIt = true;
                break;
            }
        }

        return foundIt;

    }

    public ModDowsingRodItem(Properties pProperties) {
        super(pProperties);
    }
}
