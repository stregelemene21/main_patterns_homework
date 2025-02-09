package homework1_module_tests;

import static java.lang.Double.isFinite;
import static java.lang.Math.sqrt;

public class SquareEquation {

    final double eps = Math.ulp(10);

    public double[] solveSquareRoot(double a, double b, double c) {
        checkNonDigitParams(a, b, c);
        checkThatParamAIsNotNull(a);

        double discr = findDiscr(a, b, c);

        if (discr > 0 && discr > eps) {
            return solveWhenDiscrMoreThanZero(a, b, discr);

        } else if (discr > 0 && discr < eps) {
            return solveWhenDiscrMoreThanZeroAndLessThanEps(a, b, discr);

        } else if (assertWithZero(discr)) {
            return solveWhenDiscrEqualsZero(a, b);
        } else {
            return new double[0];
        }
    }

    private double[] solveWhenDiscrMoreThanZero(double a, double b, double discr) {
        var x1 = (-b - sqrt(discr)) / (2 * a);
        var x2 = (-b + sqrt(discr)) / (2 * a);
        return new double[]{x1, x2};
    }

    private double[] solveWhenDiscrMoreThanZeroAndLessThanEps(double a, double b, double discr) {
        var x1 = (-b - sqrt(discr)) / (2 * a);
        var x2 = (-b + sqrt(discr)) / (2 * a);
        return new double[]{x1, x2};
    }

    private double[] solveWhenDiscrEqualsZero(double a, double b) {
        var x = -b / (2 * a);
        return new double[]{x};
    }

    private void checkThatParamAIsNotNull(double a) {
        if (assertWithZero(a)) {
            throw new IllegalArgumentException("Коэффициент a не может быть равен 0!");
        }
    }

    private void checkNonDigitParams(double a, double b, double c) {
        if (!isFinite(a) || !isFinite(b) || !isFinite(c)) {
            throw new IllegalArgumentException("Коэффициент должен быть числом!");
        }
    }

    private double findDiscr(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    private boolean assertWithZero(double param) {
        return Double.compare(param, 0) == 0 && Math.abs(param - 0) < eps;
    }
}
