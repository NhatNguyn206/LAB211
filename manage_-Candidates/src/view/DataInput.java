package view;

import java.time.Year;
import java.util.Scanner;

public class DataInput {
    private static final Scanner sc = new Scanner(System.in);

    public final static String VALID_PHONE = "^[0-9]{10,}$";
    public final static String VALID_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)+$";
    private static final String[] RANKS = {"Excellence", "Good", "Fair", "Poor"};

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

    public static int inputBirthdate (){
        return inputIntLimit("Enter Birth Date (year 1900..current year): ", 1900, Year.now().getValue());
    }

    public static String inputPhone(String msg) {
        while (true) {
            String phone = inputString(msg);
            if (phone.matches(VALID_PHONE)) {
                return phone;
            } else {
                System.err.println("Phone must be a number with at least 10 digits");
            }
        }
    }
    public static String inputEmail (String msg){
        while (true){
            String email = inputString(msg);
            if (email.matches(VALID_EMAIL)){
                return email;
            }else{
                System.err.println("Email must be in format <account name>@<domain> (eg: annguyen@fpt.edu.vn)");
            }
        }
    }

    public static int inputYearExperience(){
        return inputIntLimit("Enter Year of Experience (0..100): ",0,100);
    }

    public static String inputRank(String msg){
        while (true){
            String rank = inputString(msg);
            for (String r :RANKS){
                if (r.equalsIgnoreCase(rank)){
                    return rank;
                }
            }
            System.err.println("Rank must be one of: Excellence, Good, Fair, Poor");
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


}
