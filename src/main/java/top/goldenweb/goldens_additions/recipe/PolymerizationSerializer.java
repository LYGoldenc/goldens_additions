package top.goldenweb.goldens_additions.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class PolymerizationSerializer implements RecipeSerializer<PolymerizationRecipe> {

    private PolymerizationSerializer(){}
    public static final PolymerizationSerializer POLYMERIZATION_SERIALIZER = new PolymerizationSerializer();
    public static final String ID = PolymerizationRecipe.Type.ID;

    @Override
    public PolymerizationRecipe read(Identifier id, JsonObject json) {

        JsonArray inputItems  = JsonHelper.getArray(json,"inputs");
        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(4, Ingredient.EMPTY);
        if(inputItems.size()>4){
            throw new JsonParseException("The max-inputs is 4" );
        }else{
            for (int i = 0; i < 4; i++) {
                inputs.set(i, Ingredient.fromJson(inputItems.get(i)));
            }
            final JsonObject outPutItem = JsonHelper.getObject(json, "output");
            final ItemStack output = new ItemStack(JsonHelper.getItem(outPutItem, "item"), JsonHelper.getInt(outPutItem, "count", 1));
            final JsonObject carrierItem = JsonHelper.getObject(json, "carrier");
            final ItemStack carrier = new ItemStack(JsonHelper.getItem(carrierItem, "item"), JsonHelper.getInt(carrierItem, "count", 1));
            final int time = JsonHelper.getInt(json, "time", 100);
            return new PolymerizationRecipe(id,output,inputs,carrier,time);
        }
    }

    @Override
    public PolymerizationRecipe read(Identifier id, PacketByteBuf buf) {

        DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
        for (int i =0 ;i<inputs.size();i++){
            inputs.set(i,Ingredient.fromPacket(buf));
        }
        ItemStack output = buf.readItemStack();
        ItemStack carrier = buf.readItemStack();
        int time = buf.readVarInt();

        return new PolymerizationRecipe(id,output,inputs,carrier,time);
    }

    @Override
    public void write(PacketByteBuf buf, PolymerizationRecipe recipe) {
        buf.writeItemStack(recipe.getOutput());
        buf.writeItemStack(recipe.getCarrier());
        buf.writeVarInt(recipe.getIngredients().size());
        buf.writeVarInt(recipe.getTime());

        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredient.write(buf);
        }

    }
}
