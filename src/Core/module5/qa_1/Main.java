package Core.module5.qa_1;

public class Main {
    public static void main(String[] args) {
        Workable workable = new Knife(new Screwdriver(new Nailer(new Makita())));
        workable.work();
    }
}
