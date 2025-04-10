package TMod.Screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.text.Text;

import static TMod.SharedVariables.*;
import static TMod.example.TestMod.TESTLOGGER;

public class ToggleScreen extends Screen {

    public ToggleScreen() {
        super(Text.translatable("TOGGLE MOD"));
    }

    public void init() {
        MinecraftClient client = MinecraftClient.getInstance();
        super.init();
        GridWidget gridWidget = new GridWidget();
        gridWidget.getMainPositioner().margin(4, 4, 4, 0);
        GridWidget.Adder adder = gridWidget.createAdder(1);
        ButtonWidget AutoFishButton = ButtonWidget.builder(Text.of("Toggle AutoFish"), (button) -> {
            shouldAutoFish = !shouldAutoFish;
            TESTLOGGER.info(""+shouldAutoFish);
            client.player.sendMessage(Text.of("AutoFish set to "+shouldAutoFish), false);
        }).build();
        ButtonWidget AutoCropBreakButton = ButtonWidget.builder(Text.of("Toggle AutoCropBreak"), (button) -> {
            shouldCropBreak = !shouldCropBreak;
            TESTLOGGER.info(""+shouldCropBreak);
            client.player.sendMessage(Text.of("AutoCropBreak set to "+shouldCropBreak), false);
        }).build();
        ButtonWidget AutoCropWalkButton = ButtonWidget.builder(Text.of("Toggle AutoCropWalk"), (button) -> {
            shouldCropWalk = !shouldCropWalk;
            TESTLOGGER.info(""+shouldCropWalk);
            client.player.sendMessage(Text.of("AutoCropWalk set to "+shouldCropWalk), false);
        }).build();
        ButtonWidget XrayButton = ButtonWidget.builder(Text.of("Toggle Xray"), (button) -> {
            shouldXray = !shouldXray;
            TESTLOGGER.info(""+shouldXray);
            client.player.sendMessage(Text.of("Xray set to "+shouldXray), false);
            MinecraftClient.getInstance().worldRenderer.reload();
        }).build();
        adder.add(AutoFishButton);
        adder.add(AutoCropBreakButton);
        adder.add(AutoCropWalkButton);
        adder.add(XrayButton);
        gridWidget.refreshPositions();
        gridWidget.forEachChild(this::addDrawableChild);
    }
}
