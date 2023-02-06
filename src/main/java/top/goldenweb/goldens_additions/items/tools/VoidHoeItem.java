package top.goldenweb.goldens_additions.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class VoidHoeItem extends HoeItem implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public VoidHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }


    @Override
    public void registerControllers(AnimationData animationData) {

    }


    @Override
    public boolean isDamageable() {
        return false;
    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
