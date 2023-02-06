package top.goldenweb.goldens_additions.client.tool;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.tools.VoidHoeItem;

public class VoidHoeModel extends AnimatedGeoModel<VoidHoeItem> {
    @Override
    public Identifier getModelResource(VoidHoeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_hoe.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidHoeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/tool/void_hoe.png");
    }

    @Override
    public Identifier getAnimationResource(VoidHoeItem animatable) {
        return null;
    }
}
