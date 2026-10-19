package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList = new ArrayList<>();
    private int lastId = 0;

    public int addTask(String requirementName, String assignee, String reviewer,
                       String taskTypeID, String date, String planFrom, String planTo) throws Exception {
    //Thay vì tự xử lý hiển thị lỗi bằng System.out.println
    // ngay bên trong Model (vi phạm nguyên tắc MVC),
    // Model dùng từ khóa throw new Exception(...) để đẩy lỗi ra ngoài cho Controller bắt lấy.
        int typeId;
        try {
            typeId = Integer.parseInt(taskTypeID);
        } catch (NumberFormatException e) {
            throw new Exception("TaskTypeID must be a number!");
        }

        TaskType taskType = TaskType.getTaskTypeByID(typeId);
        if (taskType == null){
            throw new Exception("TaskTypeID must be between 1 and 4!");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false); // ngày nào k tồn tại thì bị ném ra
        try {
            sdf.parse(date); // ép chuỗi theo định dạng
        }catch (ParseException e){
            throw new Exception("Date must be in format dd-MM-yyyy!");
        }

        double from, to;
        try {
            from = Double.parseDouble(planFrom);
            to = Double.parseDouble(planTo);
        }catch (NumberFormatException e) {
            throw new Exception("Plan From and Plan To must be numbers!");
        }

        if (from < 8.0 || from > 17.5 || to < 8.0 || to > 17.5){
            throw new Exception("Plan time must be within 8.0 -> 17.5!");
        }
        if (from >= to){
            throw new Exception("Plan From must be strictly less than Plan To!");
        }

        int id = ++ lastId;
        Task task = new Task(id , taskType , requirementName , date , from , to , assignee,reviewer);
        taskList.add(task);

        return id;
    }

    public void deleteTask (String id) throws Exception {
        int taskId;

        try {
            taskId = Integer.parseInt(id);
        }catch (NumberFormatException e){
            throw new Exception("ID must be a valid integer!");
        }
        Task foundTask = null;
        for (Task check : taskList){
            if (check.getId() == taskId){
                foundTask = check;
                break;
            }
        }
        if (foundTask == null){
            throw new Exception("Task ID does not exist!");
        }
        taskList.remove(foundTask);

    }

    public List<Task> getDataTasks() {
        return taskList;
    }
}
