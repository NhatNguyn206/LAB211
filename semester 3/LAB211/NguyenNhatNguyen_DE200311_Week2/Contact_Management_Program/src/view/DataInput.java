package view;

import java.util.Scanner;

public class DataInput {

    public final static String VALID_PHONE = "^[0-9]{10}$" +     // 1234567890
            "|^[0-9]{3}-[0-9]{3}-[0-9]{4}$" +                    // 123-456-7890
            "|^[0-9]{3}-[0-9]{3}-[0-9]{4}\\s+(x|ext)[0-9]{4}$" + // 123-456-7890 x1234 hoặc ext1234
            "|^[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}$" +                // 123.456.7890
            "|^[0-9]{3}\\s[0-9]{3}\\s[0-9]{4}$";                 // 123 456 7890

    public final static Scanner sc = new Scanner (System.in);

    public static String inputString() {
        while (true){
            String result = sc.nextLine().trim();
            if (!result.isEmpty()) return result;
            else {
                System.err.println("Please enter a string");
                System.out.println("Enter again");
            }
        }
    }

    public static int inputPositiveInteger(){
        while (true){
            try {
                String inputString = inputString();
                int result = Integer.parseInt(inputString);
                if (result >0) return result;
                else {
                    System.out.println("Please input a positive number.");
                }
            }catch (NumberFormatException e){
                System.err.println("Please input a number.");
            }
        }
    }
    public static int inputLimit(int min, int max) {
        while (true) {
            System.out.println("Enter your choice:");
            int result = inputPositiveInteger();
            if (result >= min && result <= max) {
                return result;
            } else {
                System.out.println("Please input a number in the range " + min + "," + max);
            }
        }
    }

    public static String inputPhone(){
        while (true){
            String phone = inputString();
            if (phone.matches(VALID_PHONE)){
                return phone;
            }else{
                System.out.println("Please input Phone flow\n" +
                "• 1234567890\n" +
                "• 123-456-7890\n" +
                "• 123-456-7890 x1234\n" +
                "• 123-456-7890 ext1234\n" +
                "• 123.456.7890\n" +
                "• 123 456 7890");
                System.out.print("Enter Phone: ");
            }
        }
    }



}
