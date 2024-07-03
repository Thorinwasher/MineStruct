package dev.thorinwasher.minestruct.vector;

public enum RotationType {
    NONE(0),
    ANTI_CLOCKWISE_90(Math.PI/2),
    ANTI_CLOCKWISE_180(Math.PI),
    ANTI_CLOCKWISE_270(Math.PI*3/2);

    double radians;

    RotationType(double radians){
        this.radians = radians;
    }

    public double getRadians(){
        return radians;
    }
}
