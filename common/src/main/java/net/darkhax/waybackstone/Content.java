package net.darkhax.waybackstone;

import net.darkhax.bookshelf.common.api.registry.ContentProvider;
import net.darkhax.bookshelf.common.impl.registry.adapter.ItemRegistryAdapter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Rarity;

public class Content implements ContentProvider {

    @Override
    public void defineItems(ItemRegistryAdapter registry) {
        registry.add("way_back_stone", WayBackStoneItem::new, props -> {
            props = props.stacksTo(1).rarity(Rarity.RARE);
            if (WayBackStoneMod.CFG.durability > 1) {
                props = props.durability(WayBackStoneMod.CFG.durability);
                try {
                    if (WayBackStoneMod.CFG.repair_material.startsWith("#")) {
                        props = props.repairable(TagKey.create(Registries.ITEM, Identifier.parse(WayBackStoneMod.CFG.repair_material.substring(1))));
                    }
                    else {
                        final Identifier repairItemId = Identifier.parse(WayBackStoneMod.CFG.repair_material);
                        if (BuiltInRegistries.ITEM.containsKey(repairItemId)) {
                            props = props.repairable(BuiltInRegistries.ITEM.getValue(Identifier.tryParse(WayBackStoneMod.CFG.repair_material)));
                        }
                        else {
                            WayBackStoneMod.LOG.error("Could not set repair material. '{}' is not a registered item.", WayBackStoneMod.CFG.repair_material);
                        }
                    }
                }
                catch (Exception e) {
                    WayBackStoneMod.LOG.error("Encountered an error when setting the repair material. This is likely an issue with the user config. material={}", WayBackStoneMod.CFG.repair_material, e);
                }
            }
            return props;
        });
    }

    @Override
    public String namespace() {
        return WayBackStoneMod.MOD_ID;
    }
}