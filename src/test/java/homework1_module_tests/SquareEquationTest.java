package homework1_module_tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Homework1")
public class SquareEquationTest {
    SquareEquation solve = new SquareEquation();

    @Test
    void solveWhenNoSquareRootsTest() {
        double a = 1;
        double b = 0;
        double c = 1;
        assertEquals(
                solve.solveSquareRoot(a, b, c).length, 0);
    }

    @Test
    void solveWhenTwoSquareRootsTest() {
        double a = 1;
        double b = 0;
        double c = -1;
        var expectedRoots = new double[]{-1, 1};
        assertArrayEquals(solve.solveSquareRoot(a, b, c), expectedRoots);
    }

    @Test
        // D == 0 - один корень кратности 2
    void solveWhenOneSquareRootTest() {
        double a = 1;
        double b = 2;
        double c = 1;
        var expectedRoots = new double[]{-1};
        assertArrayEquals(solve.solveSquareRoot(a, b, c), expectedRoots);
    }

    @Test
        // D < 0 - исключение
    void solveWhenParamAEqualsZeroTest() {
        double a = 0;
        double b = 2;
        double c = 1;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));
    }

    @Test
        // 0 < D < eps  - один корень кратности 2
    void solveOneSquareRootWhenDiscrLessThanEpsilonTest() {
        double a = 1;
        double b = 2.0000001;
        double c = 1.0000001;
        var eps = solve.eps;
        double expectedRoot = -1;
        var actualRoots = solve.solveSquareRoot(a, b, c);
        Arrays.stream(actualRoots)
                .forEach(root ->
                        assertTrue(Math.abs(expectedRoot - root) < eps));
    }

    // Когда один или более коэффициентов - не числа
    @Test
    void solveWhenParamAIsNotDigit() {
        double a = NaN;
        double b = 1;
        double c = -1;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));
    }

    @Test
    void solveWhenParamBIsNotDigit() {
        double a = 1;
        double b = NaN;
        double c = 1;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));
    }

    @Test
    void solveWhenParamCIsNotDigit() {
        double a = 1;
        double b = 2;
        double c = NaN;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));
    }

    @Test
    void solveWhenAllParamsAreNotDigit() {
        double a = NaN;
        double b = NEGATIVE_INFINITY;
        double c = POSITIVE_INFINITY;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));

    }

    @Test
    void solveWhenABParamsAreNotDigit() {
        double a = NEGATIVE_INFINITY;
        double b = POSITIVE_INFINITY;
        double c = 1;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));

    }

    @Test
    void solveWhenBCParamsAreNotDigit() {
        double a = 1;
        double b = NaN;
        double c = NEGATIVE_INFINITY;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));

    }

    @Test
    void solveWhenACParamsAreNotDigit() {
        double a = NaN;
        double b = 2.0;
        double c = NaN;
        assertThrows(IllegalArgumentException.class, () -> solve.solveSquareRoot(a, b, c));
    }
}
