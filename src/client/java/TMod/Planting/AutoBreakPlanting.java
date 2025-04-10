package TMod.Planting;

import TMod.example.TestMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

public class AutoBreakPlanting {

    public static int delayInteract = -1;
    public static BlockHitResult hit;

    public static void tick(MinecraftClient client) {
        if (delayInteract > 0) {
            delayInteract--;
        }
        //TestMod.TESTLOGGER.info("TICK");
        if (delayInteract == 0 && client.player != null && client.interactionManager != null) {
            //TestMod.TESTLOGGER.info("IN TICK");
            client.interactionManager.interactBlock(client.player, Hand.OFF_HAND, hit);
            delayInteract = -1;
        }
    }

    public static void setRecastInteract(int countdown) {
        delayInteract = countdown;
    }

    public static void setBreakBlock(BlockHitResult breaking) {
        hit = breaking;
    }
}