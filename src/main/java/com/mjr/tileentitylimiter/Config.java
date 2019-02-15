package com.mjr.tileentitylimiter;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class Config {

	// perChunkLimit = config.get(Configuration.CATEGORY_GENERAL, "Amount of Tile Entities allowed per chunk", 20, "Default: 0 | Will stop block placement if tile entity limit has been exceeded").getInt(20);
	// perChunkWorld = config.get(Configuration.CATEGORY_GENERAL, "Amount of Tile Entities allowed per world", 20000, "Default: 0 | Will stop block placement if tile entity limit has been exceeded").getInt(20000);
	// enablePerChunkLimit = config.get(Configuration.CATEGORY_GENERAL, "Enable amount of Tile Entities allowed per chunk", true, "Default: true").getBoolean(true);
	// enablePerChunkWorld = config.get(Configuration.CATEGORY_GENERAL, "Enable amount of Tile Entities allowed per world", true, "Default: true").getBoolean(true);
	// tileEntityBlockList = config.get("List of Tile Entities to not get counted by limit checker", Configuration.CATEGORY_GENERAL, new String[0], "Format: modid:name | Example: minecraft:furnace").getStringList();
    static final ForgeConfigSpec serverSpec;
    public static final Server SERVER;

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        serverSpec = specPair.getRight();
        SERVER = specPair.getLeft();
    }
    
    public static class Server {
    	public IntValue perChunkLimit;
    	public IntValue perChunkWorld;

    	public BooleanValue enablePerChunkLimit;
    	public BooleanValue enablePerChunkWorld;
    	public ConfigValue<List<? extends String>> tileEntityBlockList;

	    Server(ForgeConfigSpec.Builder builder) {
			builder.comment("Server configuration settings").push("server");
	        perChunkLimit = builder.comment("Default: 20 | Will stop block placement if tile entity limit has been exceeded").translation("config.per.chunkLimit").defineInRange("amountTileEntityPerChunkLimit", 20, 0, Integer.MAX_VALUE);
			perChunkWorld = builder.comment("Default: 20000 | Will stop block placement if tile entity limit has been exceeded").translation("config.per.worldLimit").defineInRange("amountTileEntityPerWorldLimit", 20000, 0, Integer.MAX_VALUE);
			enablePerChunkLimit = builder.comment("Default: true").translation("config.enable.chunkLimit").define("enableChunkLimit", true);
			enablePerChunkWorld = builder.comment("Default: true").translation("config.enable.worldLimit").define("enableWorldLimit", true);
			tileEntityBlockList = builder.comment("Format: modid:name | Example: minecraft:furnace").translation("config.blacklist")
					.defineList("listOfBlocksToExcludeFromLimiter", Lists.newArrayList(" "), o -> o instanceof String);
			builder.pop();
	    }
    }
}
