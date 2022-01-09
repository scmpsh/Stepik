package module3.q13;

class QIWIEmployee extends Employee {
    //получают 8 окладов в случае если работник выполнил критически важную фичу
    //todo

    private boolean doneFeature;

    public QIWIEmployee(int[] profits, boolean doneFeature) {
        super(profits);
        this.doneFeature = doneFeature;
    }

    @Override
    public int getBonus() {
        if (doneFeature) {
            return super.getBonus() * 8;
        }
        return 0;
    }
}

