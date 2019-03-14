package ru.lnti.elterionrpg.register;

import ru.lnti.elterionrpg.Items.Coins;
import ru.lnti.elterionrpg.Items.ItemAmulet;
import ru.lnti.elterionrpg.Items.ItemBackpack;
import ru.lnti.elterionrpg.Items.ItemBauble;
import ru.lnti.elterionrpg.slot.EnumBaubleType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegister {
	
	public static Item gold_coin = new Coins("gold_coin");
	public static Item silver_coin = new Coins("silver_coin");
	public static Item copper_coin = new Coins("copper_coin");
	
	public static Item amulet = new ItemAmulet("amulet");
	
	public static Item backpack = new ItemBackpack("backpack", EnumBaubleType.BACKPACK);

    public static void register()
    {
        setRegister(gold_coin);
        setRegister(silver_coin);
        setRegister(copper_coin);
        setRegister(amulet);
        setRegister(backpack);

    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(gold_coin);
        setRender(silver_coin);
        setRender(copper_coin);
        setRender(amulet);
        setRender(backpack);
    }

    private static void setRegister(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }
}
