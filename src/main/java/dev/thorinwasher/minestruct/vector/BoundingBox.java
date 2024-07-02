package dev.thorinwasher.minestruct.vector;

import net.hollowcube.schem.Schematic;
import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;

import java.util.function.Predicate;

public record BoundingBox(int x1, int x2, int y1, int y2, int z1, int z2) {

    public BoundingBox() {
        this(0, 0, 0, 0, 0, 0);
    }

    public static BoundingBox from(Point point1, Point point2) {
        int x1 = Math.min(point2.blockX(), point1.blockX());
        int x2 = Math.max(point2.blockX(), point1.blockX());
        int y1 = Math.min(point2.blockY(), point1.blockY());
        int y2 = Math.max(point2.blockY(), point1.blockY());
        int z1 = Math.min(point2.blockZ(), point1.blockZ());
        int z2 = Math.max(point2.blockZ(), point1.blockZ());
        return new BoundingBox(x1, x2, y1, y2, z1, z2);
    }

    public static BoundingBox from(Schematic schematic) {
        Point size = schematic.size();
        Point offset = schematic.offset();
        Point max = size.add(offset);
        return from(max, offset);
    }

    public BoundingBox addPoint(Point point) {
        int x1 = Math.min(x1(), point.blockX());
        int x2 = Math.max(x2(), point.blockX());
        int y1 = Math.min(y1(), point.blockY());
        int y2 = Math.max(y2(), point.blockY());
        int z1 = Math.min(z1(), point.blockZ());
        int z2 = Math.max(z2(), point.blockZ());
        return new BoundingBox(x1, x2, y1, y2, z1, z2);
    }

    public BoundingBox combine(BoundingBox boundingBox) {
        int x1 = Math.min(x1(), boundingBox.x1());
        int x2 = Math.max(x2(), boundingBox.x2());
        int y1 = Math.min(y1(), boundingBox.y1());
        int y2 = Math.max(y2(), boundingBox.y2());
        int z1 = Math.min(z1(), boundingBox.z1());
        int z2 = Math.max(z2(), boundingBox.z2());
        return new BoundingBox(x1, x2, y1, y2, z1, z2);
    }

    public BoundingBox applyOperation(VectorOperation vectorOperation) {
        Point point1 = new Vec(x1, y1, z1);
        Point point2 = new Vec(x2, y2, z2);
        Point transformedPoint1 = vectorOperation.operate(point1);
        Point transformedPoint2 = vectorOperation.operate(point2);
        return from(transformedPoint1, transformedPoint2);
    }

    public boolean insideBox(Instance instance, Predicate<Block> filter) {
        return false;
    }

    public BoundingBox expandAllDirections(int blocks) {
        return new BoundingBox(x1 - blocks, x2 + blocks, y1 - blocks, y2 + blocks, z1 - blocks, z2 + blocks);
    }

    public Point size() {
        return maxPoint().sub(minPoint());
    }

    public Point minPoint() {
        return new Vec(x1, y1, z1);
    }

    public Point maxPoint() {
        return new Vec(x2, y2, z2);
    }
}
