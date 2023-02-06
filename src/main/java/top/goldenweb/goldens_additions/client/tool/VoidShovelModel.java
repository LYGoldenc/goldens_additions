package top.goldenweb.goldens_additions.client.tool;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.tools.VoidShovelItem;

public class VoidShovelModel extends AnimatedGeoModel<VoidShovelItem> {
    @Override
    public Identifier getModelResource(VoidShovelItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_shovel.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidShovelItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/tool/void_shovel.png");
    }

    @Override
    public Identifier getAnimationResource(VoidShovelItem animatable) {
        return null;
    }
}
