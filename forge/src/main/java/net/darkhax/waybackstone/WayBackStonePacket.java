package net.darkhax.waybackstone;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WayBackStonePacket {

    public WayBackStonePacket(){

    }
    public static void encode(WayBackStonePacket packet, FriendlyByteBuf buffer){

    }
    public static WayBackStonePacket decode(FriendlyByteBuf buffer){
        return new WayBackStonePacket();
    }
    public static void handle(WayBackStonePacket packet, Supplier<NetworkEvent.Context> context){
        context.get().enqueueWork(() ->{
            ServerPlayer player = context.get().getSender();

            if(player == null) {
                return;
            }
            WayBackStoneHandler.handleServerSide(player);
        });
    }
}
