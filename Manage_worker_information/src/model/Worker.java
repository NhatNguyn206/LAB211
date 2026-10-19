package model;

import java.util.ArrayList;

import java.util.List;

public class Worker implements Comparable<Worker>  {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private List<SalaryHistory> workerHistory;

    public Worker() {
        this.workerHistory = new ArrayList<>();
    }

    public Worker(String code, String name, int age, double salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
        this.workerHistory = new ArrayList<>(); //tránh lỗi NullPointerException
    }

    // thêm 1 lịch sử mới vào worker này
    public void addHistory (SalaryHistory history){
        this.workerHistory.add(history);
    }

    public List<SalaryHistory> getWorkerHistory() {
        return workerHistory;
    }

    public void setWorkerHistory(List<SalaryHistory> workerHistory) {
        this.workerHistory = workerHistory;
    }

    // getter setter còn lại

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    //Triển khai phương thức compareTo để so sánh 2 Worker theo Code
    @Override
    public int compareTo(Worker o) {
        return this.code.compareToIgnoreCase(o.getCode());
    }

}
