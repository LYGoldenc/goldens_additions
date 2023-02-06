package top.goldenweb.goldens_additions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;

public class SellSoulEffectA extends StatusEffect {
    protected SellSoulEffectA() {
        super(StatusEffectCategory.BENEFICIAL,0xFFD700);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(@NotNull LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player) {

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 40, 3));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 1));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 40, 2));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 40, 2));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 40, 0));

        }
        super.applyUpdateEffect(entity,amplifier);
    }
}
