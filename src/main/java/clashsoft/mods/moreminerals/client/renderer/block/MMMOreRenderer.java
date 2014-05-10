package clashsoft.mods.moreminerals.client.renderer.block;

import clashsoft.mods.moreminerals.block.IBlockOre;
import clashsoft.mods.moreminerals.client.MMMClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class MMMOreRenderer implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{	
		Block bgBlock = ((IBlockOre) block).getBlock(metadata);
		
		renderer.renderBlockAsItem(bgBlock, metadata, 0F);
		renderer.renderBlockAsItem(block, metadata, 0F);
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		Block bgBlock = ((IBlockOre) block).getBlock(metadata);
		
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
		return MMMClientProxy.oreRenderer;
	}
}
