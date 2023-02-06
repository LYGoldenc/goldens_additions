package top.goldenweb.goldens_additions.client.tool;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.tools.VoidSwordItem;

public class VoidSwordRenderer extends GeoItemRenderer<VoidSwordItem> {
    public VoidSwordRenderer() {
        super(new VoidSwordModel());
    }

}
