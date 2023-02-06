package top.goldenweb.goldens_additions.items.tools;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

public class VoidPickaxeItem extends PickaxeItem implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public VoidPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, @NotNull World world, Entity entity, int slot, boolean selected) {
        if(world.isClient)return;
        if (entity instanceof PlayerEntity player&&!player.getMainHandStack().isEmpty()){
            if(player.getMainHandStack().getItem()== AllitemsRegister.VOID_PICKAXE&&player.getPos().y<50){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,20,0));
            }else if(player.getMainHandStack().getItem()== AllitemsRegister.VOID_PICKAXE&&player.getPos().y<15){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,20,1));
            }
        }
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
