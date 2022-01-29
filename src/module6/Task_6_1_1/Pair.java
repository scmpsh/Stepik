package module6.Task_6_1_1;

import java.util.Objects;

class Pair<I, S> {
    private I first;
    private S second;

    public Pair(I first, S second) {
        this.first = first;
        this.second = second;
    }

    static <I, S> Pair<I, S> of(I first, S second) {
        return new Pair<>(first, second);
    }

    public I getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        if (pair.first == null && this.first == null
                && pair.second == null && this.second == null) {
            return true;
        } else if (pair.first == null || this.first == null
                || pair.second == null || this.second == null) {
            return false;
        }
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, null);
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }
}
