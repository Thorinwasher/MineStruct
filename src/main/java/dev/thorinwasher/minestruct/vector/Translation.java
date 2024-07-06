package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.block.Block;

public class Translation implements VectorOperation {

    private final Point offset;

    public Translation(int x, int y, int z) {
        this.offset = new Vec(x, y, z);
    }

    public Translation(Point point) {
        this(point.blockX(), point.blockY(), point.blockZ());
    }

    @Override
    public Point operate(Point point) {
        return point.add(offset);
    }

    @Override
    public Block operate(Block block) {
        return block;
    }

    @Override
    public String toString() {
        return String.format("Translation[%d,%d,%d]", offset.blockX(), offset.blockY(), offset.blockZ());
    }
}
