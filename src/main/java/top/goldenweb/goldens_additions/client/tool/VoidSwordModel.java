package top.goldenweb.goldens_additions.client.tool;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.tools.VoidSwordItem;


public class VoidSwordModel extends AnimatedGeoModel<VoidSwordItem> {
    @Override
    public Identifier getModelResource(VoidSwordItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_sword.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidSwordItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/tool/void_sword.png");
    }

    @Override
    public Identifier getAnimationResource(VoidSwordItem animatable) {
        return null;
    }
}
