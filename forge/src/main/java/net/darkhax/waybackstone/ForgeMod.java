package net.darkhax.waybackstone;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import static net.darkhax.waybackstone.KeyBindings.WayBackStoneKey;
import static net.darkhax.waybackstone.WayBackStoneHandler.getWayBackStone;
import static net.darkhax.waybackstone.WayBackStoneHandler.handleClientSide;

@Mod.EventBusSubscriber
@Mod(WayBackStoneMod.MOD_ID)
public class ForgeMod {

    public ForgeMod() {
        new WayBackStoneMod();
        ModNetwork.register();
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event){
        if (event.phase == TickEvent.Phase.END) {
            while(WayBackStoneKey.consumeClick()) {
                ItemStack item = getWayBackStone();
                if(item != null || CuriosHandler.isInCurios()){
                    ModNetwork.CHANNEL.sendToServer(new WayBackStonePacket());
                    handleClientSide(item);
                }
            }
        }
    }


}