package io.github.thatsmusic99.headsplus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class HeadsPlusConfigHeads {
	private static FileConfiguration heads;
	public static File headsF;
	
	public static FileConfiguration getHeads() {
		return heads;
	}
	public static void headsEnable() {
		reloadHeads();
		loadHeads();
	}
	
	private static void loadHeads() {
		getHeads().options().header("HeadsPlus by Thatsmusic99 - Config wiki: https://github.com/Thatsmusic99/HeadsPlus/wiki/Configuration");
		addMHFHeads();
		addUndefinedHeads();
		getHeads().options().copyDefaults(true);
		saveHeads();
	}
	public static void reloadHeads() {
		if (headsF == null) {
			headsF = new File(HeadsPlus.getInstance().getDataFolder(), "heads.yml");
		}
		heads = YamlConfiguration.loadConfiguration(headsF);
	}
    public static void saveHeads() {
    	if (heads == null || headsF == null) {
    		return;
    	}
    	try {
    		heads.save(headsF);
    	} catch (IOException e) {
    		HeadsPlus.getInstance().log.severe("[HeadsPlus] Couldn't save heads.yml!");
    		e.printStackTrace();
    	}
    }
    public static void addUndefinedHeads() {
    	List<String> uHeads = new ArrayList<>(Arrays.asList("bat", "donkey", "enderdragon", "elderguardian", "endermite", "evoker", "horse", "llama", "magmacube", "mule", "polarbear", "rabbit", "shulker", "silverfish", "skeletonhorse", "snowman", "stray", "vex", "vindicator", "wither", "witherskeleton"));
    	for (String key : uHeads) {
    		getHeads().addDefault(key + "HeadN", "");
    		getHeads().addDefault(key + "HeadC", 0);
    		getHeads().addDefault(key + "HeadDN", "");
    		getHeads().addDefault(key + "HeadP", 0.00);
    	}
    }
    public static void addMHFHeads() {
    	List<String> mHeads = new ArrayList<>(Arrays.asList("blaze", "cavespider", "chicken", "cow", "creeper", "enderman", "ghast", "guardian", "irongolem", "mushroomcow", "pig", "sheep", "skeleton", "slime", "spider", "squid", "villager", "witch", "zombie"));
    	for (String key : mHeads) {
    		if (key != "irongolem") {
    		    getHeads().addDefault(key + "HeadN", "MHF_" + key);
    		    getHeads().addDefault(key + "HeadC", 25);
    		    String str = key.substring(0, 1).toUpperCase();
    		    String str2 = key.substring(1);
    		    getHeads().addDefault(key + "HeadDN", str + str2 + " Head");
    		} else {
    			getHeads().addDefault("irongolemHeadN", "MHF_Golem");
    			getHeads().addDefault("irongolemHeadC", 25);
    			getHeads().addDefault("irongolemHeadDN", "Iron Golem Head");
    		}
    	}
    }


}