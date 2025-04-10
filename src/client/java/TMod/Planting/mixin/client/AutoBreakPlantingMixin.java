package TMod.Planting.mixin.client;

import TMod.example.TestMod;
import TMod.Planting.AutoBreakPlanting;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static TMod.SharedVariables.shouldCropBreak;

@Mixin (ClientPlayerInteractionManager.class)
public class AutoBreakPlantingMixin {

    private Block breakingBlock;

    @Inject(at = @At("HEAD"), method="breakBlock")
    public void beforeBreakBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        World world = client.player.getWorld();
        breakingBlock = world.getBlockState(pos).getBlock();
    }

    @Inject(at = @At("TAIL"), method="breakBlock")
    public void afterBreakBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        MinecraftClient client = MinecraftClient.getInstance();
        World world = client.player.getWorld();
        //TestMod.TESTLOGGER.info(breakingBlock.getName().toString());
        if (breakingBlock instanceof CropBlock && shouldCropBreak) {
            //TestMod.TESTLOGGER.info("IN IF");
            BlockHitResult hit = new BlockHitResult(pos.toCenterPos().subtract(0.0, 1.0, 0.0), Direction.UP, pos.offset(Direction.Axis.Y, -1), false);
            //TestMod.TESTLOGGER.info(pos.toCenterPos().subtract(0.0, 1.0, 0.0).toString());
            //TestMod.TESTLOGGER.info(world.getBlockState(pos.offset(Direction.Axis.Y, -1)).getBlock().getName().toString());
            //client.interactionManager.interactBlock(client.player, Hand.OFF_HAND, hit);
            AutoBreakPlanting.setBreakBlock(hit);
            AutoBreakPlanting.setRecastInteract(1);
        }
    }
}
