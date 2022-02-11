package Core.module3.task_3.task_3_3_1;

class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, -10, Direction.DOWN);
        moveRobot(robot, 0, -30);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    public static void step(Robot robot, int numberOfSteps) {
        for (int i = 0; i < numberOfSteps; i++) {
            robot.stepForward();
        }
    }

    public static void turn(Robot robot, Direction direction) {
        while (robot.getDirection() != direction) {
            robot.turnLeft();
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        if (robot.getX() < toX) {
            turn(robot, Direction.RIGHT);
        } else {
            turn(robot, Direction.LEFT);
        }
        step(robot, Math.abs(toX - robot.getX()));
        if (robot.getY() < toY) {
            turn(robot, Direction.UP);
        } else {
            turn(robot, Direction.DOWN);
        }
        step(robot, Math.abs(toY - robot.getY()));

        System.out.println(robot.getX() + " " + robot.getY());
    }
}
