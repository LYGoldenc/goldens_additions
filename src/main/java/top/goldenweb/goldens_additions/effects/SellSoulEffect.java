package top.goldenweb.goldens_additions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;
import static top.goldenweb.goldens_additions.utils.VoidWearingAbilitiesUtil.cannotSellToEvil;

public class SellSoulEffect extends InstantStatusEffect {
    protected SellSoulEffect() {
        super(StatusEffectCategory.BENEFICIAL,0xF0F8FF);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity player ){
            if(!player.hasStatusEffect(AllEffectsRegister.SELL_SOUL_A)&&!player.hasStatusEffect(AllEffectsRegister.SELL_SOUL_E)){
                final double d = Math.random();
                if(d<=0.5d||cannotSellToEvil(player))
                {
                    player.addStatusEffect(new StatusEffectInstance(AllEffectsRegister.SELL_SOUL_A,CONFIG.timeSellingSoulEffect*20));
                } else
                {
                    player.addStatusEffect(new StatusEffectInstance(AllEffectsRegister.SELL_SOUL_E, (CONFIG.timeSellingSoulEffect/3)*20));
                }
            }
            super.applyUpdateEffect(entity,amplifier);
        }
    }

    public boolean isInstant() {
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
