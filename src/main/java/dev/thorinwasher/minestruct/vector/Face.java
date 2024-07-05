package dev.thorinwasher.minestruct.vector;

import java.util.Locale;

public enum Face {

    CEILING,
    FLOOR,
    WALL;

    public static Face fromFace(String face) {
        return Face.valueOf(face.toUpperCase(Locale.ROOT));
    }

    public String toFace() {
        return name().toLowerCase(Locale.ROOT);
    }

    public Face opposite() {
        return switch (this) {
            case WALL -> CEILING;
            case FLOOR -> FLOOR;
            case CEILING -> WALL;
        };
    }
}
