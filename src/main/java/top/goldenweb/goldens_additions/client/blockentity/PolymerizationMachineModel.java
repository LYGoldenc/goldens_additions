package top.goldenweb.goldens_additions.client.blockentity;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.entities.blocks.PolymerizationMachineEntity;

public class PolymerizationMachineModel extends AnimatedGeoModel<PolymerizationMachineEntity> {
    @Override
    public Identifier getModelResource(PolymerizationMachineEntity object) {
        return new Identifier(Goldens_additions.MOD_ID,"geo/polymerization_machine.geo.json");
    }

    @Override
    public Identifier getTextureResource(PolymerizationMachineEntity object) {
        return new Identifier(Goldens_additions.MOD_ID,"textures/model/block/polymerization_machine.png");
    }

    @Override
    public Identifier getAnimationResource(PolymerizationMachineEntity animatable) {
        return new Identifier(Goldens_additions.MOD_ID,"animations/block/polymerization_machine.animation.json");
    }
}
