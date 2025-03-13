package com.zuxelus.energycontrol.containers.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.util.IIcon;

import com.zuxelus.zlib.containers.slots.SlotFilter;

public class SlotRange extends SlotFilter {

    public static IIcon slotIcon;

    public SlotRange(IInventory inventory, int slotIndex, int x, int y) {
        super(inventory, slotIndex, x, y);
    }

    @Override
    public IIcon getBackgroundIconIndex() {
        return slotIcon;
    }
}
