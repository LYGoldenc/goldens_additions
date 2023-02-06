package top.goldenweb.goldens_additions.client.blockitem;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.items.PolymerizationMachineBlockItem;

public class PolymerizationMachineItemModel extends AnimatedGeoModel<PolymerizationMachineBlockItem> {
    @Override
    public Identifier getModelResource(PolymerizationMachineBlockItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/polymerization_machine.geo.json");
    }

    @Override
    public Identifier getTextureResource(PolymerizationMachineBlockItem object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/item/polymerization_machine.png");
    }

    @Override
    public Identifier getAnimationResource(PolymerizationMachineBlockItem animatable) {
        return null;
    }
}
