package view;

import java.util.Arrays;
import java.util.List;

public class Menu {

    static List<String> choices = Arrays.asList("\t\t\t",
            "======== Dictionary program ========",
            "1. Add Word",
            "2. Delete Word",
            "3. Translate",
            "4. Exit"
    );

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.checkInputIntLimit("Select Option: ",1, 4);
    }
}
