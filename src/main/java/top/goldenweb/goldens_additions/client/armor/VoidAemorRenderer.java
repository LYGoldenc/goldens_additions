package top.goldenweb.goldens_additions.client.armor;

import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import top.goldenweb.goldens_additions.items.armor.VoidArmorItem;

public class VoidAemorRenderer extends GeoArmorRenderer<VoidArmorItem> {

    public VoidAemorRenderer() {
        super(new VoidArmorModel());

        this.headBone = "Helmet";
        this.bodyBone = "Chest";
        this.rightArmBone = "RightArm";
        this.leftArmBone = "LeftArm";
        this.rightLegBone = "RightLeg";
        this.leftLegBone = "LeftLeg";
        this.rightBootBone = "RightBoot";
        this.leftBootBone = "LeftBoot";


    }

}



