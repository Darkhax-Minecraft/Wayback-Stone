package net.darkhax.waybackstone;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;

public class KeyBindings {

    public static final KeyMapping WayBackStoneKey = new KeyMapping(
            "key.waybackstone.use",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_R,
            KeyMapping.CATEGORY_GAMEPLAY
    );

}
