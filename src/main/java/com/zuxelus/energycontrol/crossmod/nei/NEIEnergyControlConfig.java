package com.zuxelus.energycontrol.crossmod.nei;

import com.myname.mymodid.Tags;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.guihook.GuiContainerManager;

public class NEIEnergyControlConfig implements IConfigureNEI {

    @Override
    public String getName() {
        return "Energy Control";
    }

    @Override
    public String getVersion() {
        return Tags.VERSION;
    }

    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new KitAssemblerRecipeHandler());
        API.registerUsageHandler(new KitAssemblerRecipeHandler());
        // API.registerGuiOverlay(GuiKitAssembler.class, EnergyControl.MODID + ".kit_assembler");
        // API.registerGuiOverlayHandler(GuiKitAssembler.class, new DefaultOverlayHandler(), EnergyControl.MODID +
        // ".kit_assembler");
        GuiContainerManager.addTooltipHandler(new TooltipHandler()); // 1.7.10
    }

}
