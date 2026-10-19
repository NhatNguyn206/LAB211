package model;

public class Student implements Comparable<Student> {
    String id;
    String studentName;
    String semester;
    String course;

    public Student() {
    }

    public Student(String id, String name, String semester, String course) {
        this.id = id;
        this.studentName = name;
        this.semester = semester;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.getStudentName());
    }
}
