package net.darkhax.waybackstone;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

import static net.darkhax.waybackstone.WayBackStoneMod.MOD_ID;

public class ModNetwork {

    public static ResourceLocation WAY_BACK_STONE = new ResourceLocation(MOD_ID, "activate");

    public static void register(){
        ServerPlayNetworking.registerGlobalReceiver(
                WAY_BACK_STONE,
                (server, player, handler, buf, responseSender)->{
                    server.execute(()-> WayBackStoneHandler.handleServerSide(player));
                }
        );
    }
}
