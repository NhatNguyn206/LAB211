package changebasenumbersystemprogram;

public class Manager {

    public static final char[] hexDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static int menu(){
        System.out.println("1.Convert From Binary.");
        System.out.println("2.Convert From Decimal.");
        System.out.println("3.Convert From Hexa.");
        System.out.println("4.Exit.");
        int choice = Validate.checkInputIntLimit(1,4);
        return choice;
    }
    public static int displayConvert ( String from , String toCase1, String toCase2){
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.println("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1,2);
        return result;
    }


    public static void convertFromBinary(String binary){
        int choice =  displayConvert("binary","decimal","hexadecimal");
            switch (choice){
                case 1:
                    System.out.println("Decimal: "+convertBinaryToDecimal(binary));
                    break;

                case 2:
                    System.out.println("Hexadecimal: "+convertBinaryToHexa(binary));
                    break;
            }
        }

    public static void convertFromDecimal(String decimal){
        int choice=displayConvert("decimal","binary","hexadecimal");
        switch (choice){
            case 1:
                System.out.println("Binary: "+convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.println("Hexadecimal: "+convertDecimalToHexadecimal(decimal));
                break;
        }
    }


    public static void convertFromHexadecimal(String hexa){
        int choice=displayConvert("hexadecimal","binary","decimal");
        switch (choice){
            case 1:
                System.out.println("Binary: "+convertHexadecimalToBinary(hexa));
                break;
            case 2:
                System.out.println("Decimal: "+convertHexadecimalToDecimal(hexa));
                break;
        }
    }
//Binary

    public static String convertBinaryToDecimal(String binary){
        int decimal=Integer.parseInt(binary,2);
        return Integer.toString(decimal);
    }
    /*cách bth
    * public static int convertBinaryToDecimalManual(String binary) {
    int decimal = 0;
    int length = binary.length();
    for (int i = 0; i < length; i++) {
        // Lấy ký tự từ phải qua trái
        char c = binary.charAt(length - 1 - i);
        int digitValue = Character.getNumericValue(c); // Đổi ký tự '1' hoặc '0' ra số 1 hoặc 0
        decimal += digitValue * Math.pow(2, i);
    }
    return decimal;
}*/

    public static String convertBinaryToHexa(String binary){
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexadecimal(decimal);
        return hexa;
    }

    //dec
    public static int convertHexadecimalToDecimal(String hexadecimal){
        int decimal = Integer.parseInt(hexadecimal,16);
        return decimal;
    }
    public static String convertHexadecimalToBinary(String hexa) {
        String binary = Integer.toBinaryString(convertHexadecimalToDecimal(hexa));
        return binary;
    }
    /*public static String convertDecimalToBinary(int decimal) {
    if (decimal == 0) {
        return "0";
    }
    String binary = "";
    while (decimal > 0) {
        int remainder = decimal % 2;       // Lấy số dư (0 hoặc 1)
        binary = remainder + binary;       // Nối số dư vào trước chuỗi kết quả
        decimal = decimal / 2;             // Chia tiếp cho 2
    }
    return binary;
}*/
    public static String convertDecimalToBinary(String decimal){
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }
    public static String convertDecimalToHexadecimal(String decimal){

        int deci = Integer.parseInt(decimal);
        if (deci == 0) {
            return "0";
        }
        String hexa = "";
        while (deci != 0){
            hexa = hexDigits[deci % 16] + hexa;
            deci /= 16;
        }
        return hexa;
    }


    }

