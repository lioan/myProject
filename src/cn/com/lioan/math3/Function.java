package cn.com.lioan.math3;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class Function implements UnivariateDifferentiableFunction {
    @Override
    public DerivativeStructure value(DerivativeStructure t) throws DimensionMismatchException {
        return null;
    }

    @Override
    public double value(double x) {
        return Math.sin(x);
    }

    public UnivariateFunction derivative() {
        return new UnivariateFunction() {
            @Override
            public double value(double x) {
                return Math.cos(x);
            }
        };
    }

    public static void main(String[] args) {
        Function fsin = new Function();
        System.out.println(fsin.value(Math.PI / 2));
        System.out.println(fsin.derivative().value(Math.PI / 2));
    }
}
