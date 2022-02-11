package Core.module5.qa_1;

public class Screwdriver extends Tool {

    public Screwdriver() {
    }

    public Screwdriver(Tool tool) {
        super(tool);
    }

    @Override
    public void work() {
        System.out.println("звук отвертки");
        super.work();
    }
}
