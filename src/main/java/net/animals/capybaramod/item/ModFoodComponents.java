package net.animals.capybaramod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ModFoodComponents {

    public static final FoodComponent SWEET_POTATO = new FoodComponent
            .Builder()
            .hunger(4)
            .saturationModifier(2.4f)
            .build();

    public static final FoodComponent BAKED_SWEET_POTATO = new FoodComponent
            .Builder()
            .hunger(6)
            .saturationModifier(3f)
            .build();

    public static final FoodComponent GUAVA = new FoodComponent
            .Builder()
            .hunger(3)
            .saturationModifier(0.7f)
            .build();

    public static final FoodComponent MAGIC_SALAD = new FoodComponent
            .Builder()
            .hunger(8)
            .saturationModifier(4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0F)
            .build();

}



