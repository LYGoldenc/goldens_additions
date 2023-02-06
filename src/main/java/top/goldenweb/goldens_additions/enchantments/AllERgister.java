package top.goldenweb.goldens_additions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import top.goldenweb.goldens_additions.Goldens_additions;

public class AllERgister {
    public static Enchantment CHANNELINGEX = new ChannelingEX();


public static void register(){
    Registry.register(Registry.ENCHANTMENT, new Identifier(Goldens_additions.MOD_ID, "channelingex"),CHANNELINGEX);
     }
}
