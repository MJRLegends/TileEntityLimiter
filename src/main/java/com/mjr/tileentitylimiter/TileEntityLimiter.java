package com.mjr.tileentitylimiter;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TileEntityLimiter.MODID, version = TileEntityLimiter.VERSION, dependencies = "required-after:forge@[13.20.1.2513,);",serverSideOnly = true)
public class TileEntityLimiter {
	public static final String MODID = "tileentitylimiter";
	public static final String VERSION = "1.11.2-1.0.0";

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
