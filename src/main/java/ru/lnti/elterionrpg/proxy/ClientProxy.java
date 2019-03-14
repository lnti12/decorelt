package ru.lnti.elterionrpg.proxy;


import ru.lnti.elterionrpg.hud.Hud;
import ru.lnti.elterionrpg.register.ItemsRegister;
import ru.lnti.elterionrpg.rpginventory.network.KeyHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	 @Override
	    public void preInit(FMLPreInitializationEvent event)
	    {
			MinecraftForge.EVENT_BUS.register(new Hud());
	        super.preInit(event);
	    }

	    @Override
	    public void init(FMLInitializationEvent event)
	    {
	        super.init(event);
	        KeyHandler.register();
	        ItemsRegister.registerRender();

	    }
	    
	    @Override
	    public void postInit(FMLPostInitializationEvent event)
	    {
	        super.postInit(event);
	    }
	
}
