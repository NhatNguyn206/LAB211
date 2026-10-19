package view;

import java.util.Scanner;

public class DataInput {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println("Input cannot be empty. Please try again!");
        }
    }

    public static int inputIntLimit(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.err.println("Please input a number in range [" + min + ", " + max + "]!");
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer format! Please try again.");
            }
        }
    }

    public static String inputCourse(String msg) {
        while (true) {
            String course = inputString(msg);
            if (course.equalsIgnoreCase("Java") ||
                    course.equalsIgnoreCase(".Net") ||
                    course.equalsIgnoreCase("C/C++")) {

                if (course.equalsIgnoreCase("Java")) return "Java";
                if (course.equalsIgnoreCase(".Net")) return ".Net";
                if (course.equalsIgnoreCase("C/C++")) return "C/C++";
            }
            System.err.println("Course name must be one of: Java, .Net, C/C++!");
        }
    }

    public static boolean inputYN(String msg) {
        while (true) {
            String result = inputString(msg);
            if (result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.println("Just enter Y or N!");
        }
    }

    public static String inputUD(String msg) {
        while (true) {
            String input = inputString(msg);
            if (input.equalsIgnoreCase("U") || input.equalsIgnoreCase("D")) {
                return input.toUpperCase();
            }
            System.err.println("Please input U (Update) or D (Delete)!");
        }
    }
    public static String inputAllowEmpty(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
