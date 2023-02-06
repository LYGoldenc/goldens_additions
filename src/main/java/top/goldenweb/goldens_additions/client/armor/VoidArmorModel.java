package top.goldenweb.goldens_additions.client.armor;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.armor.VoidArmorItem;

public class VoidArmorModel extends AnimatedGeoModel<VoidArmorItem> {

    @Override
    public Identifier getModelResource(VoidArmorItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/void_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(VoidArmorItem object) {

        return new Identifier(Goldens_additions.MOD_ID,"textures/model/armor/void_armor.png");
    }

    @Override
    public Identifier getAnimationResource(VoidArmorItem animatable) {

        return null;
    }
}
