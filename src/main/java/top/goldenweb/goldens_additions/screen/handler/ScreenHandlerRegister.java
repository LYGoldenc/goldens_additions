package top.goldenweb.goldens_additions.screen.handler;


import net.minecraft.screen.ScreenHandlerType;

public class ScreenHandlerRegister {
    public static ScreenHandlerType<PolymerizationMachineScreenHandler> POLYMERIZATION_MACHINE_HANDLER_SCREEN_HANDLER;

    public static void register(){
        POLYMERIZATION_MACHINE_HANDLER_SCREEN_HANDLER = new ScreenHandlerType<>(PolymerizationMachineScreenHandler::new);
    }


}
