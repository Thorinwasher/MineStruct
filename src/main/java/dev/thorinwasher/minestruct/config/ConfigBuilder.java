package dev.thorinwasher.minestruct.config;

import net.minestom.server.instance.block.Block;

public class ConfigBuilder {

    private GroundMaterialConfig groundMaterials = new DefaultGroundMaterialConfig(Block.GRAVEL);
    private boolean gravitySafeBuildings = false;
    private int maxHeightCompensation;
    private int maxWidthSmoothening;

    public ConfigBuilder enableGravitySafeBuildings(int maxHeightCompensation, int maxWidthSmoothening) {
        this.gravitySafeBuildings = true;
        this.maxHeightCompensation = maxHeightCompensation;
        this.maxWidthSmoothening = maxWidthSmoothening;
        return this;
    }

    public ConfigBuilder setGroundMaterials(GroundMaterialConfig groundMaterials){
        this.groundMaterials = groundMaterials;
        return this;
    }
}