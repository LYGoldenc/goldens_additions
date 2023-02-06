package top.goldenweb.goldens_additions.client.tool;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.tools.VoidPickaxeItem;

public class VoidPickaxeModel extends AnimatedGeoModel<VoidPickaxeItem> {
    @Override
    public Identifier getModelResource(VoidPickaxeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_pickaxe.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidPickaxeItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/tool/void_pickaxe.png");
    }

    @Override
    public Identifier getAnimationResource(VoidPickaxeItem animatable) {
        return null;
    }
}
