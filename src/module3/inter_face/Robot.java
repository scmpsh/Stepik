package module3.inter_face;

public class Robot implements RobotMove {

    @Override
    public void turnLeft() {
        System.out.println("turnLeft");
    }

    @Override
    public void turnRight() {
        System.out.println("turnRight");
    }

    @Override
    public void stepForward() {
        System.out.println("stepForward");
    }

    @Override
    public void stepBack() {
        System.out.println("stepBack");
    }

    public int stepBack(int fdf) {
        System.out.println("SSA");
        return fdf;
    }

    public static void main(String[] args) {
        new Robot().stepBack(6);

    }
}
