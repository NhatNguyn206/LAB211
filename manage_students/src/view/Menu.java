package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList("\t\t\t",
            "======== STUDENT MANAGEMENT ========",
            "1. Create",
            "2. Find and Sort",
            "3. Update/Delete",
            "4. Report",
            "5. Exit"
    );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.inputIntLimit("Select Option: ",1, 5);
    }
}
