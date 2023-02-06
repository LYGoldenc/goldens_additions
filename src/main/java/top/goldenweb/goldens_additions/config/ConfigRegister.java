package top.goldenweb.goldens_additions.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class ConfigRegister {
    public static GAConfig CONFIG = new GAConfig();

    public static void register(){
        AutoConfig.register(GAConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(GAConfig.class).getConfig();

    }
}
