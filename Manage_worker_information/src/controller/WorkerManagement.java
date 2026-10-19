package controller;


import model.SalaryStatus;
import model.WorkerList;
import view.ConsoleForm;
import view.Menu;

import java.util.ArrayList;

public class WorkerManagement {
    private WorkerList workerList = new WorkerList();
    private ConsoleForm consoleForm = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    if (workerList.addWorker(consoleForm.inputInformation())) {
                        consoleForm.displayMessage("Add worker successfully.");
                    } else {
                        consoleForm.displayError("Code existed in database!");
                    }
                    break;
                case 2:
                    changeSalary(SalaryStatus.UP);
                    break;
                case 3:
                    changeSalary(SalaryStatus.DOWN);
                    break;
                case 4:
                    if (workerList.getWorkerList().isEmpty()) {
                        consoleForm.displayError("List worker is empty!");
                    } else {
                        consoleForm.displaySalaryInformation(workerList.getWorkerList());
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }


    private void changeSalary(SalaryStatus status) {
        String code = consoleForm.inputCode();

        // Kiểm tra tồn tại trước
        if (workerList.findWorkerByCode(code) == null) {
            consoleForm.displayError("Worker does not exist!");
            return;
        }

        double amount = consoleForm.inputSalaryAmount();

        // Thực hiện cập nhật và gửi kết quả cho View hiển thị
        if (workerList.changeSalary(status, code, amount)) {
            consoleForm.displayMessage("Update salary successfully.");
        } else {
            consoleForm.displayError("Update salary failed! (Amount exceeds current salary).");
        }
    }
}