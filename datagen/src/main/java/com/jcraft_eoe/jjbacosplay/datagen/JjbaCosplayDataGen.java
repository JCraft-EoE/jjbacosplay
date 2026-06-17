package com.jcraft_eoe.jjbacosplay.datagen;

import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import com.jcraft_eoe.jjbacosplay.datagen.provider.assets.JCModelProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCAdvancementProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCRecipeProvider;
import com.jcraft_eoe.jjbacosplay.datagen.provider.data.JCTagProviders;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jetbrains.annotations.Nullable;

public class JjbaCosplayDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        final FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(JCModelProvider::new);
        pack.addProvider(JCTagProviders.JMItemTags::new);
        pack.addProvider(JCTagProviders.JMEntityTags::new);
        pack.addProvider(JCRecipeProvider::new);
        pack.addProvider(JCAdvancementProvider::new);
    }

    @Override
    public @Nullable String getEffectiveModId() {
        return JjbaCosplay.MOD_ID;
    }
}
