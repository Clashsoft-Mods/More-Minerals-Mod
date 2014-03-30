package clashsoft.mods.moreminerals.client.render.block;

import clashsoft.mods.moreminerals.client.MMMClientProxy;
import clashsoft.mods.moreminerals.tileentity.TileEntityOres;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class RenderBlockOres implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		TileEntityOres te = (TileEntityOres) world.getTileEntity(x, y, z);
		Block bgBlock = te.getBlock();
		
		renderer.renderStandardBlock(bgBlock, x, y, z);
		renderer.renderStandardBlock(block, x, y, z);
		
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int metadata)
	{
		return true;
	}
	
	@Override
	public int getRenderId()
	{
		return MMMClientProxy.oresRenderType;
	}
	
}
