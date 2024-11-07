package net.darkhax.waybackstone;

import net.darkhax.bookshelf.api.registry.RegistryDataProvider;

public class Content extends RegistryDataProvider {

    public Content() {

        super(WayBackStoneMod.MOD_ID);
        this.items.add(WayBackStoneItem::new, "way_back_stone");
    }
}