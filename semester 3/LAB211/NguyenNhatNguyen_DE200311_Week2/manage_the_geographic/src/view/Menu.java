package view;
import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> choices = Arrays.asList("\t\t\tMENU",
            "==========================================================================",
            "1. Input the information of countries in East Asia",
            "2. Display the information of country you've just input",
            "3. Search the information of country by user-entered name",
            "4. Display the information of countries sorted name in ascending order",
            "5. Exit ",
            "==========================================================================");

    public static int getChoice() {
        choices.forEach(c -> System.out.println(c));
        return DataInput.inputLimit(1, 5);
    }
}
