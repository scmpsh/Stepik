package Core.module5.qa_1;

public class Makita extends Tool {

    public Makita() {
    }

    public Makita(Tool tool) {
        super(tool);
    }

    @Override
    public void work() {
        System.out.println("звук макиты");
        super.work();
    }
}
