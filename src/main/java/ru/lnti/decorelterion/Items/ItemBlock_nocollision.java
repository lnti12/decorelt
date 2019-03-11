package ru.lnti.decorelterion.Items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lnti.decorelterion.Blocks.Block_nocollision.EnumType;

public class ItemBlock_nocollision extends ItemMultiTexture{

    public ItemBlock_nocollision(Block block) {
        super(block, block, new String[] 
        		{
        		"wooden_bucket",
        		"pitchfork",
        		"scale",
        		"wooden_tankard",
        		"cheese_cut",
        		"hand_unlitcandle",
        		"extremehills"
        		} );
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
