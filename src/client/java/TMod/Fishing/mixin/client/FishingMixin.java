package TMod.Fishing.mixin.client;

import TMod.Fishing.AutoFishing;
import TMod.Fishing.Fishing;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static TMod.SharedVariables.shouldAutoFish;

@Mixin(FishingBobberEntity.class)
public class FishingMixin {
    @Shadow
    private boolean caughtFish;
    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (caughtFish && shouldAutoFish) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            AutoFishing.setRecastRod(5);
            Fishing.log("Caught A Fish");
        }

    }
}