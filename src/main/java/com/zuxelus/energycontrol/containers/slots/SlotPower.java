package com.zuxelus.energycontrol.containers.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.IIcon;

import com.zuxelus.zlib.containers.slots.SlotFilter;

public class SlotPower extends SlotFilter {

    public static IIcon slotIcon;

    public SlotPower(IInventory inventory, int slotIndex, int x, int y) {
        super(inventory, slotIndex, x, y);
    }

    @Override
    public int getSlotStackLimit() {
        return 16;
    }

    @Override
    public IIcon getBackgroundIconIndex() {
        return slotIcon;
    }
}
