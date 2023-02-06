package top.goldenweb.goldens_additions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.goldenweb.goldens_additions.utils.VoidWearingAbilitiesUtil;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    public PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "damage", cancellable = true)
    public void demageP(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (!VoidWearingAbilitiesUtil.canDamageByHeatSource(player, source)) {
            cir.setReturnValue(false);
        }
        if (!VoidWearingAbilitiesUtil.canDamageByDrawning(player, source)) {
            cir.setReturnValue(false);
        }
    }
}