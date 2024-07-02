package dev.thorinwasher.minestruct.config;

import net.minestom.server.instance.block.Block;
import net.minestom.server.world.biome.Biome;

public interface GroundMaterialConfig {

    public Block getGroundMaterial(Biome biome);
}