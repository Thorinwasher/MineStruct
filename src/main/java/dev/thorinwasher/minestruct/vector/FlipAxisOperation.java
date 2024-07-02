package dev.thorinwasher.minestruct.vector;

import dev.thorinwasher.minestruct.MineStruct;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FlipAxisOperation implements VectorOperation {

    private static final int[][] X_AXIS_FLIP = loadMatrix("/matrices/xFlip.matrix");
    private static final int[][] Y_AXIS_FLIP = loadMatrix("/matrices/yFlip.matrix");
    private static final int[][] Z_AXIS_FLIP = loadMatrix("/matrices/zFlip.matrix");

    private final Object operation;


    public FlipAxisOperation(Axis axis) {
        this.operation = switch (axis) {
            case X -> X_AXIS_FLIP;
            case Y -> Y_AXIS_FLIP;
            case Z -> Z_AXIS_FLIP;
        };
    }

    @Override
    public int[][] getOperation() {
        return new int[0][];
    }

    private static int[][] loadMatrix(String fileName) {
        int[][] output = new int[][]{new int[3], new int[3], new int[3]};
        try (InputStream inputStream = MineStruct.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("Could not find internal file: " + fileName);
            }
            Scanner scanner = new Scanner(inputStream);
            int row = 0;
            while (scanner.hasNext()) {
                String[] lineSplit = scanner.nextLine().split(" ");
                for (int col = 0; col < lineSplit.length; col++) {
                    output[col][row] = Integer.parseInt(lineSplit[col]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

}
