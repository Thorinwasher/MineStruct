package dev.thorinwasher.minestruct.vector;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.thorinwasher.json.JsonFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3x3iTest {

    @ParameterizedTest
    @JsonFileSource(resource = "/matrixMatrixOperationsTest.json")
    void multiplyMatrix(JsonObject jsonObject) {
        Matrix3x3i matrix1 = Matrix3x3i.fromJson(jsonObject.getAsJsonArray("first"));
        Matrix3x3i matrix2 = Matrix3x3i.fromJson(jsonObject.getAsJsonArray("second"));
        Matrix3x3i expected = Matrix3x3i.fromJson(jsonObject.getAsJsonArray("result"));
        Assertions.assertEquals(expected, matrix1.multiply(matrix2));
    }

    @ParameterizedTest
    @JsonFileSource(resource = "/matrixVectorOperationsTest.json")
    void testMultiplyVector(JsonObject jsonObject) {
        Matrix3x3i matrix1 = Matrix3x3i.fromJson(jsonObject.getAsJsonArray("first"));
        Vector3i vector3i = Vector3i.fromJson(jsonObject.getAsJsonArray("second"));
        Vector3i expected = Vector3i.fromJson(jsonObject.getAsJsonArray("result"));
        Assertions.assertEquals(expected, matrix1.multiply(vector3i));
    }
}