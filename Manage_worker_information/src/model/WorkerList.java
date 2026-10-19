package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerList {
    private List <Worker> workerList ;

    public WorkerList() {
        this.workerList = new ArrayList<>();
    }





    // Thêm mới công nhân (trả về false nếu trùng code)
    public boolean addWorker(Worker worker) {
        if (findWorkerByCode(worker.getCode()) != null) {
            return false;
        }
        // 1. Tạo bản ghi lịch sử ban đầu với status là NONE
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        SalaryHistory initialHistory = new SalaryHistory(worker.getSalary(), SalaryStatus.NONE, currentDate);

        // 2. Add lịch sử này vào Worker
        worker.addHistory(initialHistory);

        // 3. Add Worker vào danh sách
        return workerList.add(worker);
    }
    // Tìm kiếm công nhân theo mã Code
    public Worker findWorkerByCode(String code) {
        for (Worker w : workerList) {
            if (w.getCode().equalsIgnoreCase(code)) {
                return w;
            }
        }
        return null;
    }


    //change
    public boolean changeSalary (SalaryStatus status , String code , double amount){
        Worker worker = findWorkerByCode(code);
        if (worker == null || amount <=0){
            return false;
        }
        double currentSalary = worker.getSalary();

        //Ktra đk giảm lương
        if (status == SalaryStatus.DOWN && currentSalary < amount){
            return false;
        }

        //lương mới
        double newSalary = (status == SalaryStatus.UP) ? currentSalary + amount : currentSalary - amount;

        // update lương mới cho worker
        worker.setSalary(newSalary);

        //tạo ngày hiện tại
        String currentday = new SimpleDateFormat("dd/MM/yyyy").format(
                new Date()
        );

        // tạo bản ghi và lưu trực tiếp vào worker này
        SalaryHistory history = new SalaryHistory(newSalary,status,currentday);
        worker.addHistory(history);
        return true;
    }



    // Lấy toàn bộ danh sách Worker
    public List<Worker> getWorkerList() {
        return workerList;
    }



}
