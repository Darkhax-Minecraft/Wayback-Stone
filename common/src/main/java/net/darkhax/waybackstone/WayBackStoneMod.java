package net.darkhax.waybackstone;

import net.darkhax.pricklemc.common.api.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WayBackStoneMod {

    public static final String MOD_ID = "waybackstone";
    public static final String MOD_NAME = "WayBackStone";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Config CFG = ConfigManager.load(MOD_ID, new Config());
}