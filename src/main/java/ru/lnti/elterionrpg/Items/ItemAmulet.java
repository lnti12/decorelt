package ru.lnti.elterionrpg.Items;

import java.util.List;
import java.util.UUID;

import ru.lnti.elterionrpg.slot.EnumBaubleType;
import ru.lnti.elterionrpg.utils.RpgInventoryUtils;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAmulet extends ItemBauble{

	
	
	
	public static final UUID HEALTH_BOOST_ID = UUID.fromString("DC96121E-AEb5-11E7-ABC4-CEC278B6B50A");
	public static final AttributeModifier HEALTH_BOOST_ATTRIBUTE = new AttributeModifier(HEALTH_BOOST_ID, "Amulet health boost", 2, 0).setSaved(true);
	private EnumBaubleType type;

	public ItemAmulet(String itemName){
		super(itemName, EnumBaubleType.AMULET);
		
	}

	public void onEquipped(Container container, IInventory inventory, ItemStack itemStack, EntityPlayer player){
		IAttributeInstance attribute = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);

		if(attribute.getModifier(HEALTH_BOOST_ID) == null){
			RpgInventoryUtils.setPrivateValue(AttributeModifier.class, HEALTH_BOOST_ATTRIBUTE, getHealthBoost(itemStack), "amount", "field_111174_a");
			attribute.applyModifier(HEALTH_BOOST_ATTRIBUTE);
		}
	}

	public void onUnequipped(Container container, IInventory inventory, ItemStack itemStack, EntityPlayer player){
		IAttributeInstance attribute = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);

		if(attribute.getModifier(HEALTH_BOOST_ID) != null){
			attribute.removeModifier(HEALTH_BOOST_ATTRIBUTE);
		}
	}


	private float getHealthBoost(ItemStack itemStack){
		switch(itemStack.getItemDamage()){
		case 0:
			return 2.0F;
		case 1:
			return 3.0F;
		case 2:
			return 4.0F;
		default:
			return 0.0F;
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advancedTooltips) {
		switch(itemStack.getItemDamage()){
		case 0:
			list.add("Тип:§bобычный");
			list.add("Здоровье:§4+2");
			break;
		case 1:
			list.add("Тип:§1редкий");
			list.add("Здоровье:§4+3");
			break;
		case 2:
			list.add("Тип:§dлегендарный");
			list.add("Здоровье:§4+4");
			break;
		}
	
	}
}
	