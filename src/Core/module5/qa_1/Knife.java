package Core.module5.qa_1;

public class Knife extends Tool {

    public Knife() {
    }

    public Knife(Tool tool) {
        super(tool);
    }

    @Override
    public void work() {
        System.out.println("звук ножа");
        super.work();
    }
}
