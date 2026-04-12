package com.jcraft_eoe.jjbacosplay.datagen.provider.assets;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

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
//        generator.generateFlatItem(com.jcraft_eoe.jjbamusic.JCItemRegistry.DISC_STAND_PROUD.get(), ModelTemplates.MUSIC_DISC);
    }
}
