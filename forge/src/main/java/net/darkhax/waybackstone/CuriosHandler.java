package net.darkhax.waybackstone;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

import java.util.Map;

public class CuriosHandler {
    public static boolean isInCurios(){

        Player player = Minecraft.getInstance().player;

        if(!ModList.get().isLoaded("curios")){
            return false;
        }
        LazyOptional<ICuriosItemHandler> curios = CuriosApi.getCuriosInventory(player);

        return curios.map(handler->{
            for(Map.Entry<String, ICurioStacksHandler> entry : handler.getCurios().entrySet()){
                IDynamicStackHandler stacksHandler = entry.getValue().getStacks();

                for(int i=0;i< stacksHandler.getSlots();i++){
                    if(stacksHandler.getStackInSlot(i).is(Content.WAY_BACK_STONE.get())){
                        return true;
                    }
                }
            }
            return false;
        }).orElse(false);
    }
}
