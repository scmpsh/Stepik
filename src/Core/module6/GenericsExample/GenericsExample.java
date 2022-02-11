package Core.module6.GenericsExample;

public class GenericsExample<L, R> {
    private final L left;
    private final R right;

    public GenericsExample(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}
