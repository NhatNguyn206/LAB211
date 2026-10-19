package view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConsoleForm {
    private final Scanner sc = new Scanner(System.in);

    public String inputString() {
        System.out.println("===== Analysis String program ====");
        while (true) {
            System.out.print("Input String: ");
            String input = sc.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.err.println("Input string cannot be empty!");
        }
    }

    public void displayResult(HashMap<String, List<Integer>> numberMap, HashMap<String, StringBuilder> charMap) {
        System.out.println("-----Result Analysis");
        System.out.println("Perfect Square Numbers: " + numberMap.get("squareNumbers"));
        System.out.println("Odd Numbers: " + numberMap.get("oddNumbers"));
        System.out.println("Even Numbers: " + numberMap.get("evenNumbers"));
        System.out.println("All Numbers: " + numberMap.get("allNumbers"));
        System.out.println("Uppercase Characters: " + charMap.get("uppercaseChars"));
        System.out.println("Lowercase Characters: " + charMap.get("lowercaseChars"));
        System.out.println("Special Characters: " + charMap.get("specialChars"));
        System.out.println("All Characters: " + charMap.get("allChars"));
    }
}
