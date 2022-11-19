package net.dctime.eecraft.tags;


import net.dctime.eecraft.EEcraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static class Items
    {
        public static Tags.IOptionalNamedTag<Item> CITRINE =
                tag("gems/citrine");

        // if it's a item tag, it will auto search data/eecraft(depend on the namespace)/tags/items
        private static Tags.IOptionalNamedTag<net.minecraft.world.item.Item> forgeTag(String name)
        {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

        private static Tags.IOptionalNamedTag<net.minecraft.world.item.Item> tag(String name)
        {
            return ItemTags.createOptional(new ResourceLocation(EEcraft.MOD_ID, name));
        }
    }

    public static class Blocks
    {
        // if it's a block tag, it will auto search data/eecraft(depend on the namespace)/tags/blocks
        public static final Tags.IOptionalNamedTag<Block> DOWSING_ROD_TARGET =
                tag("dowsing_rod_target");

        private static Tags.IOptionalNamedTag<net.minecraft.world.level.block.Block> forgeTag(String name)
        {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

        private static Tags.IOptionalNamedTag<net.minecraft.world.level.block.Block> tag(String name)
        {
            return BlockTags.createOptional(new ResourceLocation(EEcraft.MOD_ID, name));
        }
    }


}
