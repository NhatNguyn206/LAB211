package controller;

import model.TaskList;
import view.ConsoleForm;
import view.DataInput;
import view.Menu;

public class TaskController {
    private final TaskList model;
    private final ConsoleForm view;

    public TaskController() {
        this.model = new TaskList();
        this.view = new ConsoleForm();
    }

    public void run() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    handleAddTask();
                    break;
                case 2:
                    handleDeleteTask();
                    break;
                case 3:
                    view.displayTasks(model.getDataTasks());
                    break;
                case 4:
                    return;
            }
        }
    }

    private void handleAddTask() {
        String[] inputs = view.getAddTaskForm();

        try {
            int id = model.addTask(inputs[0], inputs[5], inputs[6], inputs[1], inputs[2], inputs[3], inputs[4]);
            view.displayMessage("Add task success! Task ID: " + id);
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }

    private void handleDeleteTask() {
        String id = view.getDeleteTaskId();
        try {
            model.deleteTask(id);
            view.displayMessage("Delete task success!");
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
}
