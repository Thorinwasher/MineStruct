package dev.thorinwasher.minestruct.struct;

import dev.thorinwasher.minestruct.vector.BoundingBox;
import net.hollowcube.schem.Schematic;

public class SimpleStruct implements Struct {

    private final Schematic schematic;
    private final BoundingBox boundingBox;

    public SimpleStruct(Schematic schematic) {
        this.schematic = schematic;
        this.boundingBox = BoundingBox.from(schematic);
    }
}
