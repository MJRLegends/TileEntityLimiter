package com.mjr.tileentitylimiter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = TileEntityLimiter.MODID, version = TileEntityLimiter.VERSION, dependencies = "required-after:Forge@[10.13.4.1558,);", acceptableRemoteVersions="*")
public class TileEntityLimiter {
	public static final String MODID = "tileentitylimiter";
	public static final String VERSION = "1.7.10-1.0.1";

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load();
		MinecraftForge.EVENT_BUS.register(new MainEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
