package TMod.Xray.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.HashSet;
import java.util.Set;

public class XrayBlocks {
    public static Set<Block> toXray = new HashSet<>(Set.of(
            Blocks.DIRT,
            Blocks.COBBLESTONE,
            Blocks.STONE,
            Blocks.SAND,
            Blocks.SANDSTONE,
            Blocks.ANDESITE,
            Blocks.DIORITE,
            Blocks.GRANITE,
            Blocks.NETHERRACK,
            Blocks.GRASS_BLOCK,
            Blocks.DEEPSLATE,
            Blocks.TUFF,
            Blocks.GRAVEL,
            Blocks.SHORT_GRASS,
            Blocks.TALL_GRASS
    ));
    public static Set<Block> doNotXray = new HashSet<>(Set.of(
            Blocks.COAL_ORE,
            Blocks.DEEPSLATE_COAL_ORE,
            Blocks.IRON_ORE,
            Blocks.DEEPSLATE_IRON_ORE,
            Blocks.COPPER_ORE,
            Blocks.DEEPSLATE_COPPER_ORE,
            Blocks.GOLD_ORE,
            Blocks.DEEPSLATE_GOLD_ORE,
            Blocks.REDSTONE_ORE,
            Blocks.DEEPSLATE_REDSTONE_ORE,
            Blocks.LAPIS_ORE,
            Blocks.DEEPSLATE_LAPIS_ORE,
            Blocks.DIAMOND_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE,
            Blocks.EMERALD_ORE,
            Blocks.DEEPSLATE_EMERALD_ORE,
            Blocks.CHEST,
            Blocks.SPAWNER,
            Blocks.LAVA,
            Blocks.ANCIENT_DEBRIS,
            Blocks.NETHER_QUARTZ_ORE,
            Blocks.NETHER_GOLD_ORE,
            Blocks.OBSIDIAN,
            Blocks.BEDROCK
    ));
}
