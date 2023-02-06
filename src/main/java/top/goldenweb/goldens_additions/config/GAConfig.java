package top.goldenweb.goldens_additions.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;


@Config(name = "goldens_additions")
@Config.Gui.Background("minecraft:textures/block/gold_block.png")
public class GAConfig implements ConfigData {

        @ConfigEntry.Category("worldgen")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 50)
        @ConfigEntry.Gui.Tooltip()
        public int veinSize = 3;
        @ConfigEntry.Category("worldgen")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 30)
        @ConfigEntry.Gui.Tooltip()
        public int perChunk = 2;
        @ConfigEntry.Category("worldgen")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 200)
        @ConfigEntry.Gui.Tooltip()
        public int height = 50;

        @ConfigEntry.Category("misc")
        @ConfigEntry.Gui.Tooltip()
        public boolean ElytraInArmorConsumeDurability = false;
        @ConfigEntry.Category("misc")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 1000)
        @ConfigEntry.Gui.Tooltip()
        public int timeSellingSoulEffect = 180;
        @ConfigEntry.Category("misc")
        @ConfigEntry.Gui.Tooltip()
        public boolean canChannelingEXTreasure = false;
        @ConfigEntry.Category("misc")
        @ConfigEntry.Gui.Tooltip()
        public boolean canChannelingEXTrade = false;
        @ConfigEntry.Category("misc")
        @ConfigEntry.Gui.Tooltip()
        public boolean canVoidSwordBloodSucking = true;
        @ConfigEntry.Category("misc")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        @ConfigEntry.Gui.Tooltip()
        public int bloodSuckingAmount = 20;
        @ConfigEntry.Category("misc")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
        @ConfigEntry.Gui.Tooltip()
        public int chargedGunPowderColldown = 10;






}
