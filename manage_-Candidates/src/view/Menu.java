package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList("\t\t\t",
            "======== CANDIDATE MANAGEMENT SYSTEM ========",
            "1. Experience",
            "2. Fresher",
            "3. Internship",
            "4. Searching",
            "5. Exit"
    );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.inputIntLimit("Select Option: ",1, 5);
    }

}
