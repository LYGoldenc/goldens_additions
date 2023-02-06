package top.goldenweb.goldens_additions.items.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;

public class VoidSwordItem extends SwordItem implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public VoidSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    public static float bloodSuckingAmount(@NotNull LivingEntity entity){
        if(!entity.getMainHandStack().isEmpty() && entity instanceof PlayerEntity player){
            if(player.getMainHandStack().getItem() instanceof VoidSwordItem voidSwordItem) {
                return voidSwordItem.getAttackDamage()*(float) CONFIG.bloodSuckingAmount/10;
            }
        }
        return 0;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if(attacker instanceof PlayerEntity player&&player.getHealth()<player.getMaxHealth()&&CONFIG.canVoidSwordBloodSucking){

           player.heal(bloodSuckingAmount(player));
        }
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,100,0));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
