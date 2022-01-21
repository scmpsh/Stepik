package module5.qa_1;

public abstract class Tool implements Workable {
    Tool tool;

    public Tool() {
    }

    public Tool(Tool tool) {
        this.tool = tool;
    }

    @Override
    public void work() {
        System.out.println("звук абстрактного инструмента");
    }
}