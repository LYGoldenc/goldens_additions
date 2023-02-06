package top.goldenweb.goldens_additions.world.dimension;


import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;


public class StillGarden {

    public static final RegistryKey<World> STILL_GARDEN_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier("goldens_additions","still_garden"));
    public static final RegistryKey<DimensionType> STILL_GARDEN_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY,
            STILL_GARDEN_KEY.getValue());



    public static void register(){
        CustomPortalBuilder.beginPortal()
                    .frameBlock(AllblocksRegister.PORTAL_FRAME)
                    .lightWithWater()
                    .destDimID(new Identifier("goldens_additions","still_garden"))
                    .tintColor(0,255,0)
                    .registerPortal();
    }



}
