package top.goldenweb.goldens_additions.client.item;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.CustomBookItem;

public class CBookItemModel  extends AnimatedGeoModel<CustomBookItem> {
    @Override
    public Identifier getModelResource(CustomBookItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/ancient_notes.geo.json");
    }

    @Override
    public Identifier getTextureResource(CustomBookItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/item/ancient_notes.png");
    }

    @Override
    public Identifier getAnimationResource(CustomBookItem animatable) {
        return new Identifier(Goldens_additions.MOD_ID,"animations/item/ancient_notes.animation.json");
    }
}
