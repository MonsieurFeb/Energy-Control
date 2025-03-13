package com.zuxelus.energycontrol.crossmod.nei;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import com.zuxelus.energycontrol.api.PanelString;
import com.zuxelus.energycontrol.gui.GuiKitAssembler;
import com.zuxelus.energycontrol.items.cards.ItemCardMain;
import com.zuxelus.energycontrol.items.cards.ItemCardReader;

import codechicken.nei.guihook.IContainerTooltipHandler;

public class TooltipHandler implements IContainerTooltipHandler { // 1.7.10

    @Override
    public List<String> handleTooltip(GuiContainer gui, int mouseX, int mouseY, List<String> list) {
        return list;
    }

    @Override
    public List<String> handleItemDisplayName(GuiContainer gui, ItemStack stack, List<String> list) {
        return list;
    }

    @Override
    public List<String> handleItemTooltip(GuiContainer gui, ItemStack stack, int mouseX, int mouseY,
        List<String> list) {
        if (ItemCardMain.isCard(stack) && gui instanceof GuiKitAssembler
            && ((GuiKitAssembler) gui).isInfoSlot(mouseX, mouseY)) {
            List<PanelString> data = new ItemCardReader(stack).getAllData();
            if (data != null) for (PanelString panelString : data)
                if (panelString.textLeft != null) list.add(EnumChatFormatting.GRAY + panelString.textLeft);
        }
        return list;
    }
}
