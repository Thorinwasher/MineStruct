package dev.thorinwasher.minestruct.vector;

public class RotationUtil {

    public static Matrix3x3i getRotationMatrix(Axis axis, RotationType rotation){
        double radians = rotation.getRadians();
        return new Matrix3x3i(switch (axis) {
            case X -> getXRotation(radians);
            case Y -> getYRotation(radians);
            case Z -> getZRotation(radians);
        });
    }

    private static int[][] getZRotation(double radians) {
        return new int[][]{
                new int[]{cos(radians), -sin(radians), 0},
                new int[]{sin(radians), cos(radians), 0},
                new int[]{0, 0, 1}
        };
    }

    private static int[][] getYRotation(double radians) {
        return new int[][]{
                new int[]{cos(radians), 0, sin(radians)},
                new int[]{0, 1, 0},
                new int[]{-sin(radians), 0, cos(radians)}
        };
    }

    private static int[][] getXRotation(double radians) {
        return new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, cos(radians), -sin(radians)},
                new int[]{0, sin(radians), cos(radians)}
        };
    }

    private static int cos(double radians) {
        return (int) Math.round(Math.cos(radians));
    }

    private static int sin(double radians) {
        return (int) Math.round(Math.sin(radians));
    }
}
