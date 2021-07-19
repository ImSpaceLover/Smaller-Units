package com.tfc.smallerunits.utils;

import com.tfc.smallerunits.api.placement.UnitPos;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;

public class SmallUnit {
	public UnitPos pos;
	public BlockState state;
	public TileEntity tileEntity;
	public TileEntity oldTE;
	
	public SmallUnit(UnitPos pos, BlockState state) {
		this.pos = pos;
		this.state = state;
	}
	
	public SmallUnit(UnitPos pos, BlockState state, TileEntity tileEntity) {
		this.pos = pos;
		this.state = state;
		this.tileEntity = tileEntity;
	}
}
