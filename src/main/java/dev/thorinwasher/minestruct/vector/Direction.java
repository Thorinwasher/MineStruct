package dev.thorinwasher.minestruct.vector;

import java.util.Locale;

public enum Direction {

    UP(0, 1, 0, "DOWN"),
    DOWN(0, -1, 0, "UP"),
    EAST(1, 0, 0, "WEST"),
    WEST(-1, 0, 0, "EAST"),
    NORTH(0, 0, 1, "SOUTH"),
    SOUTH(0, 0, -1, "NORTH");


    private final int x;
    private final int y;
    private final int z;
    private final String opposite;

    Direction(int x, int y, int z, String opposite) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.opposite = opposite;
    }

    public Vector3i direction() {
        return new Vector3i(x, y, z);
    }

    public Direction opposite() {
        return Direction.valueOf(opposite);
    }

    public String toFacing() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static Direction fromFacing(String facing) {
        return Direction.valueOf(facing.toUpperCase(Locale.ROOT));
    }

    public static Direction fromVector(Vector3i vector3i) {
        for (Direction direction : Direction.values()) {
            if(direction.direction().equals(vector3i)){
                return direction;
            }
        }
        throw new IllegalArgumentException("Expected axial vector of length 1");
    }
}
