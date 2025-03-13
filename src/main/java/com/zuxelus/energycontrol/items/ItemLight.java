package com.zuxelus.energycontrol.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.zuxelus.energycontrol.EnergyControl;

public class ItemLight extends ItemBlock {

    public ItemLight(Block block) {
        super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
        setCreativeTab(EnergyControl.creativeTab);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack item) {
        return "tile.eclight" + item.getItemDamage();
    }
}
