package view;

import model.SalaryHistory;
import model.SalaryStatus;
import model.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleForm {
    public Worker inputInformation() {
        System.out.println("\n-------- Add Worker --------");
        String code = Validation.checkInputString("Enter code:");
        String name = Validation.checkInputString("Enter name:");
        int age = Validation.checkInputAge("Enter age:");
        double salary = Validation.checkInputSalary("Enter salary:");
        String location = Validation.checkInputString("Enter work location:");
        Worker worker = new Worker(code , name , age , salary , location);

        return new Worker (code ,name, age , salary , location );

    }

    // Nhận Mã công nhân (dùng khi tìm kiếm hoặc tăng/giảm lương)
    public String inputCode() {
        return Validation.checkInputString("Enter code: ");
    }

    public double inputSalaryAmount(){
        return Validation.checkInputSalary("Enter salary: ");
    }







    public void displaySalaryInformation (List<Worker> workerList){
        if (workerList.isEmpty()){
            System.out.println("The list of workers is empty!");
            return;
        }
        //tạo bản sao để sắp xếp danh sách bằng Comparabale
        List <Worker> sortedList = new ArrayList<>(workerList);
        Collections.sort(sortedList);

        boolean hasHistory = false;
        System.out.println("\n-------------------- Display Information Salary --------------------");
        System.out.printf("%-10s %-15s %-10s %-12s %-10s %-12s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");

        // Duyệt danh sách đã sắp xếp và in lịch sử
        for (Worker w : sortedList){
            for (SalaryHistory h : w.getWorkerHistory()){

                if (h.getStatus() == SalaryStatus.NONE) {
                    continue;
                }
                hasHistory = true;

                System.out.printf("%-10s %-15s %-10d %-12.1f %-10s %-12s\n",
                        w.getCode(),
                        w.getName(),
                        w.getAge(),
                        h.getSalaryUpdate(),
                        h.getStatus(),
                        h.getDate());
            }
            if (!hasHistory){
                System.out.println("There is no history of salary adjustments!");
            }
        }

    }
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    public void displayError(String msg) {
        System.err.println(msg);
    }


}
