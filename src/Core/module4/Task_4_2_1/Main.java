package Core.module4.Task_4_2_1;

import java.util.Random;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Random random = new Random();

    static class RobotConnect implements RobotConnection {

        @Override
        public void moveRobotTo(int x, int y) {
//            throw new IllegalArgumentException();
        }

        @Override
        public void close() {
            System.out.println("close");
        }

    }

    static class RobotConnectManager implements RobotConnectionManager {

        @Override
        public RobotConnect getConnection() {
            RobotConnect robotConnect = null;
            boolean isConnect = random.nextBoolean();
            if (!isConnect) {
                System.out.println("No connection");
                throw new RobotConnectionException("Not connect");
            } else {
                System.out.println("There is a connection");
                robotConnect = new RobotConnect();
            }
            return robotConnect;
        }
    }

    interface RobotConnection extends AutoCloseable {

        void moveRobotTo(int x, int y);

        @Override
        void close();

    }

    interface RobotConnectionManager {

        RobotConnection getConnection();
    }

    static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }

    }

    public static void myPrint(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        final int THIRD_CONNECTION_TRY = 3;

        for (int i = 1; i <= THIRD_CONNECTION_TRY; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException e) {
                if (i == THIRD_CONNECTION_TRY) {
                    throw e;
                }
            }
        }

//        RobotConnection robotConnection = null;
//        for (int i = 0; i < 3; i++) {
//            try {
//                robotConnection = robotConnectionManager.getConnection();
//                robotConnection.moveRobotTo(toX, toY);
//                i += 5;
//            } catch (RobotConnectionException e) {
//                if (i == 2) {
//                    throw e;
//                }
//                throw e;
//            } finally {
//                throw new RuntimeException();
//                try {
//                    if (robotConnection != null) {
//                        robotConnection.close();
//                    }
//                } catch (Exception e) {
//
//                }
//            }
//        }
    }

    public static void main(String[] args){
        RobotConnectManager robotConnectManager = new RobotConnectManager();
        for (int i = 1; i < 10; i++) {
            System.out.println(ANSI_GREEN + i + " try" + ANSI_RESET);
            moveRobot(robotConnectManager, 10, 20);
        }
    }
}
