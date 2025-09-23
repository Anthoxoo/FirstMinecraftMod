package net.anthox.testmod.food;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    // Nutrition is how much the food will help the hunger and saturationModifier is if we want to give extra hearts
    //calc of the number of extra hearts : nutrition(5) et saturationModifier(0.25f) :
    //Saturation = 5 × 0.25 × 2 = 2.5 points
    public static final FoodComponent SERRANO = new FoodComponent.Builder().nutrition(5).saturationModifier(0.25f).statusEffect(
            new StatusEffectInstance(StatusEffects.BLINDNESS,200), 100).build();
}
