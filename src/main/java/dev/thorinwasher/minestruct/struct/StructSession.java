package dev.thorinwasher.minestruct.struct;

import dev.thorinwasher.minestruct.vector.*;
import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.Instance;

public class StructSession {

    private final Struct struct;
    private final VectorOperationSequence operations;

    public StructSession(Struct struct) {
        this(struct, new VectorOperationSequence());
    }

    private StructSession(Struct struct, VectorOperationSequence vectorOperationSequence) {
        this.struct = struct;
        this.operations = new VectorOperationSequence();
    }

    public void rotate(RotationType rotation, Axis axis) {
        operations.add(new MatrixOperation(RotationUtil.getRotationMatrix(axis, rotation)));
    }

    public void flip(Axis flipAxis) {
        operations.add(new MatrixOperation(FlipUtil.getFlipMatrix(flipAxis)));
    }

    public void translate(Point translation) {
        operations.add(new Translation(translation));
    }

    public void paste(Instance instance) {
        struct.paste(instance, operations);
    }

    public StructSession copy() {
        StructSession structSession = new StructSession(struct);
        VectorOperationSequence vectorOperationSequence = structSession.operations.copy();
        return new StructSession(struct, vectorOperationSequence);
    }
}
