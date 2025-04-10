package TMod.Xray.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static TMod.SharedVariables.shouldXray;
import static TMod.Xray.mixin.XrayBlocks.doNotXray;
import static TMod.Xray.mixin.XrayBlocks.toXray;

@Mixin(Block.class)
public class Xray {

    @Inject(at = @At("HEAD"), method="shouldDrawSide", cancellable = true)
    private static void shouldDrawSide(BlockState state, BlockState otherState, Direction side, CallbackInfoReturnable<Boolean> cir) {
        if (toXray.contains(state.getBlock()) && shouldXray) {
            cir.setReturnValue(false);
        }
        if (doNotXray.contains(state.getBlock()) && shouldXray) {
            cir.setReturnValue(true);
        }
    }
}
