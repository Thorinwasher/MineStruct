package dev.thorinwasher.minestruct.vector;

import dev.thorinwasher.minestruct.MineStruct;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FlipUtil {

    private static final Matrix3x3i X_AXIS_FLIP = loadMatrix("/matrices/xFlip.matrix");
    private static final Matrix3x3i Y_AXIS_FLIP = loadMatrix("/matrices/yFlip.matrix");
    private static final Matrix3x3i Z_AXIS_FLIP = loadMatrix("/matrices/zFlip.matrix");

    public static Matrix3x3i getFlipMatrix(Axis axis){
        return switch (axis) {
            case X -> X_AXIS_FLIP;
            case Y -> Y_AXIS_FLIP;
            case Z -> Z_AXIS_FLIP;
        };
    }

    private static Matrix3x3i loadMatrix(String fileName) {
        try (InputStream inputStream = MineStruct.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("Could not find internal file: " + fileName);
            }
            return Matrix3x3i.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
