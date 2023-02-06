package top.goldenweb.goldens_additions.client.item;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.items.CustomBookItem;

public class CBookItemRenderer extends GeoItemRenderer<CustomBookItem> {

    public CBookItemRenderer() {
        super(new CBookItemModel());
    }
}
