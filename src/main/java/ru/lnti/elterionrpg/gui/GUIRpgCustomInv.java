package ru.lnti.elterionrpg.gui;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;
import ru.lnti.elterionrpg.rpginventory.container.RpgContainerCustomInv;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


public class GUIRpgCustomInv extends GuiContainer{

    private float oldMouseX;
    private float oldMouseY;

    private static final ResourceLocation INVENTORY_GUI_TEXTURE = new ResourceLocation("elterionrpg:" + "textures/gui/inventory.png");

    public GUIRpgCustomInv(EntityPlayer player, InventoryPlayer inventoryPlayer, RpgCustomInventory cInventory) {

        super(new RpgContainerCustomInv(inventoryPlayer, cInventory, player));

    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        super.drawScreen(mouseX, mouseY, partialTicks);
        this.oldMouseX = (float)mouseX;
        this.oldMouseY = (float)mouseY;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(INVENTORY_GUI_TEXTURE);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize+30);
        GuiInventory.drawEntityOnScreen(i + 45, j + 75, 30, (float)(i + 51) - this.oldMouseX, (float)(j + 75 - 50) - this.oldMouseY, this.mc.player);           
    }

}