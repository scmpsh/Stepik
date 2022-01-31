package module6.Reports;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportHistory {

    public static String reportHistory(List<Report> reports, String studentUserName, int count) {
        return reports.stream()
                .filter(t -> t.getStudentUserName().equals(studentUserName))
                .sorted(Comparator.comparing(Report::getDate).reversed())
                .limit(count)
                .sorted(Comparator.comparing(Report::getDate))
                .map(t -> t.getStudentUserName().substring(1) + "\n"
                        + t.getDate() + "\n"
                        + t.getHours() + "\n"
                        + t.getTitle() + "\n"
                )
                .collect(Collectors.joining("-----------------\n"));
    }


    public static void main(String[] args) {
        String[] names = new String[]{
                "@kek",
                "@piter",
                "@lol",
                "@motherlover",
                "@wow"
        };
        List<Report> reportList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            reportList.add(new Report((long) i, names[(int) (Math.random() * 5)], i,
                    LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), i % 10 + 1),
                    "text")
            );
        }
        System.out.print(reportHistory(reportList, names[(int) (Math.random() * 5)], 3));
    }
}
