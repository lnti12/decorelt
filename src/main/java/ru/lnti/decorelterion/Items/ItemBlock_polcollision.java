package ru.lnti.decorelterion.Items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import ru.lnti.decorelterion.Blocks.Block_polcollision.EnumType;

public class ItemBlock_polcollision extends ItemMultiTexture{

    public ItemBlock_polcollision(Block block) {
        super(block, block, new String[] 
        		{
        		"wooden_stool",
        		"rocks_schist",
        		"empty_crate"} );
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
