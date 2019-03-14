package ru.lnti.elterionrpg.rpginventory.network;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyHandler {


    public static void register() { 

        MinecraftForge.EVENT_BUS.register(new KeyHandler()); 
    }   


     @SideOnly(Side.CLIENT)
     @SubscribeEvent
     public void onGuiOpenEvent(GuiOpenEvent event)
     {
       EntityPlayer player = FMLClientHandler.instance().getClient().player;
       if (event.getGui() instanceof GuiInventory && !player.capabilities.isCreativeMode){
                     
                 NetworkHandler.network.sendToServer(new OpenInventoryMessage());
                 event.setCanceled(true); 
           } 
     }
     
     
}
     

