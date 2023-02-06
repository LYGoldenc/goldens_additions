package top.goldenweb.goldens_additions.client.tool;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.tools.VoidAxeItem;

public class VoidAxeModel extends AnimatedGeoModel<VoidAxeItem> {
    @Override
    public Identifier getModelResource(VoidAxeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_axe.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidAxeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/tool/void_axe.png");
    }

    @Override
    public Identifier getAnimationResource(VoidAxeItem animatable) {
        return null;
    }
}
