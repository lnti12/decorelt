package ru.lnti.elterionrpg.Items;

import ru.lnti.elterionrpg.elterionrpg;
import net.minecraft.item.Item;

public class ElItems extends Item{
	
	public ElItems(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(elterionrpg.TabsELT);
        this.setMaxStackSize(50);

    }
}

