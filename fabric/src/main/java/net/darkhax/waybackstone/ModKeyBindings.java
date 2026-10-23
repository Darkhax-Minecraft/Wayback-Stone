package net.darkhax.waybackstone;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.world.item.ItemStack;

import static net.darkhax.waybackstone.KeyBindings.WayBackStoneKey;
import static net.darkhax.waybackstone.WayBackStoneHandler.getWayBackStone;
import static net.darkhax.waybackstone.WayBackStoneHandler.handleClientSide;

public class ModKeyBindings implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register( client -> {
            while(WayBackStoneKey.consumeClick()){
                if(client.player == null){
                    continue;
                }
                ItemStack item = getWayBackStone();
                if(item != null){

                    ClientPlayNetworking.send(ModNetwork.WAY_BACK_STONE, PacketByteBufs.empty());

                    handleClientSide(item);
                }
            }
        });
    }
}
