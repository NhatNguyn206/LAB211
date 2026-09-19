package view;

import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList(
            "========= Contact program =========",
            "1. Add a Contact",
            "2. Display all Contact",
            "3. Delete a Contact",
            "4. Exit"
            );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.inputLimit(1, 4);
    }
}