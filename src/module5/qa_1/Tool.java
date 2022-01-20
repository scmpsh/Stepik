package module5.qa_1;

public abstract class Tool implements Workable {
    private String sound;

    public Tool(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
