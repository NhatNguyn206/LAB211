package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);

    public static String checkInputString (String msg) {
        while (true){
            System.out.println(msg);
            String result = sc.nextLine().trim();
            if (!result.isEmpty()){
                return result;
            }
            System.err.println("Cannot Empty! Enter again: ");
        }
    }

    public static int checkInputAge(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result >= 18 && result <= 50) {
                    return result;
                }
                System.err.println("Tuổi phải trong khoảng 18 đến 50!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    public static double checkInputSalary(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result > 0) {
                    return result;
                }
                System.err.println("Số tiền phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số thực hợp lệ!");
            }
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
                System.err.println("Lựa chọn phải từ " + min + " đến " + max + "!");
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }




}
