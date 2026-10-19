package view;

import model.Student;
import model.StudentReport;

import java.util.List;

public class ConsoleForm {
    public void displayStudents(List<Student> list) {
        System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "ID", "Student Name", "Semester", "Course Name");
        System.out.println("----------------------------------------------------------------");
        for (Student s : list) {
            System.out.printf("%-10s | %-20s | %-10s | %-10s\n",
                    s.getId(), s.getStudentName(), s.getSemester(), s.getCourse());
        }
    }

    public void displayReport(List<StudentReport> reports) {
        System.out.println("------------------------------------------------");
        for (StudentReport r : reports) {
            System.out.printf("%10s | %-20s | %-10s | %-5d\n",
                    r.getId(), r.getStudentName(), r.getCourse(), r.getTotalCourse());
        }
    }

    public String inputId()          { return DataInput.inputString("Enter Student ID: "); }
    public String inputStudentName() { return DataInput.inputString("Enter Student Name: "); }
    public String inputSemester()    { return DataInput.inputString("Enter Semester: "); }
    public String inputCourse()      { return DataInput.inputCourse("Enter Course (Java, .Net, C/C++): "); }
    public boolean askContinue()     { return DataInput.inputYN("Do you want to continue (Y/N)? "); }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public void displayError(String err) {
        System.err.println("Error: " + err);
    }



    public String inputKeyword()      { return DataInput.inputString("Enter name or part of name to search: "); }
    public String askUpdateOrDelete() { return DataInput.inputUD("Do you want to update (U) or delete (D) student? "); }

    public int inputRecordIndex(int size) {
        return DataInput.inputIntLimit("Choose record index to update (1-" + size + "): ", 1, size);
    }

    public String inputNewName()     { return DataInput.inputAllowEmpty("Enter new Name (Press Enter to keep): "); }
    public String inputNewSemester() { return DataInput.inputAllowEmpty("Enter new Semester (Press Enter to keep): "); }
    public String inputNewCourse()   { return DataInput.inputCourse("Enter new Course (Java, .Net, C/C++): "); }
}
