package net.darkhax.waybackstone;

import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class Content extends RegistryDataProvider {

    public Content() {

        super(WayBackStoneMod.MOD_ID);
        this.withItemTab(CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(ResourceLocation.tryBuild(WayBackStoneMod.MOD_ID, "way_back_stone")).getDefaultInstance()));
        this.items.add(WayBackStoneItem::new, "way_back_stone");
    }
}