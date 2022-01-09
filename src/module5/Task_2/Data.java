package module5.Task_2;

public class Data {
    private int id;
    private String name;
    private int waterCount;
    private int gasCount1;
    private int gasCount2;
    private int electroCount1;
    private int electroCount2;

    public Data(int id, String name, int waterCount, int gasCount1, int gasCount2, int electroCount1, int electroCount2) {
        this.id = id;
        this.name = name;
        this.waterCount = waterCount;
        this.gasCount1 = gasCount1;
        this.gasCount2 = gasCount2;
        this.electroCount1 = electroCount1;
        this.electroCount2 = electroCount2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaterCount(int waterCount) {
        this.waterCount = waterCount;
    }

    public void setGasCount1(int gasCount1) {
        this.gasCount1 = gasCount1;
    }

    public void setGasCount2(int gasCount2) {
        this.gasCount2 = gasCount2;
    }

    public void setElectroCount1(int electroCount1) {
        this.electroCount1 = electroCount1;
    }

    public void setElectroCount2(int electroCount2) {
        this.electroCount2 = electroCount2;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getGasCount1() {
        return gasCount1;
    }

    public int getGasCount2() {
        return gasCount2;
    }

    public int getElectroCount1() {
        return electroCount1;
    }

    public int getElectroCount2() {
        return electroCount2;
    }

    @Override
    public String toString() {
        return id +
                "|" + name +
                "|" + waterCount +
                "|" + gasCount1 +
                "|" + gasCount2 +
                "|" + electroCount1 +
                "|" + electroCount2;
    }
}
