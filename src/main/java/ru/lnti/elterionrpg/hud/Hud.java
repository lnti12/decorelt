package ru.lnti.elterionrpg.hud;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.FoodStats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType.*;

@SideOnly(Side.CLIENT)
public class Hud {

	Minecraft mc = Minecraft.getMinecraft();
		
	@SubscribeEvent
    public void RenderHud(RenderGameOverlayEvent.Post e) {
        int width = e.getResolution().getScaledWidth();
        int height= e.getResolution().getScaledHeight();
	    EntityPlayer mcp = mc.player;
	    if(!mcp.capabilities.isCreativeMode) {
	    GlStateManager.pushMatrix();
	    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    GlStateManager.scale(1, 1, 1);
        mc.getTextureManager().bindTexture(new ResourceLocation("elterionrpg", "textures/gui/hud_hp.png"));
        int hpBarWidth = MathHelper.ceil(((mcp.getHealth() / mcp.getMaxHealth()) * 120));
        mc.ingameGUI.drawTexturedModalRect(width/2-123, height-35, 0, 0, 120, 10);
        mc.ingameGUI.drawTexturedModalRect(width/2-123 , height-34, 0, 11, hpBarWidth, 8);

        mc.getTextureManager().bindTexture(new ResourceLocation("elterionrpg", "textures/gui/hud_food.png"));
        int foodBarWidth = (int)(((float)mc.player.getFoodStats().getFoodLevel() / 20F) * 120F);
        mc.ingameGUI.drawTexturedModalRect(width/2 +3, height-35, 0, 0, 120, 10);
        mc.ingameGUI.drawTexturedModalRect(width/2 +3, height-34, 0, 12, foodBarWidth, 8);
        GlStateManager.popMatrix();
        }
	}
	@SubscribeEvent
    public void RenderText(RenderGameOverlayEvent.Post e) {
	    EntityPlayer mcp = mc.player;
	    if(!mcp.capabilities.isCreativeMode) {
            int width = e.getResolution().getScaledWidth();
            int height= e.getResolution().getScaledHeight();
	    int health = (int) mcp.getHealth();
	    int healthmax = (int) mcp.getMaxHealth();
		int food = mcp.getFoodStats().getFoodLevel();
		int armor = ForgeHooks.getTotalArmorValue(mcp);
		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.translate(2.0F, 2.0F, 0.0F);
        GlStateManager.scale(1F, 1F, 1F);
        GlStateManager.popMatrix(); 
		this.mc.ingameGUI.drawString(this.mc.fontRenderer, + health +"/"+ healthmax, width/2-70, height-35, 16777215);
        this.mc.ingameGUI.drawString(this.mc.fontRenderer, + food + "/20", width/2+50, height-35, 16777215);
        this.mc.ingameGUI.drawString(this.mc.fontRenderer, + armor + " / 28", width/2+95, height-10, 16777215);
	    }
        String[] fps1 = this.mc.debug.split(" ");

        this.mc.ingameGUI.drawString(this.mc.fontRenderer, "ElterionRPG fps: " + Integer.parseInt(fps1[0]), 1, 1, 16777215);
        this.mc.ingameGUI.drawString(this.mc.fontRenderer, "Coords: " + (int)this.mc.player.posX + ", " + (int)this.mc.player.posZ, 1, 11, 16777215);





	}
    @SubscribeEvent
    public void setCanceled(RenderGameOverlayEvent.Pre event) {
        switch(event.getType()) {
            case FOOD:
            case HEALTH:
            case ARMOR:
            case EXPERIENCE:
                event.setCanceled(true);
                break;
		default:
			break;

        }
    }

}