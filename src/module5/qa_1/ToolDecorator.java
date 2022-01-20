package module5.qa_1;

public class ToolDecorator implements Workable {
    private Tool tool;
    private String sound;

    public ToolDecorator(Tool tool, String sound) {
        this.tool = tool;
        this.sound = sound;
    }

    @Override
    public void work() {
        System.out.println(this.sound);
        System.out.println(tool.getSound());
    }
}
