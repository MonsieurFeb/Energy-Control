package com.zuxelus.energycontrol.containers.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.IIcon;

import com.zuxelus.zlib.containers.slots.SlotFilter;

public class SlotTouch extends SlotFilter {

    public static IIcon slotIcon;

    public SlotTouch(IInventory inventory, int slotIndex, int x, int y) {
        super(inventory, slotIndex, x, y);
    }

    @Override
    public IIcon getBackgroundIconIndex() {
        return slotIcon;
    }
}
