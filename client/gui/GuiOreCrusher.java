package clashsoft.mods.moreminerals.client.gui;

import org.lwjgl.opengl.GL11;

import clashsoft.mods.moreminerals.inventory.ContainerOreCrusher;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiOreCrusher extends GuiContainer
{
	public static ResourceLocation	oreCrusherGUI	= new ResourceLocation("moreminerals", "gui/orecrusher.png");
	private TileEntityOreCrusher	oreCrusher;
	
	public GuiOreCrusher(InventoryPlayer player, TileEntityOreCrusher oreCrusher)
	{
		super(new ContainerOreCrusher(player, oreCrusher));
		this.oreCrusher = oreCrusher;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.oreCrusher.hasCustomInventoryName() ? this.oreCrusher.getInventoryName() : StatCollector.translateToLocal("tile.ore_crusher.name");
		this.fontRendererObj.drawString(s, (this.xSize - this.fontRendererObj.getStringWidth(s)) / 2, 6, 4210752);
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(oreCrusherGUI);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if (this.oreCrusher.isBurning())
		{
			i1 = this.oreCrusher.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}
		
		i1 = this.oreCrusher.getProgressScaled(24);
		this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}
