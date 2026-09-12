package changebasenumbersystemprogram;


import java.util.Scanner;

public class Validate {
    private final static Scanner sc = new Scanner(System.in);
    //reget này nhập rỗng nó vẫn lấy , nếu khó quá thì đổi lại +
    private static final String BINARY_VALID = "[0-1]*";
    private static final String DECIMAL_VALID = "[0-9]*";
    private static final String HEXADECIMAL_VALID = "[0-9A-F]*";

    public static int checkInputIntLimit(int min,int max){
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result<min || result>max){
                    throw new NumberFormatException();
                }
                return result;
            }catch(NumberFormatException e){
                System.err.println("Please input number in rage ["+min+", "+max+"]");
                System.out.println("Enter again:");
            }
        }
    }

    public static String checkInputBinary(){
        System.out.println("Enter number binary:");
        String result;
        while (true){
            result = sc.nextLine().trim();
            if (result.matches(BINARY_VALID)){
                return result;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.println("Enter again:");
        }
    }

    public static String checkInputDecimal(){
        System.out.println("Enter number decimal:");
        String result;
        while (true){
            result = sc.nextLine().trim();
            if (result.matches(DECIMAL_VALID)){
                return result;
            }
            System.err.println("Must be enter 0-9");
            System.out.println("Enter again: ");

        }
    }

    public static String checkInputHexadecimal(){
        System.out.println("Enter number hexadecimal:");
        String result;
        while (true){
            result = sc.nextLine().trim();
            if (result.matches(HEXADECIMAL_VALID)){
                return result;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.println("Enter again: ");

        }
    }

}
