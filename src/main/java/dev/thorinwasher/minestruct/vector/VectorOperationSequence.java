package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;

import java.util.ArrayList;
import java.util.List;

public class VectorOperationSequence implements VectorOperation {

    private final List<VectorOperation> operations;

    public VectorOperationSequence(List<VectorOperation> vectorOperations) {
        VectorOperation previousVectorOperation = null;
        operations = new ArrayList<>();
        for(VectorOperation vectorOperation : vectorOperations){
            if(previousVectorOperation instanceof MatrixOperation matrixOperation){
                if(vectorOperation instanceof MatrixOperation otherMatrixOperation){
                    previousVectorOperation = new MatrixOperation(matrixOperation.getMatrix().multiply(otherMatrixOperation.getMatrix()));
                    continue;
                } else {
                    operations.add(previousVectorOperation);
                }
            }
            if(!(vectorOperation instanceof MatrixOperation)) {
                operations.add(vectorOperation);
            }
            previousVectorOperation = vectorOperation;
        }
    }

    @Override
    public Point operate(Point point) {
        Point output = point;
        for(VectorOperation vectorOperation : operations){
            output = vectorOperation.operate(output);
        }
        return output;
    }
}
