package net.darkhax.waybackstone;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class WayBackStoneItem extends Item {

    private static final Component TOOLTIP = Component.translatable("item.waybackstone.way_back_stone.desc").withStyle(ChatFormatting.DARK_GRAY);

    public WayBackStoneItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        final ItemStack heldItem = player.getItemInHand(hand);
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            if (!teleportToRespawnPoint(serverPlayer)) {
                teleportToWorldSpawn(serverPlayer);
            }
        }
        player.getCooldowns().addCooldown(this, 100);
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(heldItem, level.isClientSide());
    }

    private static boolean teleportToRespawnPoint(ServerPlayer player) {
        final BlockPos respawnPos = player.getRespawnPosition();
        final ServerLevel respawnLevel = player.server.getLevel(player.getRespawnDimension());
        if (respawnLevel != null && respawnPos != null) {
            final Optional<Vec3> targetPos = Player.findRespawnPositionAndUseSpawnBlock(respawnLevel, respawnPos, player.getRespawnAngle(), false, true);
            if (targetPos.isPresent()) {
                final Vec3 target = targetPos.get();
                player.teleportTo(respawnLevel, target.x, target.y, target.z, player.getYRot(), player.getXRot());
                respawnLevel.playSound(null, target.x, target.y, target.z, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
                return true;
            }
        }
        return false;
    }

    private static void teleportToWorldSpawn(ServerPlayer player) {
        final ServerLevel level = player.server.overworld();
        final BlockPos respawnPos = level.getSharedSpawnPos();
        player.teleportTo(level, respawnPos.getX() + 0.5f, respawnPos.getY() + 0.1f, respawnPos.getZ() + 0.5f, player.getYRot(), player.getXRot());
        level.playSound(null, respawnPos.getX() + 0.5f, respawnPos.getY() + 0.1f, respawnPos.getZ() + 0.5f, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.NEUTRAL, 0.5F, 0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F));
        while(!level.noCollision(player) && player.getY() < level.getMaxBuildHeight()) {
            player.setPos(player.getX(), player.getY() + 1d, player.getZ());
        }
        player.connection.teleport(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flags) {
        tooltip.add(TOOLTIP);
    }
}
