package com.mjr.tileentitylimiter;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onBlockPlacement(BlockEvent.PlaceEvent event) {
		if (Config.enablePerChunkLimit && event.world.getChunkFromBlockCoords(event.pos).getTileEntityMap().size() > Config.perChunkLimit) {
			event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Sorry, Tile entity limit per chunk has been reached!"));
			event.setCanceled(true);
		}
		if (Config.enablePerChunkWorld && event.world.loadedTileEntityList.size() > Config.perChunkWorld) {
			event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Sorry, Tile entity limit per world has been reached!"));
			event.setCanceled(true);
		}
	}
}
