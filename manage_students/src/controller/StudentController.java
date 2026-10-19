package controller;

import model.Student;
import model.StudentList;
import view.ConsoleForm;
import view.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final StudentList studentList;
    private final ConsoleForm consoleForm;

    public StudentController() {
        this.studentList = new StudentList();
        this.consoleForm = new ConsoleForm();
    }


    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    handleCreate();
                    break;
                case 2:
                    handleFindAndSort();
                    break;
                case 3:
                    handleUpdateOrDelete();
                    break;
                case 4:
                    handleReport();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void handleCreate() {
        while (true) {
            String id = consoleForm.inputId();
            String name = studentList.getStudentNameById(id);
            if (name != null) {
                consoleForm.displayMessage("Found existing name for this ID: " + name);
            } else {
                name = consoleForm.inputStudentName();
            }
            String semester = consoleForm.inputSemester();
            String course = consoleForm.inputCourse();

            try {
                studentList.addStudent(id, name, semester, course);
                consoleForm.displayMessage("Add student success!");
            } catch (Exception e) {
                consoleForm.displayError(e.getMessage());
            }

            int currentCount = studentList.getStudentList().size();
            if (currentCount >= 3) {
                if (!consoleForm.askContinue()) break;
            } else {
                consoleForm.displayMessage("You must create at least 3 students. Current count: " + currentCount);
            }
        }
    }

    private void handleFindAndSort() {
        String keyword = consoleForm.inputKeyword();
        try {
            List<Student> result = studentList.findAndSort(keyword);
            consoleForm.displayStudents(result);
        } catch (Exception e) {
            consoleForm.displayError(e.getMessage());
        }
    }

    private void handleUpdateOrDelete() {
        String id = consoleForm.inputId();
        List<Student> list = studentList.getStudentById(id);
        if (list.isEmpty()) {
            consoleForm.displayError("Student ID does not exist!");
            return;
        }

        String option = consoleForm.askUpdateOrDelete();
        if (option.equals("D")) {
            try {
                studentList.deleteById(id);
                consoleForm.displayMessage("Delete success!");
            } catch (Exception e) {
                consoleForm.displayError(e.getMessage());
            }
        } else {
            consoleForm.displayStudents(list);
            int choice = 1;
            if (list.size() > 1) {
                choice = consoleForm.inputRecordIndex(list.size());
            }
            Student target = list.get(choice - 1);

            String newName = consoleForm.inputNewName();
            String newSemester = consoleForm.inputNewSemester();
            String newCourse = consoleForm.inputNewCourse();

            studentList.updateStudent(target, id, newName, newSemester, newCourse);
            consoleForm.displayMessage("Update success!");
        }
    }

    private void handleReport() {
        try {
            consoleForm.displayReport(studentList.generateReport());
        } catch (Exception e) {
            consoleForm.displayError(e.getMessage());
        }
    }




}
