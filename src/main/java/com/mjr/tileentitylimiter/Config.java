package com.mjr.tileentitylimiter;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	// Config options
	public static int perChunkLimit;
	public static int perChunkWorld;
	
	public static boolean enablePerChunkLimit;
	public static boolean enablePerChunkWorld;
	public static void load() {
		Configuration config = new Configuration(new File("config/TileEntityLimiter.cfg"));
		config.load();

		perChunkLimit = config.get(Configuration.CATEGORY_GENERAL, "Amount of Tile Entities allowed per chunk", 20, "Default: 0 | Will stop block placement if tile entity limit has been exceeded").getInt(20);
		perChunkWorld = config.get(Configuration.CATEGORY_GENERAL, "Amount of Tile Entities allowed per world", 20000, "Default: 0 | Will stop block placement if tile entity limit has been exceeded").getInt(20000);
		enablePerChunkLimit = config.get(Configuration.CATEGORY_GENERAL, "Enable amount of Tile Entities allowed per chunk", true, "Default: true").getBoolean(true);
		enablePerChunkWorld = config.get(Configuration.CATEGORY_GENERAL, "Enable amount of Tile Entities allowed per world", true, "Default: true").getBoolean(true);
		
		config.save();
	}

}
