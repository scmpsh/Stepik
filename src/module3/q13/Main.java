package module3.q13;

public class Main {

    public static void printSalary(Employee employee) {
        System.out.print("зп");
        for (int i = 0; i < employee.getProfits().length; i++) {
            System.out.print(" " + employee.getProfits()[i]);
        }
        System.out.println();
        System.out.println("бонус " + employee.getBonus());
    }

    public static void main(String[] args) {

        int[] profits = new int[] {
                110000,
                115000,
                120000,
                100000,
                100000,
                1260000,
                100000,
                100000,
                125000,
                100000,
                100000,
                100000,
                123123,
                123122
        };

        Employee[] employees = new Employee[] {
                new SberEmployee(profits, 3.5),
                new EpamEmployee(profits),
                new QIWIEmployee(profits, true)
        };
        for (Employee employee : employees) {
            printSalary(employee);
        }
    }
}
