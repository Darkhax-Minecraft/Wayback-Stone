package net.darkhax.waybackstone;

import net.fabricmc.api.ModInitializer;

public class FabricMod implements ModInitializer {

    @Override
    public void onInitialize() {
        new WayBackStoneMod();
    }
}