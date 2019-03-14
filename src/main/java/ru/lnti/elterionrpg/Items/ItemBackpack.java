package ru.lnti.elterionrpg.Items;

import java.util.List;

import ru.lnti.elterionrpg.elterionrpg;
import ru.lnti.elterionrpg.rpginventory.container.RpgContainerCustomInv;
import ru.lnti.elterionrpg.slot.EnumBaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBackpack extends Item implements IBauble{

	private String name;
	private EnumBaubleType type;

	public ItemBackpack(String name, EnumBaubleType baubleType){
		super();
		type = baubleType;
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setHasSubtypes(true);
		setCreativeTab(elterionrpg.TabsELT);
		this.setRegistryName(name);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedTooltips) {
			list.add("Тип:§bобычный");
			list.add("Дополнительные слоты:+16");
	
	
}
	

	public EnumBaubleType getType(ItemStack itemStack) {

		return type;
	}
}
