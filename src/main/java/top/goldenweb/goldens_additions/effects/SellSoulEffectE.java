package top.goldenweb.goldens_additions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class SellSoulEffectE extends StatusEffect {
    protected SellSoulEffectE() {
        super(StatusEffectCategory.BENEFICIAL,0x800080);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player) {

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 0));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 40, 2));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 2));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 40, 2));

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 40, 2));

        }
        super.applyUpdateEffect(entity,amplifier);
    }
}
