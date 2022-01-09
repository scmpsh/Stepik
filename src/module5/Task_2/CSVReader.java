package module5.Task_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    public static List<Data> fileRead(String filePath) throws IOException {
        List<Data> dataList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        final String DELIMITER = "\\|";
        Data data;
        Scanner scanner = new Scanner(bufferedReader);
        scanner.useDelimiter(DELIMITER);
        String header = scanner.nextLine();

        while (scanner.hasNext()) {
            String[] lineFromTable = scanner.nextLine().split(DELIMITER);
            dataList.add(new Data(
                    Integer.parseInt(lineFromTable[0]),
                    lineFromTable[1],
                    Integer.parseInt(lineFromTable[2]),
                    Integer.parseInt(lineFromTable[3]),
                    Integer.parseInt(lineFromTable[4]),
                    Integer.parseInt(lineFromTable[5]),
                    Integer.parseInt(lineFromTable[6])

            ));
        }
        return dataList;
    }

    public static List<Data> filterEco(List<Data> dataList, int maxCount) {
        List<Data> ecoList = new ArrayList<>();

        for (Data data : dataList) {
            if (data.getWaterCount() < maxCount && data.getGasCount1() < maxCount && data.getGasCount2() < maxCount
                    && data.getElectroCount1() < maxCount && data.getElectroCount2() < maxCount) {
                ecoList.add(data);
            }
        }
        return ecoList;
    }

    public static void writeToFile(List<Data> ecoList, String newFile) throws IOException {
        FileWriter fileWriter = new FileWriter(newFile);

        for (Data data : ecoList) {
            fileWriter.write(data.toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до файла: ");
        String filePath = scanner.nextLine();
        System.out.print("Введите число максимального потребления ресурсов: ");
        int maxCount = Integer.parseInt(scanner.nextLine());
        List<Data> dataList = fileRead(filePath);
        List<Data> ecoList = filterEco(dataList, maxCount);
        String newFile = filePath.substring(0, filePath.lastIndexOf("/")) + "/newData.csv";
        writeToFile(ecoList, newFile);
    }
}
