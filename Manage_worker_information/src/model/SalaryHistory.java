package model;

public class SalaryHistory {
    private double oldSalary;
    private double salaryUpdate; // Lương sau khi tăng/giảm
    private SalaryStatus status;  // UP hoặc DOWN
    private String date;

    public SalaryHistory() {
    }

    public SalaryHistory( double salaryUpdate, SalaryStatus status, String date) {
        this.salaryUpdate = salaryUpdate;
        this.status = status;
        this.date = date;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getSalaryUpdate() {
        return salaryUpdate;
    }

    public void setSalaryUpdate(double salaryUpdate) {
        this.salaryUpdate = salaryUpdate;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
