package com.jcraft_eoe.jjbacosplay.datagen;

import com.jcraft_eoe.jjbacosplay.datagen.provider.assets.JCModelProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCAdvancementProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCRecipeProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCTagProviders;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class JjbaCosplayDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        final FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(JCModelProvider::new);
        pack.addProvider(JCTagProviders.JMItemTags::new);
        pack.addProvider(JCRecipeProvider::new);
        pack.addProvider(JCAdvancementProvider::new);
    }
}
