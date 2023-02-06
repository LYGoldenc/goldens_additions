package top.goldenweb.goldens_additions.client.tool;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.tools.VoidPickaxeItem;

public class VoidPickaxeRenderer extends GeoItemRenderer<VoidPickaxeItem> {
    public VoidPickaxeRenderer() {
        super(new VoidPickaxeModel());
    }
}
