package net.dctime.eecraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ModDowsingRodItem extends Item {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        LOGGER.info("[ModDowsingRodItem class] useOn called");
        Player user = pContext.getPlayer();
        ItemStack used_item_stack = pContext.getItemInHand();
        BlockPos effect_block_position = pContext.getClickedPos();
        Level effect_level = pContext.getLevel();


        LOGGER.info("GetDamageValue: " + used_item_stack.getDamageValue());

        boolean foundValuable = false;

        for (int checkingY = effect_block_position.getY(); checkingY >= -64; checkingY--) {
            Block checking_block = effect_level.getBlockState(new BlockPos(
                    effect_block_position.getX(),
                    checkingY,
                    effect_block_position.getZ()
            )).getBlock();

            if (isValuableBlock(checking_block)) {
                foundValuable = true;
                LOGGER.info("[ModDowsingRodItem class] useOn: " + checking_block.getRegistryName());
                user.displayClientMessage(new TranslatableComponent(
                        "Ores at Y:" + checkingY + " / " + checking_block.getRegistryName().toString()), false);

            }
        }

        if (!foundValuable) {
            user.displayClientMessage(new TranslatableComponent("Ores not found :("), false);
        }

        used_item_stack.hurtAndBreak(1, user, (player) -> {
            player.broadcastBreakEvent(pContext.getHand());});
        return super.useOn(pContext);
    }


    // check its the block is worth notice
    private boolean isValuableBlock(Block target_block) {
        List<Block> valuableBlockList = new ArrayList<>();
        valuableBlockList.add(Blocks.COAL_ORE);
        valuableBlockList.add(Blocks.COPPER_ORE);
        valuableBlockList.add(Blocks.GOLD_ORE);
        valuableBlockList.add(Blocks.IRON_ORE);
        valuableBlockList.add(Blocks.LAPIS_ORE);
        valuableBlockList.add(Blocks.DIAMOND_ORE);
        valuableBlockList.add(Blocks.EMERALD_ORE);

        boolean foundIt = false;

        for (Block block : valuableBlockList) {
            if (block == target_block) {
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
