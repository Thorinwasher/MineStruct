package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.ApiStatus;

public interface VectorOperation {

    static VectorOperation none() {
        return point -> point;
    }

    Point operate(Point point);

    Block operate(Block block);
}
