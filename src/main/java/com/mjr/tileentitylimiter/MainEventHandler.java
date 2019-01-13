package com.mjr.tileentitylimiter;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onBlockPlacement(BlockEvent.PlaceEvent event) {
		if (Config.enablePerChunkLimit && event.getWorld().getChunkFromBlockCoords(event.getPos()).getTileEntityMap().size() > Config.perChunkLimit) {
			event.getPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + "Sorry, Tile entity limit per chunk has been reached!"));
			event.setCanceled(true);
		}
		if (Config.enablePerChunkWorld && event.getWorld().loadedTileEntityList.size() > Config.perChunkWorld) {
			event.getPlayer().addChatMessage(new TextComponentString(TextFormatting.RED + "Sorry, Tile entity limit per world has been reached!"));
			event.setCanceled(true);
		}
	}
}
