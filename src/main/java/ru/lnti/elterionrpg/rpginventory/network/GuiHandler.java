package ru.lnti.elterionrpg.rpginventory.network;

import ru.lnti.elterionrpg.gui.GUIRpgCustomInv;
import ru.lnti.elterionrpg.rpginventory.Capability.CAPRpgCustomInventoryProvider;
import ru.lnti.elterionrpg.rpginventory.Capability.ICAPRpgCustomInventory;
import ru.lnti.elterionrpg.rpginventory.container.RpgContainerCustomInv;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int INVENTORY_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ICAPRpgCustomInventory inv = player.getCapability(CAPRpgCustomInventoryProvider.INVENTORY_CAP, null);
        if(ID == INVENTORY_GUI_ID) {
            return new RpgContainerCustomInv(player.inventory, inv.getInventory(), player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        ICAPRpgCustomInventory inv = player.getCapability(CAPRpgCustomInventoryProvider.INVENTORY_CAP, null);
        if(ID == INVENTORY_GUI_ID) {
            return new GUIRpgCustomInv(player, player.inventory, inv.getInventory());
        }
        return null;
    }

}
