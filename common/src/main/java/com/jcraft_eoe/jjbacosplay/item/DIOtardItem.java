package com.jcraft_eoe.jjbacosplay.item;

import net.minecraft.world.item.ArmorMaterial;

public class DIOtardItem extends DIOJacketItem {
    public DIOtardItem(ArmorMaterial materialIn, Type slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    /*@Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private static GeoArmorRenderer<?> renderer;
            @SuppressWarnings("unchecked")
            @Override public @NonNull HumanoidModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null) renderer = new DIOtardRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }});
    }*/
}
