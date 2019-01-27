package com.mjr.tileentitylimiter;

import java.util.Arrays;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainEventHandler {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onBlockPlacement(BlockEvent.PlaceEvent event) {
		if (Config.enablePerChunkLimit) {
			if (event.blockSnapshot.getTileEntity() != null) {
				if (!Arrays.asList(Config.tileEntityBlockList).contains(event.blockSnapshot.blockIdentifier.toString())) {
					if (event.world.getChunkFromBlockCoords(event.pos).getTileEntityMap().size() > Config.perChunkLimit) {
						event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Sorry, Tile entity limit per chunk has been reached!"));
						event.setCanceled(true);
					}
				}
			}
		}
		if (Config.enablePerChunkWorld) {
			if (event.blockSnapshot.getTileEntity() != null) {
				if (!Arrays.asList(Config.tileEntityBlockList).contains(event.blockSnapshot.blockIdentifier.toString())) {
					if (event.world.loadedTileEntityList.size() > Config.perChunkWorld) {
						event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Sorry, Tile entity limit per world has been reached!"));
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
