package net.darkhax.waybackstone;

import net.darkhax.bookshelf.api.function.CachedSupplier;
import net.darkhax.bookshelf.api.registry.RegistryDataProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class Content extends RegistryDataProvider {

    public static Supplier<Item> WAY_BACK_STONE;

    public Content() {

        super(WayBackStoneMod.MOD_ID);
        this.withItemTab(CachedSupplier.cache(() -> BuiltInRegistries.ITEM.get(ResourceLocation.tryBuild(WayBackStoneMod.MOD_ID, "way_back_stone")).getDefaultInstance()));
        WAY_BACK_STONE = this.items.add(WayBackStoneItem::new, "way_back_stone");
    }
}