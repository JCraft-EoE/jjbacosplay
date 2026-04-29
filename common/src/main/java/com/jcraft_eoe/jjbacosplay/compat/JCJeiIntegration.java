package com.jcraft_eoe.jjbacosplay.compat;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JjbaCosplay;
import dev.architectury.registry.registries.RegistrySupplier;
import lombok.NonNull;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

@JeiPlugin
public class JCJeiIntegration implements IModPlugin {

    @Override
    public @NonNull ResourceLocation getPluginUid() {
        return JjbaCosplay.id("jei");
    }

    @Override
    public void registerRecipes(final IRecipeRegistration registration) {
        var recipeFactory = registration.getJeiHelpers().getVanillaRecipeFactory();
        for (final CosplayItem<? extends ArmorItem> cosplayItem : CosplayItem.all()) {
            for (final RegistrySupplier<? extends ArmorItem> output : cosplayItem) {
                final ItemStack upgradeItem = matchingVanillaUpgradeItem(output.get());
                if (upgradeItem == null) {
                    continue;
                }
                for (final RegistrySupplier<? extends ArmorItem> leftInput : cosplayItem.getAll()) {
                    registration.addRecipes(RecipeTypes.ANVIL, List.of(recipeFactory.createAnvilRecipe(
                            new ItemStack(leftInput.get()), List.of(upgradeItem), List.of(new ItemStack(output.get())),
                            JjbaCosplay.id(output.getId().getPath() + "_from_" + leftInput.getId().getPath())
                    )));
                }
            }
        }
    }

    private static ItemStack matchingVanillaUpgradeItem(ArmorItem item) {
        if (item.getMaterial() == ArmorMaterials.LEATHER) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.LEATHER_HELMET);
                case CHESTPLATE -> new ItemStack(Items.LEATHER_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.LEATHER_LEGGINGS);
                case BOOTS -> new ItemStack(Items.LEATHER_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.IRON) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.IRON_HELMET);
                case CHESTPLATE -> new ItemStack(Items.IRON_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.IRON_LEGGINGS);
                case BOOTS -> new ItemStack(Items.IRON_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.CHAIN) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.CHAINMAIL_HELMET);
                case CHESTPLATE -> new ItemStack(Items.CHAINMAIL_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.CHAINMAIL_LEGGINGS);
                case BOOTS -> new ItemStack(Items.CHAINMAIL_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.GOLD) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.GOLDEN_HELMET);
                case CHESTPLATE -> new ItemStack(Items.GOLDEN_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.GOLDEN_LEGGINGS);
                case BOOTS -> new ItemStack(Items.GOLDEN_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.DIAMOND) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.DIAMOND_HELMET);
                case CHESTPLATE -> new ItemStack(Items.DIAMOND_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.DIAMOND_LEGGINGS);
                case BOOTS -> new ItemStack(Items.DIAMOND_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.NETHERITE) {
            return switch (item.getType()) {
                case HELMET -> new ItemStack(Items.NETHERITE_HELMET);
                case CHESTPLATE -> new ItemStack(Items.NETHERITE_CHESTPLATE);
                case LEGGINGS -> new ItemStack(Items.NETHERITE_LEGGINGS);
                case BOOTS -> new ItemStack(Items.NETHERITE_BOOTS);
            };
        }
        if (item.getMaterial() == ArmorMaterials.TURTLE && item.getType() == ArmorItem.Type.HELMET) {
            return new ItemStack(Items.TURTLE_HELMET);
        }
        return null;
    }
}
