package net.darkhax.waybackstone;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class WayBackStoneItem extends Item {

    public WayBackStoneItem(Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public InteractionResult use(Level level, Player player, @NotNull InteractionHand hand) {
        final ItemStack heldItem = player.getItemInHand(hand);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            teleportToRespawnPoint(serverPlayer);
        }
        if (!player.isCreative() && WayBackStoneMod.CFG.cooldown_time > 0) {
            player.getCooldowns().addCooldown(heldItem, WayBackStoneMod.CFG.cooldown_time);
        }
        if (heldItem.has(DataComponents.MAX_DAMAGE)) {
            heldItem.hurtAndBreak(1, player, hand);
        }
        else if (WayBackStoneMod.CFG.single_use) {
            heldItem.shrink(1);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }

    private static void teleportToRespawnPoint(ServerPlayer player) {
        final TeleportTransition transition = player.findRespawnPositionAndUseSpawnBlock(true, TeleportTransition.DO_NOTHING);
        player.teleport(transition);
        final Vec3 pos = transition.position();
        if (WayBackStoneMod.CFG.play_teleport_sound) {
            transition.newLevel().playSound(null, pos.x, pos.y, pos.z, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        }
    }

    @Override
    public void appendHoverText(@NonNull ItemStack itemStack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, @NonNull Consumer<Component> builder, @NonNull TooltipFlag tooltipFlag) {
        if (WayBackStoneMod.CFG.display_description) {
            builder.accept(WayBackStoneMod.CFG.description);
        }
    }
}
