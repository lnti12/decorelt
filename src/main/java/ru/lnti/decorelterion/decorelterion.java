package ru.lnti.decorelterion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.lnti.decorelterion.proxy.CommonProxy;
import ru.lnti.decorelterion.register.BlocksRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;




@Mod(modid = decorelterion.MOD_ID, version = decorelterion.VERSION, name = decorelterion.NAME)

public class decorelterion {
	
	@SidedProxy(clientSide = "ru.lnti.decorelterion.proxy.ClientProxy", serverSide = "ru.lnti.decorelterion.proxy.CommonProxy")
    public static CommonProxy proxy;


	@Instance(decorelterion.MOD_ID)
	public static decorelterion instance;
	
	public static final String MOD_ID = "decorelterion";
	public static final String VERSION = "0.1";
	public static final String NAME = "Decor elterion mod";
	
	public static final Logger logger = LogManager.getLogger(NAME);
	
	public static final CreativeTabs TabsELTB = new CreativeTabs("ElterionBlockTab")
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
