package top.goldenweb.goldens_additions.client.blockentity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import top.goldenweb.goldens_additions.entities.blocks.PolymerizationMachineEntity;

public class PolymerizationMachineRenderer extends GeoBlockRenderer<PolymerizationMachineEntity> {


    public PolymerizationMachineRenderer(BlockEntityRendererFactory.Context context) {
        super(new PolymerizationMachineModel());
    }

    @Override
    public RenderLayer getRenderType(PolymerizationMachineEntity animatable, float partialTick,
                                     MatrixStack poseStack, @Nullable VertexConsumerProvider bufferSource,
                                     @Nullable VertexConsumer buffer, int packedLight, Identifier texture) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
