package dev.thorinwasher.minestruct.config;

import net.minestom.server.instance.block.Block;

public class StructureConfigBuilder {

    private GroundMaterialConfig groundMaterials = new DefaultGroundMaterialConfig(Block.GRAVEL);
    private boolean gravitySafeBuildings = false;
    private int maxHeightCompensation;
    private int maxWidthSmoothening;

    public StructureConfigBuilder enableGravitySafeBuildings(int maxHeightCompensation, int maxWidthSmoothening) {
        this.gravitySafeBuildings = true;
        this.maxHeightCompensation = maxHeightCompensation;
        this.maxWidthSmoothening = maxWidthSmoothening;
        return this;
    }

    public StructureConfigBuilder setGroundMaterials(GroundMaterialConfig groundMaterials){
        this.groundMaterials = groundMaterials;
        return this;
    }

    public StructureConfig build(){
        return new StructureConfig(gravitySafeBuildings, maxHeightCompensation, maxWidthSmoothening, groundMaterials);
    }
}