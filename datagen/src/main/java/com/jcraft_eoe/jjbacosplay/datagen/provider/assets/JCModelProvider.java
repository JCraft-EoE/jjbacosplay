package com.jcraft_eoe.jjbacosplay.datagen.provider.assets;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import dev.architectury.registry.registries.RegistrySupplier;
import lombok.NonNull;
import lombok.SneakyThrows;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.ArmorItem;

import java.util.Locale;

public class JCModelProvider extends FabricModelProvider {

    public JCModelProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(final BlockModelGenerators blockModelGenerators) {
        // intentionally empty (no blocks in this mod)
    }

    @Override
    public void generateItemModels(final ItemModelGenerators generator) {
        generateCosplayModels(generator);
    }

    @SneakyThrows
    private void generateCosplayModels(final @NonNull ItemModelGenerators generator) {
        for (final CosplayItem<?> cosplayItem : CosplayItem.all()) {
            for (final RegistrySupplier<? extends ArmorItem> item : cosplayItem) {
                generator.generateLayeredItem(item.getId().withPath(p -> "item/" + p),
                        JjbaCosplay.id("item/" + cosplayItem.getName()), JjbaCosplay.id("item/cosplay/" + item.get().getMaterial().getName().toLowerCase(Locale.ROOT)));
            }
        }
    }
}
