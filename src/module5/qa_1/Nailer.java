package module5.qa_1;

public class Nailer extends Tool {

    public Nailer() {
    }

    public Nailer(Tool tool) {
        super(tool);
    }

    @Override
    public void work() {
        System.out.println("звук гвоздодера");
        super.work();
    }
}
