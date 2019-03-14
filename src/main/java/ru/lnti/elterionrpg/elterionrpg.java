package ru.lnti.elterionrpg;


import ru.lnti.elterionrpg.proxy.CommonProxy;
import ru.lnti.elterionrpg.rpginventory.network.NetworkHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = elterionrpg.MOD_ID, version = elterionrpg.VERSION, name = elterionrpg.NAME)

public class elterionrpg {

	@Instance(elterionrpg.MOD_ID)
	public static elterionrpg instance;
	
	public static final String MOD_ID = "elterionrpg";
	public static final String VERSION = "0.3";
	public static final String NAME = "Elterion RPG";

	
	@SidedProxy(clientSide = "ru.lnti.elterionrpg.proxy.ClientProxy", serverSide = "ru.lnti.elterionrpg.proxy.CommonProxy")
    public static CommonProxy proxy;

	public static final Logger logger = LogManager.getLogger(NAME);
	
	public static final CreativeTabs TabsELT = new CreativeTabs("ElterionItemTab")
	{
	    @Override
	    public ItemStack getTabIconItem()
	    {
	        return new ItemStack(Items.ARROW);
	    }
	};

	
	 @EventHandler
	public void preInit(FMLPreInitializationEvent event)
    {
		 NetworkHandler.init();
		 proxy.preInit(event);

		 
    }
	 @EventHandler
    public void init(FMLInitializationEvent event)
    {
		 proxy.init(event);
		 
    }
	 @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

		 proxy.postInit(event);
    }

	
}
