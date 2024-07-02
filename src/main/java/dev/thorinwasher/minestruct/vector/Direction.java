package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Vec;

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

    public Vec vec() {
        return new Vec(x, y, z);
    }

    public Direction opposite(){
        return Direction.valueOf(opposite);
    }
}
