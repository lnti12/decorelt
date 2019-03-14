package ru.lnti.elterionrpg.Items;

import ru.lnti.elterionrpg.slot.EnumBaubleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface IBauble {

	public default void onEquipped(Container container, IInventory inventory, ItemStack itemStack, EntityPlayer player){}

	public default void onUnequipped(Container container, IInventory inventory, ItemStack itemStack, EntityPlayer player){}

	public default void onTick(EntityPlayer player, ItemStack itemStack, int slot){}

	public EnumBaubleType getType(ItemStack itemStack);
}