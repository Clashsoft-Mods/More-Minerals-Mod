package clashsoft.mods.moreminerals;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class MoreMineralsOreRenderer implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		renderer.useInventoryTint = false;
		
		int i = block.blockID;
		Block bgBlock = Block.stone;
		if (i == MoreMineralsMod.stoneOres_ID || i == MoreMineralsMod.stoneOres_ID2) { bgBlock = Block.stone; }
		else if (i == MoreMineralsMod.netherOres_ID || i == MoreMineralsMod.netherOres_ID2) { bgBlock = Block.netherrack; }
		else if (i == MoreMineralsMod.endOres_ID || i == MoreMineralsMod.endOres_ID2) { bgBlock = Block.whiteStone; }
		else if (i == MoreMineralsMod.dirtOres_ID || i == MoreMineralsMod.dirtOres_ID2) { bgBlock = Block.dirt; }
		else if (i == MoreMineralsMod.sandOres_ID || i == MoreMineralsMod.sandOres_ID2) { bgBlock = Block.sand; }
		else if (i == MoreMineralsMod.vanillaOres_ID)
		{
			if (metadata < 7) { bgBlock = Block.netherrack; }
			else if (metadata < 14) { bgBlock = Block.whiteStone; }
		}
		else if (i == MoreMineralsMod.vanillaOres_ID2)
		{
			if (metadata < 7) { bgBlock = Block.dirt; }
			else if (metadata < 14) { bgBlock = Block.sand; }
		}
		
		renderer.renderBlockAsItem(bgBlock, metadata, modelID);
		
		Tessellator tessellator = Tessellator.instance;
		int j = block.getRenderType();
		int k;
		float f1;
		float f2;
		float f3;

		if (j == 16)
		{
			metadata = 1;
		}

		block.setBlockBoundsForItemRender();
		renderer.setRenderBoundsFromBlock(block);
		GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, -0.0001D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
		tessellator.draw();

		if (renderer.useInventoryTint)
		{
			k = block.getRenderColor(metadata);
			f2 = (float)(k >> 16 & 255) / 255.0F;
			f3 = (float)(k >> 8 & 255) / 255.0F;
			float f7 = (float)(k & 255) / 255.0F;
			GL11.glColor4f(f2 * modelID, f3 * modelID, f7 * modelID, 1.0F);
		}

		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0001D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
		tessellator.draw();

		if (renderer.useInventoryTint)
		{
			GL11.glColor4f(modelID, modelID, modelID, 1.0F);
		}

		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, -0.0001D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0001D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, -0.0001D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0001D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int i = block.blockID;
		int metadata = world.getBlockMetadata(x, y, z);
		Block bgBlock = Block.stone;
		if (i == MoreMineralsMod.stoneOres_ID || i == MoreMineralsMod.stoneOres_ID2) { bgBlock = Block.stone; }
		else if (i == MoreMineralsMod.netherOres_ID || i == MoreMineralsMod.netherOres_ID2) { bgBlock = Block.netherrack; }
		else if (i == MoreMineralsMod.endOres_ID || i == MoreMineralsMod.endOres_ID2) { bgBlock = Block.whiteStone; }
		else if (i == MoreMineralsMod.dirtOres_ID || i == MoreMineralsMod.dirtOres_ID2) { bgBlock = Block.dirt; }
		else if (i == MoreMineralsMod.sandOres_ID || i == MoreMineralsMod.sandOres_ID2) { bgBlock = Block.sand; }
		else if (i == MoreMineralsMod.vanillaOres_ID)
		{
			if (metadata < 7) { bgBlock = Block.netherrack; }
			else if (metadata < 14) { bgBlock = Block.whiteStone; }
		}
		else if (i == MoreMineralsMod.vanillaOres_ID2)
		{
			if (metadata < 7) { bgBlock = Block.dirt; }
			else if (metadata < 14) { bgBlock = Block.sand; }
		}

		renderer.renderStandardBlock(bgBlock, x, y, z);
		renderer.renderStandardBlock(block, x, y, z);
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.oreRenderer;
	}

}
