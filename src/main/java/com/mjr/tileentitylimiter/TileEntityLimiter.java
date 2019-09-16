package com.mjr.tileentitylimiter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tileentitylimiter")
public class TileEntityLimiter {
	private static final Logger logger = LogManager.getLogger();

	public TileEntityLimiter() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		MinecraftForge.EVENT_BUS.register(this);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.serverSpec);
	}

	private void init(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(new MainEventHandler());
	}

	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		logger.fatal("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
