package TMod.Planting.mixin.client;

import TMod.example.TestMod;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static TMod.SharedVariables.shouldCropWalk;

@Mixin(ClientPlayerEntity.class)
public class WalkPlantingMixin {

    @Inject(at = @At("TAIL"), method="move")
    public void move(MovementType type, Vec3d movement, CallbackInfo ci) {
        //TestMod.TESTLOGGER.info("TRAVELLING");
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.interactionManager != null && shouldCropWalk) {
            Entity entity = (Entity) (Object) this;
            Vec3d pos = entity.getPos();
            World world = entity.getWorld();
            BlockPos blockPos = BlockPos.ofFloored(pos.x, pos.y - 0.1, pos.z);
            //TESTLOGGER.info(world.getBlockState(blockPos).getBlock().getName().toString());
            BlockHitResult hit = new BlockHitResult(blockPos.toCenterPos(), Direction.UP, blockPos, false);
            if (world.getBlockState(blockPos).getBlock() instanceof FarmlandBlock) {
                //TestMod.TESTLOGGER.info("IS FARMLAND");
                client.interactionManager.interactBlock(client.player, Hand.OFF_HAND, hit);
            }
        }
    }
}
