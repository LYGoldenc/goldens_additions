package top.goldenweb.goldens_additions.client.tool;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.tools.VoidShovelItem;

public class VoidShovelRenderer extends GeoItemRenderer<VoidShovelItem> {
    public VoidShovelRenderer() {
        super(new VoidShovelModel());
    }
}
