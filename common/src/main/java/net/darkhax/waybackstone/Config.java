package net.darkhax.waybackstone;

import net.darkhax.pricklemc.common.api.annotations.RangedInt;
import net.darkhax.pricklemc.common.api.annotations.Value;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class Config {

    @RangedInt(min = -1)
    @Value(comment = "The cooldown timer applied when using the charm. Set to -1 to disable cooldown.")
    public int cooldown_time = 100;

    @Value(comment = "Sets the amount of durability on the charm. Set to -1 to disable durability. You can also add durability using item components.")
    public int durability = -1;

    @Value(comment = "The item used to repair the stone. Supports an item ID or prefix with # to use an item tag.")
    public String repair_material = "#waybackstone:repairs_waybackstone";

    @Value(comment = "When enabled, the charm will be completely consumed upon use.")
    public boolean single_use = false;

    @Value(comment = "Should the stone play a sound when the user teleports?")
    public boolean play_teleport_sound = true;

    @Value(comment = "Should a brief description of the item be added to its tooltip?")
    public boolean display_description = true;

    @Value(comment = "A text component to be added to the item tooltip when description tooltips are enabled.")
    public Component description = Component.translatable("item.waybackstone.way_back_stone.desc").withStyle(ChatFormatting.DARK_GRAY);

}