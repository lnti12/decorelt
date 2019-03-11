package ru.lnti.decorelterion.proxy;

import ru.lnti.decorelterion.register.BlocksRegister;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	 @Override
	    public void preInit(FMLPreInitializationEvent event)
	    {

	        super.preInit(event);
	    }

	    @Override
	    public void init(FMLInitializationEvent event)
	    {
	        super.init(event);
	        BlocksRegister.registerRender();
	    }
	    
	    @Override
	    public void postInit(FMLPostInitializationEvent event)
	    {
	        super.postInit(event);
	    }
	
}
