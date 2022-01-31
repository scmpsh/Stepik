package module6.Reports;

import java.time.LocalDate;

public class Report {

    private Long id;
    private String studentUserName;
    private Integer hours;
    private LocalDate date;
    private String title;

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}
