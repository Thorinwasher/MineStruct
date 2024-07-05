package dev.thorinwasher.minestruct.vector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationUtilTest {
    @ParameterizedTest
    @EnumSource
    void getRotationMatrixX(RotationType rotationType) {
        Matrix3x3i matrix3x3i = RotationUtil.getRotationMatrix(Axis.X, rotationType);
        assertEquals(1, matrix3x3i.determinant());
    }

    @ParameterizedTest
    @EnumSource
    void getRotationMatrixY(RotationType rotationType) {
        Matrix3x3i matrix3x3i = RotationUtil.getRotationMatrix(Axis.Y, rotationType);
        assertEquals(1, matrix3x3i.determinant());
    }

    @ParameterizedTest
    @EnumSource
    void getRotationMatrixZ(RotationType rotationType) {
        Matrix3x3i matrix3x3i = RotationUtil.getRotationMatrix(Axis.Z, rotationType);
        assertEquals(1, matrix3x3i.determinant());
    }
}