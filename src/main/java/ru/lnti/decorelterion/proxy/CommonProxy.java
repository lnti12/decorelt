package ru.lnti.decorelterion.proxy;

import ru.lnti.decorelterion.register.BlocksRegister;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event)
    {
		BlocksRegister.register();
    }

    public void init(FMLInitializationEvent event)
    {
    	
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

	
}
