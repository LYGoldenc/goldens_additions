package top.goldenweb.goldens_additions.client.tool;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.tools.VoidHoeItem;

public class VoidHoeRenderer extends GeoItemRenderer<VoidHoeItem> {
    public VoidHoeRenderer() {

        super(new VoidHoeModel());
    }
}
