package ru.lnti.elterionrpg.proxy;


import ru.lnti.elterionrpg.elterionrpg;
import ru.lnti.elterionrpg.register.ItemsRegister;
import ru.lnti.elterionrpg.rpginventory.Capability.CAPRpgCustomInventory;
import ru.lnti.elterionrpg.rpginventory.Capability.CAPRpgCustomInventoryStorage;
import ru.lnti.elterionrpg.rpginventory.Capability.CapabilityEventHandler;
import ru.lnti.elterionrpg.rpginventory.Capability.ICAPRpgCustomInventory;
import ru.lnti.elterionrpg.rpginventory.network.GuiHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	

	public void preInit(FMLPreInitializationEvent event)
    {
        ItemsRegister.register();

    }

    public void init(FMLInitializationEvent event)
    {
    	CapabilityManager.INSTANCE.register(ICAPRpgCustomInventory.class, new CAPRpgCustomInventoryStorage(), CAPRpgCustomInventory.class);
    	CapabilityEventHandler.register();
    	NetworkRegistry.INSTANCE.registerGuiHandler(elterionrpg.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

	
}
