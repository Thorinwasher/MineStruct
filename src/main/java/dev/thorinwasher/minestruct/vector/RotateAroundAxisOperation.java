package dev.thorinwasher.minestruct.vector;

public class RotateAroundAxisOperation implements VectorOperation {

    private final int[][] operation;

    public RotateAroundAxisOperation(Axis axis, double radians) {
        this.operation = switch (axis) {
            case X -> getXRotation(radians);
            case Y -> getYRotation(radians);
            case Z -> getZRotation(radians);
        };
    }

    private int[][] getZRotation(double radians) {
        return new int[][]{
                new int[]{cos(radians), -sin(radians), 0},
                new int[]{sin(radians), cos(radians), 0},
                new int[]{0, 0, 1}
        };
    }

    private int[][] getYRotation(double radians) {
        return new int[][]{
                new int[]{cos(radians), 0, sin(radians)},
                new int[]{0, 1, 0},
                new int[]{-sin(radians), 0, cos(radians)}
        };
    }

    private int[][] getXRotation(double radians) {
        return new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, cos(radians), -sin(radians)},
                new int[]{0, sin(radians), cos(radians)}
        };
    }

    private int cos(double radians) {
        return (int) Math.round(Math.cos(radians));
    }

    private int sin(double radians) {
        return (int) Math.round(Math.cos(radians));
    }

    @Override
    public int[][] getOperation() {
        return operation;
    }
}
