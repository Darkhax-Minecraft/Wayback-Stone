package net.darkhax.waybackstone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

import static net.darkhax.waybackstone.WayBackStoneItem.teleportToRespawnPoint;
import static net.darkhax.waybackstone.WayBackStoneItem.teleportToWorldSpawn;

public class WayBackStoneHandler {
    public static ItemStack getWayBackStone(){
        LocalPlayer player = Minecraft.getInstance().player;

        if(player==null){
            return null;
        }

        List<ItemStack>[] allSlots = new List[] {
                player.getInventory().items,
                player.getInventory().armor,
                player.getInventory().offhand
        };

        for(List<ItemStack> ListOfSlots : allSlots){
            for(ItemStack item : ListOfSlots){
                if(item.is(Content.WAY_BACK_STONE.get()) && !item.isEmpty()){
                    return item;
                }
            }
        }
        return null;
    }

    public static void handleServerSide(ServerPlayer player){
        if (!teleportToRespawnPoint(player)) {
            teleportToWorldSpawn(player);
        }
    }
    public static void handleClientSide(ItemStack item){
        LocalPlayer player = Minecraft.getInstance().player;

        if(player == null){
            return;
        }

        player.getCooldowns().addCooldown(item.getItem(), 100);
        player.awardStat(Stats.ITEM_USED.get(item.getItem()));
    }
}
