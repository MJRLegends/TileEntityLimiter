package com.mjr.tileentitylimiter;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TileEntityLimiter.MODID, version = TileEntityLimiter.VERSION, dependencies = "required-after:Forge@[12.18.3.2239,);",serverSideOnly = true, acceptableRemoteVersions = "*")
public class TileEntityLimiter {
	public static final String MODID = "tileentitylimiter";
	public static final String VERSION = "1.10.2-1.0.1";

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
