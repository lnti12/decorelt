package ru.lnti.elterionrpg.rpginventory.Capability;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class CapabilityEventHandler {

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new CapabilityEventHandler());
    }

    public static final ResourceLocation INVENTORY_CAP = new ResourceLocation("elterionrpg", "inventory");

    //ОЧЕНЬ ВАЖНО! Добавляет капу игроку при его первом создании
    @SubscribeEvent
 public void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        
        if (event.getObject() instanceof EntityPlayer)
            event.addCapability(INVENTORY_CAP, new CAPRpgCustomInventoryProvider());
        }
    

    //Копирование инвентаря, если по каким-то причинам произошло клонирование игрока. Иначе вещи пропадут
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        ICAPRpgCustomInventory newCap = player.getCapability(CAPRpgCustomInventoryProvider.INVENTORY_CAP, null);
        ICAPRpgCustomInventory oldCap = event.getOriginal().getCapability(CAPRpgCustomInventoryProvider.INVENTORY_CAP, null);
        newCap.copyInventory(oldCap);
    }

    //Если игрок умрет то ничего не выпадет. Нужно выбросит вещи вручную. Выбрасываем
    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if(event.getEntity() instanceof EntityPlayer) {
            //Достаем КАПу, затем инвентарь
            EntityPlayer player = (EntityPlayer)event.getEntity();
            ICAPRpgCustomInventory cap = player.getCapability(CAPRpgCustomInventoryProvider.INVENTORY_CAP, null);
            RpgCustomInventory inv = cap.getInventory();
            //Выбрасываем все вещи из инвентаря
            dropAllItems(player, inv);
            inv.clear();
        }
    }

    private static void dropAllItems(EntityPlayer player, RpgCustomInventory inventory){
        NonNullList<ItemStack> aitemstack = inventory.getStacks();
        for (int i = 0; i < aitemstack.size(); ++i) {
            if (!aitemstack.get(i).isEmpty()) {
                player.dropItem(aitemstack.get(i), true, false);
            }
        }
    }
}