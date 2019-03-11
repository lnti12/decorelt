package ru.lnti.decorelterion.Items;

import ru.lnti.decorelterion.Blocks.Block_collision;
import ru.lnti.decorelterion.Blocks.Block_collision.EnumType;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBlock_collision extends ItemMultiTexture{

    public ItemBlock_collision(Block block) {
        super(block, block, new String[] 
        		{"campfire",
        		"rb_barrel",
        		"cart_hand",
        		"chair_fancy",
        		"cheese_cut",
        		"chest",
        		"vase_small",
        		"vase_large",
        		"toolhanger_smith",
        		"signpost",
        		"woodentable_poor"} );
        this.setHasSubtypes(true);
    }
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
   
            this.block.getSubBlocks(tab, items);
        }
    }
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + EnumType.byMetadata(stack.getMetadata()).getName();
    }
}