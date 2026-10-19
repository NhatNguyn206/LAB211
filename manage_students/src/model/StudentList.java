package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentList {
    private final List<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }



    public List <Student> getStudentById(String id){
        List <Student> result = new ArrayList<>();
        for (Student s : studentList){
            if(s.getId().equalsIgnoreCase(id)){
                result.add(s);
            }
        }
        return result;
    }
    public void deleteById (String id) throws Exception{
        List <Student> stu = getStudentById(id);
        if(stu.isEmpty()){
            throw new Exception("Student ID does not exist!");
        }
        studentList.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }




    public void addStudent(String id, String name, String semester, String course)
            throws Exception {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)
                    && s.getSemester().equalsIgnoreCase(semester)
                    && s.getCourse().equalsIgnoreCase(course)) {
                throw new Exception("This student is already registered for this course in this semester!");
            }
        }
        studentList.add(new Student(id, name, semester, course));
    }

    public List <Student> findAndSort (String name) throws Exception{
        if (studentList.isEmpty()){
            throw new Exception("Student list is empty!");
        }
        List <Student> match = new ArrayList<>();
        for (Student s : studentList){
            if ( s.getStudentName().toLowerCase().contains(name.toLowerCase())){
                match.add(s);
            }
        }
        if (match.isEmpty()){
            throw new Exception("No student matched with keyword!");
        }
        Collections.sort(match);
        return match;

    }

    public void updateStudent(Student t, String newId, String newName,
                              String newSemester, String newCourse) {

        if (!newName.trim().isEmpty()){
            for ( Student s : studentList ) {
                if (s.getId().equalsIgnoreCase(t.getId())){
                    s.setStudentName(newName);
            }
            }
        }
        if (!newSemester.trim().isEmpty()) {
            t.setSemester(newSemester);
        }
        if (!newCourse.trim().isEmpty()) {
            t.setCourse(newCourse);
        }
    }

    public List<StudentReport> generateReport () throws Exception{
        if (studentList.isEmpty()){
            throw new Exception("Student list is empty!");
        }
        List <StudentReport> report = new ArrayList<>();
        for (Student s : studentList){
            int total = countReport (s.getId(),  s.getCourse());
            if (!isReportExist (report, s.getId(),  s.getCourse())){
                report.add(new StudentReport(s.getId(), s.getStudentName(), s.getCourse(), total));
            }
        }
        return report;
    }
    private boolean isReportExist(List<StudentReport> report, String id,  String course) {
        for (StudentReport s : report) {
            if (s.getId().equalsIgnoreCase(id)
                    && s.getCourse().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    private int countReport(String id,  String course) {
        int count = 0;
        for (Student s : studentList){
            if (s.getId().equalsIgnoreCase(id)
            && s.getCourse().equalsIgnoreCase(course)){
                count ++;
            }
        }
        return count;
    }


    public String getStudentNameById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s.getStudentName();
            }
        }
        return null;
    }

}
