package TMod.Xray.mixin.client;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static TMod.SharedVariables.shouldXray;
import static TMod.Xray.mixin.XrayBlocks.doNotXray;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class LightBlocks {
    @Inject(method = "getLuminance", at = @At("HEAD"), cancellable = true)
    private void getLuminance(CallbackInfoReturnable<Integer> cir) {
        BlockState self = (BlockState) (Object) this;
        if (shouldXray && doNotXray.contains(self.getBlock())) {
            cir.setReturnValue(15);
        }
    }
}
