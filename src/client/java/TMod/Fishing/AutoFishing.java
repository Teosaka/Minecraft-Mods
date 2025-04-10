package TMod.Fishing;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;

public class AutoFishing {

    public static int recastRod = -1;

    public static void tick(MinecraftClient client) {
        if (recastRod > 0) {
            recastRod--;
        }

        if (recastRod == 0 && client.player != null && client.interactionManager != null) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            recastRod = -1;
        }
    }

    public static void setRecastRod(int countdown) {
        recastRod = countdown;
    }
}