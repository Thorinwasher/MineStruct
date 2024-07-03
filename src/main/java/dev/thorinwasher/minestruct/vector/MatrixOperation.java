package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Pos;

public class MatrixOperation implements VectorOperation {

    private final Matrix3x3i matrix;

    public MatrixOperation(Matrix3x3i matrix){
        this.matrix = matrix;
    }

    @Override
    public Point operate(Point point) {
        return matrix.multiply(point);
    }

    public Matrix3x3i getMatrix(){
        return matrix;
    }
}
