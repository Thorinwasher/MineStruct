package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import org.jetbrains.annotations.ApiStatus;

public interface VectorOperation {

    default Point operate(Point point) {
        int[][] operation = getOperation();
        int[] input = new int[]{point.blockX(), point.blockY(), point.blockZ()};
        int[] output = new int[3];
        for (int col = 0; col < operation.length; col++) {
            for (int row = 0; row < operation[col].length; row++) {
                 output[row] += operation[col][row] * input[row];
            }
        }
        return new Vec(output[0], output[1], output[2]);
    }

    @ApiStatus.Internal
    int[][] getOperation();
}
