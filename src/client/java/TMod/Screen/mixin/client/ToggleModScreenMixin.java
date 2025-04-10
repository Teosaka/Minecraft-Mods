package TMod.Screen.mixin.client;

import TMod.Screen.ToggleScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class ToggleModScreenMixin {
    @Inject(at = @At("HEAD"), method = "init")
    private void init(CallbackInfo ci) {
        GameMenuScreen menu = (GameMenuScreen) (Object) this;

        // Create a button at the top-left corner
        ButtonWidget testButton = ButtonWidget.builder(Text.of("Toggle Mods"), (button) -> {
            MinecraftClient.getInstance().setScreen(new ToggleScreen());
        }).width(100).position(10, 10).build();

        // Add the button to the menu using an accessor
        ((ScreenAccess) menu).callAddDrawableChild(testButton);
    }
}


