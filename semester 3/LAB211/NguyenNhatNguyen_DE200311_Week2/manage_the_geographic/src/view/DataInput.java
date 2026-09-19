package view;

import java.util.Locale;
import java.util.Scanner;

public class DataInput {
    public final static Scanner sc = new Scanner(System.in);
    //nhap vao mot string khong rong
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

    public static float inputPositiveFloat(){
        while (true){
            try {
                String inputString =inputString();
                float result = Float.parseFloat(inputString);
                if (result > 0) return result;
                else {
                    System.out.println("Please input a positive float number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a float number number.");
            }
        }
    }

    public static boolean inputYN(){
        System.out.println("Do you want to continue? (y/n)");
        while (true){
            String inputString = inputString();
            if (inputString.equalsIgnoreCase("Y")) return true;
            else if (inputString.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("Please input Y/y or N/n");
            }
        }

    }


}
