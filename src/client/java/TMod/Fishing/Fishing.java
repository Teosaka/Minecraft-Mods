package TMod.Fishing;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Fishing {
    public static final MinecraftClient CLIENT = MinecraftClient.getInstance();

    /*
    Print out message into the minecraft chat. Overlay false if you want to see it
     */
    public static void log(String msg) {
        CLIENT.player.sendMessage(Text.of(msg), false);
    }
}
