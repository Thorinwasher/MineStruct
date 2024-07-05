package dev.thorinwasher.minestruct.vector;

import com.google.gson.JsonArray;
import net.minestom.server.coordinate.Point;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix3x3i {


    private final int[][] matrix;

    public Matrix3x3i(int[][] matrix) {
        this.matrix = matrix;
    }


    public Point multiply(Point point) {
        return multiply(Vector3i.from(point)).point();
    }

    public Matrix3x3i multiply(Matrix3x3i other) {
        int[][] output = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++)
                    output[i][j] += other.matrix[i][k] * matrix[k][j];
            }
        }
        return new Matrix3x3i(output);
    }

    public Vector3i multiply(Vector3i vector3i) {
        int[] input = new int[]{vector3i.x(), vector3i.y(), vector3i.z()};
        int[] output = new int[3];
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                output[row] += matrix[col][row] * input[col];
            }
        }
        return new Vector3i(output[0], output[1], output[2]);
    }

    public static Matrix3x3i read(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int row = 0;
        int[][] output = new int[][]{new int[3], new int[3], new int[3]};
        while (scanner.hasNext()) {
            String[] lineSplit = scanner.nextLine().split(" ");
            for (int col = 0; col < lineSplit.length; col++) {
                output[col][row] = Integer.parseInt(lineSplit[col]);
            }
        }
        return new Matrix3x3i(output);
    }

    public static Matrix3x3i fromJson(JsonArray jsonArray) {
        int[][] out = new int[3][3];
        for (int col = 0; col < 3; col++) {
            JsonArray colArray = (JsonArray) jsonArray.get(col);
            for (int row = 0; row < 3; row++) {
                out[row][col] = colArray.get(row).getAsInt();
            }
        }
        return new Matrix3x3i(out);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Matrix3x3i matrix3x3i)) {
            return false;
        }
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                if (matrix3x3i.matrix[col][row] != matrix[col][row]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        return "Matrix3x3i" + Arrays.deepToString(matrix);
    }

    public int determinant() {
        int x = (matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]));
        int y = (matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]));
        int z = (matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]));
        return x - y + z;
    }
}
