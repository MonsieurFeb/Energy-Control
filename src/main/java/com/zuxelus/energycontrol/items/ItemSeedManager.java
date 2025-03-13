package com.zuxelus.energycontrol.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zuxelus.energycontrol.EnergyControl;

public class ItemSeedManager extends ItemBlock { // 1.7.10

    public ItemSeedManager(Block block) {
        super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
        setCreativeTab(EnergyControl.creativeTab);
    }

    @Override
    public int getMetadata(int metadata) {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        switch (stack.getItemDamage()) {
            case 0:
                return "tile.seed_analyzer";
            case 1:
                return "tile.seed_library";
            default:
                return super.getUnlocalizedName(stack);
        }
    }
}
