package net.anthox.testmod.food;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SERRANO = new FoodComponent.Builder().nutrition(5).saturationModifier(0.25f).statusEffect(
            new StatusEffectInstance(StatusEffects.BLINDNESS,200), 100).build();
}
