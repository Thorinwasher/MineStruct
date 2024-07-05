package dev.thorinwasher.minestruct.struct;

import dev.thorinwasher.minestruct.vector.BoundingBox;
import dev.thorinwasher.minestruct.vector.VectorOperation;
import net.hollowcube.schem.Rotation;
import net.hollowcube.schem.Schematic;
import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.Instance;

public class SimpleStruct implements Struct {

    private final Schematic schematic;
    private final BoundingBox boundingBox;

    public SimpleStruct(Schematic schematic) {
        this.schematic = schematic;
        this.boundingBox = BoundingBox.from(schematic);
    }

    public BoundingBox boundingBox(VectorOperation vectorOperation) {
        return boundingBox.applyOperation(vectorOperation);
    }

    @Override
    public void paste(Instance instance, VectorOperation vectorOperation) {
        schematic.apply(Rotation.NONE, (point, block) -> {
            Point destinationPoint = vectorOperation.operate(point);
            instance.setBlock(destinationPoint, block);
        });
    }
}
