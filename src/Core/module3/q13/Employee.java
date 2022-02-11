package Core.module3.q13;

public abstract class Employee {
    private int[] profits;

    public Employee(int[] profits) {
        this.profits = profits;
    }

    public int getBonus() {
        int result;

        result = 0;
        for (int i = 0; i < 12; i++) {
            result += getProfits()[i];
        }
        return (result / 12);
    }

    public int[] getProfits() {
        return profits;
    }
}


