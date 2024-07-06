package dev.thorinwasher.minestruct.vector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipUtilTest {

    @ParameterizedTest
    @EnumSource
    void getFlipMatrix(Axis axis) {
        assertEquals(-1, FlipUtil.getFlipMatrix(axis).determinant());
    }

}