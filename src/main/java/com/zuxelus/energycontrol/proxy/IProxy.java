package com.zuxelus.energycontrol.proxy;

import java.io.File;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.zuxelus.energycontrol.blocks.BlockDamages;
import com.zuxelus.energycontrol.containers.ContainerAFSU;
import com.zuxelus.energycontrol.containers.ContainerAdvancedInfoPanel;
import com.zuxelus.energycontrol.containers.ContainerAverageCounter;
import com.zuxelus.energycontrol.containers.ContainerCardHolder;
import com.zuxelus.energycontrol.containers.ContainerEnergyCounter;
import com.zuxelus.energycontrol.containers.ContainerHoloPanel;
import com.zuxelus.energycontrol.containers.ContainerInfoPanel;
import com.zuxelus.energycontrol.containers.ContainerKitAssembler;
import com.zuxelus.energycontrol.containers.ContainerPortablePanel;
import com.zuxelus.energycontrol.containers.ContainerRangeTrigger;
import com.zuxelus.energycontrol.containers.ContainerRemoteThermalMonitor;
import com.zuxelus.energycontrol.containers.ContainerSeedAnalyzer;
import com.zuxelus.energycontrol.containers.ContainerSeedLibrary;
import com.zuxelus.energycontrol.containers.ContainerTimer;
import com.zuxelus.energycontrol.items.cards.ItemCardHolder;
import com.zuxelus.energycontrol.tileentities.TileEntityAFSU;
import com.zuxelus.energycontrol.tileentities.TileEntityAdvancedInfoPanel;
import com.zuxelus.energycontrol.tileentities.TileEntityAverageCounter;
import com.zuxelus.energycontrol.tileentities.TileEntityEnergyCounter;
import com.zuxelus.energycontrol.tileentities.TileEntityHoloPanel;
import com.zuxelus.energycontrol.tileentities.TileEntityInfoPanel;
import com.zuxelus.energycontrol.tileentities.TileEntityKitAssembler;
import com.zuxelus.energycontrol.tileentities.TileEntityRangeTrigger;
import com.zuxelus.energycontrol.tileentities.TileEntityRemoteThermalMonitor;
import com.zuxelus.energycontrol.tileentities.TileEntitySeedAnalyzer;
import com.zuxelus.energycontrol.tileentities.TileEntitySeedLibrary;
import com.zuxelus.energycontrol.tileentities.TileEntityTimer;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;

public interface IProxy extends IGuiHandler {

    void loadConfig(FMLPreInitializationEvent event);

    void registerSpecialRenderers();

    void registerEventHandlers();

    void importSound(File configFolder);

    String getItemName(ItemStack stack);

    @Override
    public default Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case BlockDamages.GUI_PORTABLE_PANEL:
                return new ContainerPortablePanel(player);
            case BlockDamages.GUI_CARD_HOLDER:
                if (player.getCurrentEquippedItem()
                    .getItem() instanceof ItemCardHolder) return new ContainerCardHolder(player);
        }
        TileEntity te = world.getTileEntity(x, y, z);
        switch (ID) {
            case BlockDamages.DAMAGE_INFO_PANEL:
                return new ContainerInfoPanel(player, (TileEntityInfoPanel) te);
            case BlockDamages.DAMAGE_ADVANCED_PANEL:
                return new ContainerAdvancedInfoPanel(player, (TileEntityAdvancedInfoPanel) te);
            case BlockDamages.DAMAGE_HOLO_PANEL:
                return new ContainerHoloPanel(player, (TileEntityHoloPanel) te);
            case BlockDamages.DAMAGE_RANGE_TRIGGER:
                return new ContainerRangeTrigger(player, (TileEntityRangeTrigger) te);
            case BlockDamages.DAMAGE_REMOTE_THERMO:
                return new ContainerRemoteThermalMonitor(player, (TileEntityRemoteThermalMonitor) te);
            case BlockDamages.DAMAGE_AVERAGE_COUNTER:
                return new ContainerAverageCounter(player, (TileEntityAverageCounter) te);
            case BlockDamages.DAMAGE_ENERGY_COUNTER:
                return new ContainerEnergyCounter(player, (TileEntityEnergyCounter) te);
            case BlockDamages.GUI_KIT_ASSEMBER:
                return new ContainerKitAssembler(player, (TileEntityKitAssembler) te);
            case BlockDamages.DAMAGE_AFSU:
                return new ContainerAFSU(player, (TileEntityAFSU) te);
            case BlockDamages.DAMAGE_SEED_ANALYZER:
                if (te instanceof TileEntitySeedAnalyzer)
                    return new ContainerSeedAnalyzer(player, (TileEntitySeedAnalyzer) te);
                break;
            case BlockDamages.DAMAGE_SEED_LIBRARY:
                if (te instanceof TileEntitySeedLibrary)
                    return new ContainerSeedLibrary(player, (TileEntitySeedLibrary) te);
                break;
            case BlockDamages.DAMAGE_TIMER:
                if (te instanceof TileEntityTimer) return new ContainerTimer(player, (TileEntityTimer) te);
                break;
        }
        return null;
    }
}
