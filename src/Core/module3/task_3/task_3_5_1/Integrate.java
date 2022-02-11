package Core.module3.task_3.task_3_5_1;

import java.util.function.DoubleUnaryOperator;

public class Integrate {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double step = 1000000;
        double h = (b - a) / (step - 1);
        double sum = 1.0 / 3.0 * (f.applyAsDouble(a) + f.applyAsDouble(b));

        for (int i = 1; i < step - 1; i += 2) {
            double x = a + h * i;
            sum += 4.0 / 3.0 * f.applyAsDouble(x);
        }
        for (int i = 2; i < step - 1; i += 2) {
            double x = a + h * i;
            sum += 2.0 / 3.0 * f.applyAsDouble(x);
        }
        return sum * h;
    }

    //implementation by a regular class
    private static class DBLImple implements DoubleUnaryOperator {
        @Override
        public double applyAsDouble(double x) {
            return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
        }
    }

    //anonymous class implementation
    private final DoubleUnaryOperator dblOp = new DoubleUnaryOperator() {
        @Override
        public double applyAsDouble(double x) {
            return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
        }
    };

    //lambda
    private final DoubleUnaryOperator dblLambda_1 = x -> {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    };

    public static void main(String[] args) {

        final Integrate obj = new Integrate();
        final DBLImple dblObj = new DBLImple();
        double a = -3, b = 3;

        System.out.println("Regular class   ->  " + integrate(dblObj, a, b));
        System.out.println("Anonymous class ->  " + integrate(obj.dblOp, a, b));
        System.out.println("Lambda          ->  " + integrate(obj.dblLambda_1, a, b));
    }
}
