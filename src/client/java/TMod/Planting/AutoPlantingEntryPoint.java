package TMod.Planting;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AutoPlantingEntryPoint implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        /*
        Lambda function passing in MinecraftClient client to AutoFishing
        END_CLIENT_TICK for passing in at the end of the minecraft tick
         */
        ClientTickEvents.END_CLIENT_TICK.register(client -> AutoBreakPlanting.tick(client));
    }
}