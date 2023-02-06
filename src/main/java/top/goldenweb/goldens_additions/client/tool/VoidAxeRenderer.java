package top.goldenweb.goldens_additions.client.tool;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.tools.VoidAxeItem;

public class VoidAxeRenderer extends GeoItemRenderer<VoidAxeItem> {
    public VoidAxeRenderer() {
        super(new VoidAxeModel());
    }
}
