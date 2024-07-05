package dev.thorinwasher.minestruct.config;

public record StructureConfig(boolean gravitySafe, int maxHeightCompensation, int maxWidthSmoothening, GroundMaterialConfig groundMaterialConfig) {


    public static StructureConfig empty(){
        return new StructureConfigBuilder().build();
    }
}