package dev.thorinwasher.minestruct.vector;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.block.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatrixOperation implements VectorOperation {

    private final Matrix3x3i matrix;
    private final boolean flipsX;
    private final boolean flipsY;
    private final boolean flipsZ;

    public MatrixOperation(Matrix3x3i matrix) {
        this.matrix = matrix;
        this.flipsX = flipsDirection(Direction.EAST);
        this.flipsY = flipsDirection(Direction.UP);
        this.flipsZ = flipsDirection(Direction.NORTH);
    }

    @Override
    public Point operate(Point point) {
        return matrix.multiply(point);
    }

    @Override
    public Block operate(Block block) {
        Block modifiedBlock = Optional.ofNullable(block.getProperty("facing"))
                .map(Direction::fromFacing)
                .map(Direction::direction)
                .map(matrix::multiply)
                .map(Direction::fromVector)
                .map(Direction::toFacing)
                .map(facing ->
                        block.withProperty("facing", facing)
                ).orElse(block);
        if (flipsY) {
            final Block temp = modifiedBlock;
            modifiedBlock = Optional.ofNullable(block.getProperty("face"))
                    .map(Face::fromFace)
                    .map(Face::opposite)
                    .map(Face::toFace)
                    .map(face -> temp.withProperty("face", face))
                    .orElse(modifiedBlock);
        }
        List<Direction> availableDirections = List.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);
        List<Direction> currentDirections = new ArrayList<>();
        for (Direction direction : availableDirections) {
            Direction transFormedDirection = Direction.fromVector(matrix.multiply(direction.direction()));
            if(!availableDirections.contains(transFormedDirection)){
                continue;
            }
            Optional.ofNullable(modifiedBlock.getProperty(direction.toFacing()))
                    .filter(Boolean::parseBoolean)
                    .ifPresent((ignored) -> currentDirections.add(transFormedDirection));
        }
        if(!currentDirections.isEmpty()){
            for(Direction availableDirection : availableDirections){
                modifiedBlock = modifiedBlock.withProperty(availableDirection.toFacing(), "false");
            }
            for(Direction currentDirection : currentDirections){
                modifiedBlock = modifiedBlock.withProperty(currentDirection.toFacing(), "true");
            }
        }
        return modifiedBlock;
    }

    public Matrix3x3i getMatrix() {
        return matrix;
    }

    private boolean flipsDirection(Direction direction) {
        return matrix.multiply(direction.direction()).equals(direction.direction());
    }

    @Override
    public String toString(){
        return matrix.toString();
    }
}
