package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList("\t\t\t",
            "======== Task program ========",
            "1. Add Task",
            "2. Delete task",
            "3. Display Task",
            "4. Exit"
    );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.checkInputIntLimit("Select Option: ",1, 5);
    }
}
