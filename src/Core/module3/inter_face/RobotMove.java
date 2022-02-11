package Core.module3.inter_face;

public interface RobotMove {
    void turnLeft();
    void turnRight();
    void stepForward();
    void stepBack();
    default void signal() {
        System.out.println("Cry");
    }
}
