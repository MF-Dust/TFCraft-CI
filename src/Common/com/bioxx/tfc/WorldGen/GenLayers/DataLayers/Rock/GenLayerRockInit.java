package com.bioxx.tfc.WorldGen.GenLayers.DataLayers.Rock;

import net.minecraft.world.gen.layer.IntCache;

import com.bioxx.tfc.WorldGen.DataLayer;
import com.bioxx.tfc.WorldGen.GenLayers.GenLayerTFC;

public class GenLayerRockInit extends GenLayerTFC
{
	DataLayer[] layerRocks;
	public GenLayerRockInit(long par1, DataLayer[] rocks)
	{
		super(par1);
		layerRocks = rocks;
	}

	@Override
	public int[] getInts(int par1, int par2, int maxX, int maxZ)
	{
		int[] cache = IntCache.getIntCache(maxX * maxZ);

		for (int z = 0; z < maxZ; ++z)
		{
			for (int x = 0; x < maxX; ++x)
			{
				this.initChunkSeed(par1 + x, par2 + z);
				cache[x + z * maxX] = layerRocks[this.nextInt(layerRocks.length)].ID;
			}
		}

		return cache;
	}
}
