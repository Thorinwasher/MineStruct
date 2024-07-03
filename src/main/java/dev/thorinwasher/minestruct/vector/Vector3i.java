package dev.thorinwasher.minestruct.vector;

import com.google.gson.JsonArray;
import net.minestom.server.coordinate.Point;
import net.minestom.server.coordinate.Vec;

public record Vector3i(int x, int y, int z) {

    public static Vector3i from(Point point) {
        int x = point.blockX();
        int y = point.blockY();
        int z = point.blockZ();
        return new Vector3i(x, y, z);
    }

    public Point point() {
        return new Vec(x(), y(), z());
    }

    public static Vector3i fromJson(JsonArray array) {
        int x = array.get(0).getAsInt();
        int y = array.get(1).getAsInt();
        int z = array.get(2).getAsInt();
        return new Vector3i(x, y, z);
    }
}
