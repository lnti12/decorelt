package ru.lnti.elterionrpg.Items;

import ru.lnti.elterionrpg.elterionrpg;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Coins extends Item{
	
	public Coins(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(elterionrpg.TabsELT);
        this.setMaxStackSize(50);

    }
}
