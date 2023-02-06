package top.goldenweb.goldens_additions.mixin;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.goldenweb.goldens_additions.effects.AllEffectsRegister;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{

    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(at=@At("HEAD"), method = "clearStatusEffects", cancellable = true)
    private void clearStatusEffects(CallbackInfoReturnable<Boolean> cir) {
       if(this.hasStatusEffect(AllEffectsRegister.SELL_SOUL_E)){
           cir.setReturnValue(false);
       }
    }
}
