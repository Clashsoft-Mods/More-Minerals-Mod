package clashsoft.mods.moreminerals.client.render.block;

import clashsoft.mods.moreminerals.item.ItemBlockOres;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderItemOres implements IItemRenderer
{
	public static RenderBlocks	renderBlock	= new RenderBlocks();
	
	@Override
	public boolean handleRenderType(ItemStack stack, ItemRenderType renderType)
	{
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType renderType, ItemStack stack, Object... data)
	{
		ItemBlockOres ores = (ItemBlockOres) stack.getItem();
		Block block = ores.getBlock(stack);
		int color = ores.getColorFromItemStack(stack, 0);
		
		renderBlock.renderBlockAsItem(block, 0, 1F);
		if (color != -1)
		{
			Tessellator.instance.setColorOpaque_I(color);
		}
		renderBlock.setOverrideBlockTexture(ores.getIconIndex(stack));
		renderBlock.renderBlockAsItem(ores.field_150939_a, 0, 1F);
		renderBlock.clearOverrideBlockTexture();
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType renderType, ItemStack stack, ItemRendererHelper helper)
	{
		return true;
	}
}
