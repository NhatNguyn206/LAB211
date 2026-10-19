package model;

public class StudentReport {
    private final String id;
    private final String studentName;
    private final String course;
    private final int totalCourse;

    public StudentReport(String id, String studentName, String course, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getTotalCourse() {
        return totalCourse;
    }
}
