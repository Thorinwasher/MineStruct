package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.block.Block;

public interface VectorOperation {

    static VectorOperation none() {
        return new VectorOperation() {
            @Override
            public Point operate(Point point) {
                return point;
            }

            @Override
            public Block operate(Block block) {
                return block;
            }
        };
    }

    Point operate(Point point);

    Block operate(Block block);
}
