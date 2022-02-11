package Core.module3.static_block;

public class StaticBlock {

    public static int staticVariable;
    public int nonStaticVariable;

    public StaticBlock(int nonStaticVariable, int staticVar) {
        this.nonStaticVariable = nonStaticVariable;
        staticVariable = staticVar;
    }

    public StaticBlock() {
        System.out.print("");
    }

    static {
        System.out.println("Static initalization.");
        staticVariable = 5;
    }

    {
        System.out.println("Instance initialization.");
        nonStaticVariable = 7;
    }

    public int getNonStaticVariable() {
        return nonStaticVariable;
    }

    public static void main(String[] args) {
        System.out.println("non static = " + new StaticBlock().getNonStaticVariable());
        System.out.println("static = " + staticVariable);
        System.out.println();
        System.out.println("non static = " + new StaticBlock().getNonStaticVariable());
        System.out.println("static = " + staticVariable);
    }
}
