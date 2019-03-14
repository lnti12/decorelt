package ru.lnti.elterionrpg.slot;

import javax.annotation.Nullable;

import ru.lnti.elterionrpg.Items.IBauble;
import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaubleSlot extends Slot{

	private final Container parent;
	private final EntityPlayer player;
	private final EnumBaubleType type;

	public BaubleSlot(Container container, EntityPlayer thePlayer, IInventory inventory, int id, int x, int y, EnumBaubleType baubleType){
		super(inventory, id, x, y);
		parent = container;
		player = thePlayer;
		type = baubleType;
	}

	public EnumBaubleType getType(){
		return type;
	}

	public int getSlotStackLimit(){
		return 1;
	}

	public boolean isItemValid(ItemStack itemStack){
		if(itemStack == null || !(itemStack.getItem() instanceof IBauble)){
			return false;
		}
		IBauble item = (IBauble)itemStack.getItem();
		return item.getType(itemStack) == type;
	}

	public void onPickupFromSlot(EntityPlayer player, ItemStack stack){
		if(!getHasStack() && stack.getItem() instanceof IBauble){
			((IBauble)stack.getItem()).onUnequipped(parent, inventory, stack, player);
		}
	
	}

	public void putStack(ItemStack itemStack){
		if(getHasStack() && getStack().getItem() instanceof IBauble && !ItemStack.areItemStacksEqual(itemStack, getStack())){
			((IBauble)getStack().getItem()).onUnequipped(parent, inventory, getStack(), player);
		}

		ItemStack oldStack = getStack() != null ? getStack().copy() : null;
		super.putStack(itemStack);

		if(getHasStack() && getStack().getItem() instanceof IBauble && !ItemStack.areItemStacksEqual(oldStack, getStack())){
			((IBauble)getStack().getItem()).onEquipped(parent, inventory, getStack(), player);
		}
	}
}
