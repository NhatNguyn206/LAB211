package view;

import java.util.List;
import model.Task;
import model.TaskList;
import model.TaskType;

public class ConsoleForm {

    public void displayAddTaskHeader() {
        System.out.println("------------------ Add Task ------------------");
    }


    public void displayDeleteTaskHeader() {
        System.out.println("------------------ Del Task ------------------");
    }

    public String[] getAddTaskForm() {
        displayAddTaskHeader();
        String reqName = DataInput.checkInputString("Requirement Name: ");
        String taskTypeID = DataInput.checkInputString("Task Type: ");
        String date = DataInput.checkInputString("Date: ");
        String planFrom = DataInput.checkInputString("From: ");
        String planTo = DataInput.checkInputString("To: ");
        String assignee = DataInput.checkInputString("Assignee: ");
        String reviewer = DataInput.checkInputString("Reviewer: ");

        return new String[]{reqName, taskTypeID, date, planFrom, planTo, assignee, reviewer};
    }

    public String getDeleteTaskId() {
        displayDeleteTaskHeader();
        return DataInput.checkInputString("ID: ");
    }




    public void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }

        System.out.println("---------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s %-15s %-10s %-12s %-8s %-10s %-10s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");

        for (Task t : tasks) {
            System.out.printf("%-5d %-15s %-10s %-12s %-8.1f %-10s %-10s\n",
                    t.getId(),
                    t.getRequirementName(),
                    t.getTaskType().getName(), // Tự động lấy "Code", "Test", "Design", "Review"
                    t.getDate(),
                    t.getTime(),
                    t.getAssign(),
                    t.getReviewer());
        }

    }


    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public void displayError(String err) {
        System.err.println("Error: " + err);
    }
}
