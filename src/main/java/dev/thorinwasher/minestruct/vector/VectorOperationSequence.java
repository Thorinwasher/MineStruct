package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.block.Block;

import java.util.ArrayList;
import java.util.List;

public class VectorOperationSequence implements VectorOperation {

    private final List<VectorOperation> operations = new ArrayList<>();

    public VectorOperationSequence(List<VectorOperation> vectorOperations) {
        for(VectorOperation vectorOperation : vectorOperations){
            this.add(vectorOperation);
        }
    }

    public VectorOperationSequence() {
        // NO-OP, operations is empty array list now
    }

    @Override
    public Point operate(Point point) {
        Point output = point;
        for (VectorOperation vectorOperation : operations) {
            output = vectorOperation.operate(output);
        }
        return output;
    }

    @Override
    public Block operate(Block block) {
        Block output = block;
        for(VectorOperation vectorOperation : operations){
            output = vectorOperation.operate(output);
        }
        return output;
    }

    public void add(VectorOperation vectorOperation) {
        if (operations.isEmpty()) {
            operations.add(vectorOperation);
            return;
        }
        VectorOperation previous = operations.getLast();
        if (!(previous instanceof MatrixOperation matrixOperation1) || !(vectorOperation instanceof MatrixOperation matrixOperation2)) {
            operations.add(vectorOperation);
            return;
        }
        operations.set(operations.size() - 1, new MatrixOperation(matrixOperation1.getMatrix().multiply(matrixOperation2.getMatrix())));
    }

    public VectorOperationSequence copy() {
        return new VectorOperationSequence(new ArrayList<>(operations));
    }

    @Override
    public String toString(){
        return "Sequence" + operations;
    }
}
