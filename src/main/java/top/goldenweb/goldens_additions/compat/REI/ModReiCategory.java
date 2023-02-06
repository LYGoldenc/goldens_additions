package top.goldenweb.goldens_additions.compat.REI;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ModReiCategory implements DisplayCategory<ModReiDisplay> {

    private static final Identifier GUI = new Identifier(Goldens_additions.MOD_ID, "textures/gui/polymerization_machine_gui1.png");
    private final EntryStack<ItemStack> polymerizing = EntryStacks.of(new ItemStack(AllblocksRegister.POLYMERIZATION_MACHINE));
    @Override
    public CategoryIdentifier<? extends ModReiDisplay> getCategoryIdentifier() {
        return ModReiPlugin.POLYMERIZING;
    }

    @Override
    public Text getTitle() {
        return Text.translatable(Goldens_additions.MOD_ID+"."+"rei.title");
    }

    @Override
    public Renderer getIcon() {
        return polymerizing;
    }

    @Override
    public List<Widget> setupDisplay(ModReiDisplay display, Rectangle bounds) {

        final List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        List<EntryIngredient> inputs = display.getInputEntries();
        List<EntryIngredient> output = display.getOutputEntries();
        List<EntryIngredient> carrier = Collections.singletonList(display.getCarrier());
        widgets.add(Widgets.createTexturedWidget(GUI, bounds.x, bounds.y, 0, 0, 150, 104, 150, 104));
        widgets.add(Widgets.createSlot(new Point(bounds.x+11,bounds.y+36)).entries(inputs.get(0)).disableBackground().markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x+32,bounds.y+16)).entries(inputs.get(1)).disableBackground().markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x+102,bounds.y+16)).entries(inputs.get(2)).disableBackground().markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x+123,bounds.y+36)).entries(inputs.get(3)).disableBackground().markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x+67,bounds.y+15)).entries(carrier.get(0)).disableBackground().markInput());
        widgets.add(Widgets.createSlot(new Point(bounds.x+67,bounds.y+53)).entries(output.get(0)).disableBackground().markInput());
        widgets.add(Widgets.createLabel(
                new Point(bounds.x+76, bounds.y+80),
                Text.literal(display.getTime()/20 + " s")).noShadow().centered().color(0xFF404040, 0xFFBBBBBB));
        return widgets;
    }
    @Override
    public int getDisplayHeight() {
        return 104;
    }
}
