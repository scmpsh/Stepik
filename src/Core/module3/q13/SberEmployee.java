package Core.module3.q13;

class SberEmployee extends Employee {
    //получает бонус по формуле средняя
    // сумма среднего заработка за последний год (profits)
    // * 1.3 (коэф успешности банка)
    // * коэффициент оценки
    //todo

    private static final double RATING = 1.3;
    private double personalRating;

    public SberEmployee(int[] profits, double personalRating) {
        super(profits);
        this.personalRating = personalRating;
    }

    @Override
    public int getBonus() {
        return (int) (super.getBonus() * RATING * personalRating);
    }
}

