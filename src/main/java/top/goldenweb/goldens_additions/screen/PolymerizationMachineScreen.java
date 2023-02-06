package top.goldenweb.goldens_additions.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.screen.handler.PolymerizationMachineScreenHandler;

public class PolymerizationMachineScreen extends HandledScreen<PolymerizationMachineScreenHandler> {

    private static final Identifier TEXTURE =
            new Identifier(Goldens_additions.MOD_ID, "textures/gui/polymerization_machine_gui.png");

    public PolymerizationMachineScreen(PolymerizationMachineScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, TEXTURE);
            int x = (width - backgroundWidth) / 2;
            int y = (height - backgroundHeight) / 2;
            drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

            renderProgressArrow(matrices, x, y);
    }
    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 57, y + 66, 176, 0, handler.getScaledProgress(),7);
        }
    }
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

}
