package com.zuxelus.energycontrol.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.zuxelus.energycontrol.init.ModItems;

public class TileEntityHoloPanelExtender extends TileEntityInfoPanelExtender {

    public TileEntityHoloPanelExtender() {
        super();
    }

    // IWrenchable
    @Override
    public ItemStack getWrenchDrop(EntityPlayer player) {
        return new ItemStack(ModItems.blockHoloPanelExtender);
    }
}
