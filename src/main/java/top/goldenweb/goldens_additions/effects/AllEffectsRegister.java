package top.goldenweb.goldens_additions.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllEffectsRegister {
    public static final StatusEffect SELL_SOUL_A = new SellSoulEffectA();
    public static final StatusEffect SELL_SOUL_E = new SellSoulEffectE();
    public static final StatusEffect SELL_SOUL = new SellSoulEffect();

    public static void register(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier("goldens_additions", "sell_soul_angel")
                ,SELL_SOUL_A);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("goldens_additions", "sell_soul_evil")
                ,SELL_SOUL_E);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("goldens_additions", "sell_soul")
                ,SELL_SOUL);
    }
}
