package com.jcraft_eoe.jjbacosplay.datagen.provider.data;

import com.jcraft_eoe.jjbacosplay.CosplayItem;
import com.jcraft_eoe.jjbacosplay.JCItemRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Map;
import java.util.function.Consumer;

public class JCRecipeProvider extends FabricRecipeProvider {

    public static final Map<ArmorMaterial, Item> HELMET_MAP = Map.ofEntries(
            Map.entry(ArmorMaterials.LEATHER, Items.LEATHER_HELMET),
            Map.entry(ArmorMaterials.GOLD, Items.GOLDEN_HELMET),
            Map.entry(ArmorMaterials.CHAIN, Items.CHAINMAIL_HELMET),
            Map.entry(ArmorMaterials.IRON, Items.IRON_HELMET),
            Map.entry(ArmorMaterials.DIAMOND, Items.DIAMOND_HELMET),
            Map.entry(ArmorMaterials.TURTLE, Items.TURTLE_HELMET),
            Map.entry(ArmorMaterials.NETHERITE, Items.NETHERITE_HELMET)
    );
    public static final Map<ArmorMaterial, Item> CHESTPLATE_MAP = Map.ofEntries(
            Map.entry(ArmorMaterials.LEATHER, Items.LEATHER_CHESTPLATE),
            Map.entry(ArmorMaterials.GOLD, Items.GOLDEN_CHESTPLATE),
            Map.entry(ArmorMaterials.CHAIN, Items.CHAINMAIL_CHESTPLATE),
            Map.entry(ArmorMaterials.IRON, Items.IRON_CHESTPLATE),
            Map.entry(ArmorMaterials.DIAMOND, Items.DIAMOND_CHESTPLATE),
            Map.entry(ArmorMaterials.NETHERITE, Items.NETHERITE_CHESTPLATE)
    );
    public static final Map<ArmorMaterial, Item> LEGGINGS_MAP = Map.ofEntries(
            Map.entry(ArmorMaterials.LEATHER, Items.LEATHER_LEGGINGS),
            Map.entry(ArmorMaterials.GOLD, Items.GOLDEN_LEGGINGS),
            Map.entry(ArmorMaterials.CHAIN, Items.CHAINMAIL_LEGGINGS),
            Map.entry(ArmorMaterials.IRON, Items.IRON_LEGGINGS),
            Map.entry(ArmorMaterials.DIAMOND, Items.DIAMOND_LEGGINGS),
            Map.entry(ArmorMaterials.NETHERITE, Items.NETHERITE_LEGGINGS)
    );
    public static final Map<ArmorMaterial, Item> BOOTS_MAP = Map.ofEntries(
            Map.entry(ArmorMaterials.LEATHER, Items.LEATHER_BOOTS),
            Map.entry(ArmorMaterials.GOLD, Items.GOLDEN_BOOTS),
            Map.entry(ArmorMaterials.CHAIN, Items.CHAINMAIL_BOOTS),
            Map.entry(ArmorMaterials.IRON, Items.IRON_BOOTS),
            Map.entry(ArmorMaterials.DIAMOND, Items.DIAMOND_BOOTS),
            Map.entry(ArmorMaterials.NETHERITE, Items.NETHERITE_BOOTS)
    );
    public static final Map<ArmorItem.Type, Map<ArmorMaterial, Item>> TYPE_MAP = Map.of(
            ArmorItem.Type.HELMET, HELMET_MAP,
            ArmorItem.Type.CHESTPLATE, CHESTPLATE_MAP,
            ArmorItem.Type.LEGGINGS, LEGGINGS_MAP,
            ArmorItem.Type.BOOTS, BOOTS_MAP
    );

    public JCRecipeProvider(final FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(final Consumer<FinishedRecipe> exporter) {
        buildCosplayRecipes(exporter);
    }

    public record SymbolItem(char symbol, Item item) {
        // intentionally left empty
    }

    public static void buildCosplayRecipes(Consumer<FinishedRecipe> exporter) {
        generateCosplayRecipes(JCItemRegistry.STRAIZO_PONCHO, exporter, new String[] {
                        "BBB",
                        "BXB",
                        " B "
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.KARS_HEADWRAP, exporter, new String[] {
                        " X ",
                        "L L",
                        " B "
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('L', Items.LEATHER));
        generateCosplayRecipes(JCItemRegistry.DIO_P1_WIG, exporter, new String[] {
                        " W ",
                        "WXW"
                },
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.DIO_P1_JACKET, exporter, new String[] {
                        "RPR",
                        "RXR",
                        "WBW"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL),
                new SymbolItem('R', Items.RED_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_P1_PANTS, exporter, new String[] {
                        "RWR",
                        "RXR",
                        "R R"
                },
                new SymbolItem('R', Items.RED_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_P1_BOOTS, exporter, new String[] {
                        "PXP",
                        "B B"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_CAP, exporter, new String[] {
                        "BYB",
                        "BXB"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_JACKET, exporter, new String[] {
                        "B B",
                        "BXB",
                        "BBB"
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_PANTS, exporter, new String[] {
                        "YYY",
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_BOOTS, exporter, new String[] {
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.KAKYOIN_WIG, exporter, new String[] {
                        "WRW",
                        "RXR"
                },
                new SymbolItem('R', Items.RED_WOOL),
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.KAKYOIN_COAT, exporter, new String[] {
                        "GYG",
                        "GXG",
                        "GGG"
                },
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KAKYOIN_PANTS, exporter, new String[] {
                        "GGG",
                        "GXG",
                        "G G"
                },
                new SymbolItem('G', Items.GREEN_WOOL));
        generateCosplayRecipes(JCItemRegistry.KAKYOIN_BOOTS, exporter, new String[] {
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL));
        generateCosplayRecipes(JCItemRegistry.POLNAREFF_WIG, exporter, new String[] {
                        "W",
                        "W",
                        "X"
                },
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.POLNAREFF_SHIRT, exporter, new String[] {
                        "  B",
                        "BXB",
                        "BBB"
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.POLNAREFF_PANTS, exporter, new String[] {
                        "WRW",
                        "WXW",
                        "W W"
                },
                new SymbolItem('R', Items.RED_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.POLNAREFF_BOOTS, exporter, new String[] {
                        "B B",
                        "BXB"
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_HEADBAND, exporter, new String[] {
                        "GXG"
                },
                new SymbolItem('G', Items.GREEN_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_JACKET, exporter, new String[] {
                        "Y Y",
                        "YXY",
                        "YBY"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_CAPE, exporter, new String[] {
                        "RLR",
                        "LXL",
                        "LLL"
                },
                new SymbolItem('L', Items.RED_CARPET),
                new SymbolItem('R', Items.RED_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_PANTS, exporter, new String[] {
                        "GGG",
                        "YXY",
                        "Y Y"
                },
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIO_BOOTS, exporter, new String[] {
                        "YXY",
                        "Y Y"
                },
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.OH_DIO_WIG, exporter, new String[] {
                        "OWO",
                        "WXW"
                },
                new SymbolItem('O', Items.ORANGE_WOOL),
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.OH_DIO_JACKET, exporter, new String[] {
                        "PPP",
                        "BXB",
                        "GBG"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.GRAY_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.OH_DIO_PANTS, exporter, new String[] {
                        "LLL",
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.LIGHT_BLUE_WOOL),
                new SymbolItem('L', Items.LIGHT_GRAY_WOOL));
        generateCosplayRecipes(JCItemRegistry.OH_DIO_BOOTS, exporter, new String[] {
                        "LXL",
                        "G G"
                },
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('L', Items.LIME_WOOL));
        generateCosplayRecipes(JCItemRegistry.HEAVEN_ATTAINED_WIG, exporter, new String[] {
                        "WWW",
                        "WXW",
                        "W W"
                },
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.HEAVEN_ATTAINED_SHIRT, exporter, new String[] {
                        "WWW",
                        "GXG",
                        "U U"
                },
                new SymbolItem('G', Items.GOLD_INGOT),
                new SymbolItem('U', Items.WHITE_CARPET),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.HEAVEN_ATTAINED_PANTS, exporter, new String[] {
                        "WWW",
                        "GXG",
                        "W W"
                },
                new SymbolItem('G', Items.GOLD_INGOT),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.HEAVEN_ATTAINED_BOOTS, exporter, new String[] {
                        "GXG",
                        "G G"
                },
                new SymbolItem('G', Items.GOLD_INGOT));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P4_CAP, exporter, new String[] {
                        "WYW",
                        "GXG"
                },
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P4_JACKET, exporter, new String[] {
                        "W W",
                        "GXG",
                        "GWG"
                },
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P4_PANTS, exporter, new String[] {
                        "BBB",
                        "GXG",
                        "W W"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P4_BOOTS, exporter, new String[] {
                        "W W",
                        "PXP",
                        "G G"
                },
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P6_CAP, exporter, new String[] {
                        "LGB",
                        "BXB"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.GOLD_NUGGET),
                new SymbolItem('L', Items.LIME_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P6_JACKET, exporter, new String[] {
                        "B B",
                        "LXL",
                        "BWB"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('L', Items.LIME_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P6_PANTS, exporter, new String[] {
                        "YBY",
                        "BXB",
                        "Y Y"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOTARO_P6_BOOTS, exporter, new String[] {
                        "O O",
                        "YXY",
                        "Y Y"
                },
                new SymbolItem('O', Items.ORANGE_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KIRA_WIG, exporter, new String[] {
                        "WYW",
                        "YXY"
                },
                new SymbolItem('W', Items.WHEAT),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KIRA_JACKET, exporter, new String[] {
                        "BPB",
                        "BXB",
                        "BYB"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KIRA_PANTS, exporter, new String[] {
                        "BPB",
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.KIRA_BOOTS, exporter, new String[] {
                        " Y ",
                        "YXY",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KOSAKU_WIG, exporter, new String[] {
                        "WBW",
                        "BXB"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.KOSAKU_JACKET, exporter, new String[] {
                        "WGW",
                        "WXW",
                        "WYW"
                },
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.KOSAKU_PANTS, exporter, new String[] {
                        "WWW",
                        "GXG",
                        "W W"
                },
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.KOSAKU_BOOTS, exporter, new String[] {
                        "PXP",
                        "U U"
                },
                new SymbolItem('P', Items.PINK_WOOL),
                new SymbolItem('U', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.FINAL_KIRA_WIG, exporter, new String[] {
                        "WBW",
                        "YXY"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('W', Items.WHEAT),
                new SymbolItem('Y', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.FINAL_KIRA_JACKET, exporter, new String[] {
                        "WGW",
                        "WXW",
                        "WWW"
                },
                new SymbolItem('G', Items.LIME_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.FINAL_KIRA_PANTS, exporter, new String[] {
                        "GWG",
                        "WXW",
                        "W W"
                },
                new SymbolItem('G', Items.LIGHT_GRAY_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.FINAL_KIRA_BOOTS, exporter, new String[] {
                        "GXG",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('G', Items.GREEN_WOOL));
        generateCosplayRecipes(JCItemRegistry.GIORNO_WIG, exporter, new String[] {
                        "WWW",
                        " X "
                },
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.GIORNO_JACKET, exporter, new String[] {
                        "P P",
                        "PXP",
                        "PPP"
                },
                new SymbolItem('P', Items.PINK_WOOL));
        generateCosplayRecipes(JCItemRegistry.GIORNO_PANTS, exporter, new String[] {
                        "PPP",
                        "PXP",
                        "P P"
                },
                new SymbolItem('P', Items.PINK_WOOL));
        generateCosplayRecipes(JCItemRegistry.GIORNO_BOOTS, exporter, new String[] {
                        "BXB",
                        "L L"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('L', Items.LIGHT_BLUE_WOOL));
        generateCosplayRecipes(JCItemRegistry.RISOTTO_CAP, exporter, new String[] {
                        "BBB",
                        "BXB",
                        "GGG"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.GOLD_NUGGET));
        generateCosplayRecipes(JCItemRegistry.RISOTTO_JACKET, exporter, new String[] {
                        "BBB",
                        "BXB",
                        "ZGZ"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.GOLD_INGOT),
                new SymbolItem('Z', Items.BLACK_CARPET));
        generateCosplayRecipes(JCItemRegistry.RISOTTO_PANTS, exporter, new String[] {
                        "WBW",
                        "BXB",
                        "W W"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.RISOTTO_BOOTS, exporter, new String[] {
                        "BXB",
                        "L L"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('L', Items.LIGHT_GRAY_WOOL));
        generateCosplayRecipes(JCItemRegistry.DOPPIO_WIG, exporter, new String[] {
                        "WPW",
                        "PXP",
                        " W "
                },
                new SymbolItem('P', Items.PINK_WOOL),
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.DOPPIO_SHIRT, exporter, new String[] {
                        "PPP",
                        "PXP",
                },
                new SymbolItem('P', Items.PINK_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIAVOLO_WIG, exporter, new String[] {
                        "WPW",
                        "PXP",
                        " B "
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('P', Items.PINK_WOOL),
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.DIAVOLO_SHIRT, exporter, new String[] {
                        "B B",
                        " X ",
                        "B B"
                },
                new SymbolItem('B', Items.BLACK_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIAVOLO_PANTS, exporter, new String[] {
                        "GGG",
                        "PXP",
                        "P P"
                },
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIAVOLO_BOOTS, exporter, new String[] {
                        "BXB",
                        "L L"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('L', Items.LIGHT_BLUE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOHNNY_CAP, exporter, new String[] {
                        " L ",
                        "WGW",
                        "WXW"
                },
                new SymbolItem('G', Items.GOLD_INGOT),
                new SymbolItem('L', Items.LIGHT_BLUE_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOHNNY_JACKET, exporter, new String[] {
                        "WFW",
                        "LXM",
                        "WPW"
                },
                new SymbolItem('F', Items.FEATHER),
                new SymbolItem('L', Items.LIGHT_BLUE_WOOL),
                new SymbolItem('M', Items.MAGENTA_WOOL),
                new SymbolItem('P', Items.PURPLE_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOHNNY_PANTS, exporter, new String[] {
                        "PPP",
                        "PXP",
                        "P P"
                },
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.JOHNNY_BOOTS, exporter, new String[] {
                        "LXL",
                        "L L"
                },
                new SymbolItem('L', Items.LIGHT_GRAY_WOOL));
        generateCosplayRecipes(JCItemRegistry.GYRO_HAT, exporter, new String[] {
                        "SPS",
                        "YXY",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('P', Items.GLASS_PANE),
                new SymbolItem('S', Items.STRING),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.GYRO_SHIRT, exporter, new String[] {
                        "GGG",
                        "PXP",
                        "BPB"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('G', Items.GREEN_CARPET),
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.GYRO_PANTS, exporter, new String[] {
                        "YIY",
                        "YXY",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('I', Items.IRON_INGOT),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.GYRO_BOOTS, exporter, new String[] {
                        "I I",
                        "BXB",
                        "G G"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('G', Items.GREEN_WOOL),
                new SymbolItem('I', Items.IRON_NUGGET));
        generateCosplayRecipes(JCItemRegistry.DIEGO_HAT, exporter, new String[] {
                        "YYY",
                        "CXC",
                        "S S"
                },
                new SymbolItem('C', Items.CYAN_WOOL),
                new SymbolItem('S', Items.STRING),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIEGO_SHIRT, exporter, new String[] {
                        "CCC",
                        "YXY",
                        "CCC"
                },
                new SymbolItem('C', Items.CYAN_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIEGO_PANTS, exporter, new String[] {
                        "BYB",
                        "YXY",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL));
        generateCosplayRecipes(JCItemRegistry.DIEGO_BOOTS, exporter, new String[] {
                        "I I",
                        "BXB",
                        "B B"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('I', Items.IRON_NUGGET));
        generateCosplayRecipes(JCItemRegistry.RINGO_OUTFIT, exporter, new String[] {
                        "ZZZ",
                        "WXW",
                        "W W"
                },
                new SymbolItem('W', Items.WHITE_WOOL),
                new SymbolItem('Z', Items.WHITE_CARPET));
        generateCosplayRecipes(JCItemRegistry.RINGO_BOOTS, exporter, new String[] {
                        "BXB",
                        "W W"
                },
                new SymbolItem('B', Items.BROWN_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.COWBOY_HAT, exporter, new String[] {
                        "LNL",
                        "LXL"
                },
                new SymbolItem('L', Items.LEATHER),
                new SymbolItem('N', Items.FEATHER));
        generateCosplayRecipes(JCItemRegistry.COWBOY_PONCHO, exporter, new String[] {
                        "LXL",
                        "NLN",
                        " N "
                },
                new SymbolItem('L', Items.GREEN_CARPET),
                new SymbolItem('N', Items.WHITE_CARPET));
        generateCosplayRecipes(JCItemRegistry.COWBOY_GUNBELT_SPURS, exporter, new String[] {
                        "LXK",
                        "L  ",
                        "NLN"
                },
                new SymbolItem('L', Items.LEATHER),
                new SymbolItem('K', Items.GOLD_NUGGET),
                new SymbolItem('N', Items.IRON_NUGGET));
        generateCosplayRecipes(JCItemRegistry.VALENTINE_WIG, exporter, new String[] {
                        " X ",
                        "W W",
                        "W W"
                },
                new SymbolItem('W', Items.WHEAT));
        generateCosplayRecipes(JCItemRegistry.VALENTINE_JACKET, exporter, new String[] {
                        "PPP",
                        "PXP",
                        "WPW"
                },
                new SymbolItem('P', Items.PINK_WOOL),
                new SymbolItem('W', Items.WHITE_WOOL));
        generateCosplayRecipes(JCItemRegistry.VALENTINE_PANTS, exporter, new String[] {
                        "PMP",
                        "PXP",
                        "P P"
                },
                new SymbolItem('M', Items.MAGENTA_WOOL),
                new SymbolItem('P', Items.PINK_WOOL));
        generateCosplayRecipes(JCItemRegistry.VALENTINE_BOOTS, exporter, new String[] {
                        "PXP",
                        "P P"
                },
                new SymbolItem('P', Items.PURPLE_WOOL));
        generateCosplayRecipes(JCItemRegistry.PUCCIS_HAT, exporter, new String[] {
                        "BNB",
                        "LXL"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('L', Items.LEATHER),
                new SymbolItem('N', Items.GOLD_NUGGET));
        generateCosplayRecipes(JCItemRegistry.PUCCI_ROBE, exporter, new String[] {
                        "BYB",
                        "BXB",
                        "ZYZ"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('Y', Items.YELLOW_WOOL),
                new SymbolItem('Z', Items.BLACK_CARPET));
        generateCosplayRecipes(JCItemRegistry.PUCCI_PANTS, exporter, new String[] {
                        "BBB",
                        "GXG",
                        "B B"
                },
                new SymbolItem('B', Items.BLACK_WOOL),
                new SymbolItem('G', Items.GRAY_WOOL));
        generateCosplayRecipes(JCItemRegistry.PUCCI_BOOTS, exporter, new String[] {
                        "BXB",
                        "G G"
                },
                new SymbolItem('B', Items.BLUE_WOOL),
                new SymbolItem('G', Items.GRAY_WOOL));
    }

    /**
     *
     * @param cosplay
     * @param exporter
     * @param pattern
     * @param ingredients The item meanings for symbols; do NOT include X, for it marks the (tiered) armor piece
     */
    public static void generateCosplayRecipes(CosplayItem<?> cosplay, Consumer<FinishedRecipe> exporter, String[] pattern, SymbolItem... ingredients) {
        for (Map.Entry<ArmorMaterial, Item> entry : TYPE_MAP.get(cosplay.getSlot()).entrySet()) {
            final RegistrySupplier<? extends ArmorItem> cosplayItem = cosplay.get(entry.getKey());
            if (cosplayItem == null) {
                continue;
            }
            ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, cosplayItem.get());
            for (String line : pattern) {
                builder = builder.pattern(line);
            }
            for (SymbolItem si : ingredients) {
                builder = builder.define(si.symbol(), si.item());
            }
            builder.define('X', entry.getValue()) // the armor piece to change into cosplay
                    .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(entry.getValue()).getPath(),
                            InventoryChangeTrigger.TriggerInstance.hasItems(entry.getValue()))
                    .save(exporter);
        }
    }
}
