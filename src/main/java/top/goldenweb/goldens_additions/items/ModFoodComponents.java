package top.goldenweb.goldens_additions.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SUPER_LOLLIPOP =new FoodComponent.Builder().hunger(6).saturationModifier(0.8f)
            .snack().statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,1200,0),1)
            .alwaysEdible().build();
    public static final FoodComponent IRON_APPLE = new FoodComponent.Builder().hunger(2).saturationModifier(4.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,2400,0),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,600,0),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,100,0),0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,300,0),0.3f)
            .alwaysEdible().build();
}
