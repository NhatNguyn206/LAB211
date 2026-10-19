package model;

public enum TaskType {
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");

    private final int id;
    private final String name;

    //Constructor của enum luôn là private
    TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public static TaskType getTaskTypeByID(int ID) {
        switch (ID) {
            case 1:
                return CODE;
            case 2:
                return TEST;
            case 3:
                return DESIGN;
            case 4:
                return REVIEW;
            default:
                throw new AssertionError();//xảy ra khi một câu lệnh khẳng định (assert) bị thất bại.
        }
    }


}
