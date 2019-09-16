package com.mjr.tileentitylimiter;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TileEntityLimiter.MODID, version = TileEntityLimiter.VERSION, dependencies = "required-after:Forge@[11.15.1.1764,);",serverSideOnly = true, acceptableRemoteVersions = "*", certificateFingerprint = "b02331787272ec3515ebe63ecdeea0d746653468")
public class TileEntityLimiter {
	public static final String MODID = "tileentitylimiter";
	public static final String VERSION = "1.8.9-1.0.3";
	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		Config.load();
		MinecraftForge.EVENT_BUS.register(new MainEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		logger.fatal("Invalid fingerprint detected! The file " + event.source.getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
