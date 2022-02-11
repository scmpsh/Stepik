package Core.module4.Task_4_1_2;

public class Task {

    /**
     * @return commision or
     * -1
     * when money < 0,
     * -2
     * when percent < 0
     **/

    public static class NegativeMoneyException extends RuntimeException {

    }

    public static class NegativePercentException extends RuntimeException {

    }

//    public static double calculateComision(double money, int percent) {
//        if (money < 0) {
//            return -1;
//        }
//        if (percent < 0) {
//            return -2;
//        }
//        return money * percent / 100;
//    }

    public static double calculateComision(double money, int percent) {
        if (money < 0) {
            throw new NegativeMoneyException();
        }
        if (percent < 0) {
            throw new NegativePercentException();
        }
        return money * percent / 100;
    }

    public static void main(String[] args) {
        double v = calculateComision(2.0, -23);

        System.out.println(v);
//        System.out.println(getCallerClassAndMethodName());
//        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] tracer;
        tracer = new Throwable().getStackTrace();
        if (tracer.length > 2) {
            return tracer[2].getClassName() + "#" + tracer[2].getMethodName();
        } else {
            return null;
        }
    }
}
