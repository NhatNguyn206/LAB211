package view;

import java.util.Scanner;

public class DataInput {
    private static final Scanner sc = new Scanner(System.in);

    public static String checkInputString (String msg) {
        while (true){
            System.out.println(msg);
            String result = sc.nextLine().trim();
            if (!result.isEmpty()){
                return result;
            }
            System.err.println("Cannot Empty!");
        }
    }


    public static int checkInputIntLimit(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                }
                System.err.println("Your choice must from " + min + " to " + max + "!");
            } catch (NumberFormatException e) {
                System.err.println("Please enter valid integer!");
            }
        }
    }
    public static boolean inputYN(String msg) {
        while (true) {
            String result = checkInputString(msg);
            if (result.equalsIgnoreCase("Y")) return true;
            if (result.equalsIgnoreCase("N")) return false;
            System.err.println("Just enter Y or N!");
        }
    }

}
