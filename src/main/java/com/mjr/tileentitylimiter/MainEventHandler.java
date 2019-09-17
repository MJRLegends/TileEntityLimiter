package com.mjr.tileentitylimiter;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MainEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onBlockPlacement(EntityPlaceEvent event) {
		if (Config.SERVER.enablePerChunkLimit.get()) {
			if (event.getBlockSnapshot().getCurrentBlock().getBlock().hasTileEntity()) {
				if (!Config.SERVER.tileEntityBlockList.get().contains(event.getBlockSnapshot().getRegistryName().toString())) {
					if (event.getWorld().getWorld().getChunk(event.getPos()).getTileEntitiesPos().size() > Config.SERVER.perChunkLimit.get()) {
						event.getEntity().sendMessage(new StringTextComponent(TextFormatting.RED + "Sorry, Tile entity limit per chunk has been reached!"));
						event.setCanceled(true);
					}
				}
			}
		}
		if (Config.SERVER.enablePerChunkWorld.get()) {
			if (event.getBlockSnapshot().getCurrentBlock().getBlock().hasTileEntity()) {
				if (!Config.SERVER.tileEntityBlockList.get().contains(event.getBlockSnapshot().getRegistryName().toString())) {
					if (event.getWorld().getWorld().loadedTileEntityList.size() > Config.SERVER.perChunkWorld.get()) {
						event.getEntity().sendMessage(new StringTextComponent(TextFormatting.RED + "Sorry, Tile entity limit per world has been reached!"));
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
