package dev.thorinwasher.minestruct.config;

import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

public record DefaultGroundMaterialConfig(Block defaultMaterial) implements GroundMaterialConfig {

    @Override
    public Block getGroundMaterial(Biome biome) {
        return defaultMaterial();
    }
}
