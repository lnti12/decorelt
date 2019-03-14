package ru.lnti.elterionrpg.Items;

import java.util.List;

import ru.lnti.elterionrpg.elterionrpg;
import ru.lnti.elterionrpg.slot.EnumBaubleType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemBauble extends Item implements IBauble{

	private String name;
	private EnumBaubleType type;

	
	public ItemBauble(String itemName, EnumBaubleType baubleType){
		super();
		name = itemName;
		type = baubleType;
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setHasSubtypes(true);
		this.setRegistryName(name);

	}

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == elterionrpg.TabsELT) {
            for (rarityItem type : rarityItem.values()) {
                items.add(new ItemStack(this, 1, type.ordinal()));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + rarityItem.getByMeta(stack.getMetadata()).name();
    }
    
	@Override
	public EnumBaubleType getType(ItemStack itemStack) {

		return type;
	}


}
	