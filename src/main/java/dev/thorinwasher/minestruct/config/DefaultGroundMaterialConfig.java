package dev.thorinwasher.minestruct.config;

import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

public class DefaultGroundMaterialConfig implements GroundMaterialConfig {

    private final Block defaultMaterial;

    public DefaultGroundMaterialConfig(Block defaultMaterial){
        this.defaultMaterial = defaultMaterial;
    }

    @Override
    public Block getGroundMaterial(Biome biome) {
        return defaultMaterial;
    }
}
