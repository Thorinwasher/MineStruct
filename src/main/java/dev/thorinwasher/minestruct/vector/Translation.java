package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;

public class Translation implements VectorOperation{

    private final Point offset;

    public Translation(int x, int y, int z){
        this.offset = new Vec(x,y,z);
    }

    @Override
    public Point operate(Point point) {
        return point.add(offset);
    }
}
