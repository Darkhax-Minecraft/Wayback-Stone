package net.darkhax.waybackstone;

import net.darkhax.bookshelf.api.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WayBackStoneMod {

    public static final String MOD_ID = "waybackstone";
    public static final String MOD_NAME = "WayBackStone";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static Content content;

    public WayBackStoneMod() {
        content = new Content();
        Services.REGISTRIES.loadContent(content);
    }
}