package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList("\t\t\t",
            "======== Worker Management ========",
            "1. Add Worker",
            "2. Up salary",
            "3. Down salary",
            "4. Display Information salary",
            "5. Exit"
            );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return Validation.checkInputIntLimit("Select Option: ",1, 5);
    }
}
