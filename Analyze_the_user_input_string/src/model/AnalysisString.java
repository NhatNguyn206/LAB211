package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisString {
    public HashMap<String, List<Integer>> getNumber(String input){

        HashMap<String, List<Integer>> numberMap = new HashMap<>();

        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();

        // Sử dụng Regular Expression để tách các chuỗi số
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            try {
                int number = Integer.parseInt(matcher.group());
                allNumbers.add(number);

                // Lọc số chẵn, số lẻ
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                } else {
                    oddNumbers.add(number);
                }

                // Lọc số chính phương (square numbers) dùng Math.sqrt
                double sqrt = Math.sqrt(number);
                if (sqrt == (int) sqrt) {
                    squareNumbers.add(number);
                }
            } catch (NumberFormatException ignored) {
                // Bỏ qua nếu số vượt quá ngưỡng Integer.MAX_VALUE
            }
        }

        numberMap.put("allNumbers", allNumbers);
        numberMap.put("evenNumbers", evenNumbers);
        numberMap.put("oddNumbers", oddNumbers);
        numberMap.put("squareNumbers", squareNumbers);

        return numberMap;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {
        HashMap<String, StringBuilder> charMap = new HashMap<>();

        StringBuilder allChars = new StringBuilder();
        StringBuilder uppercaseChars = new StringBuilder();
        StringBuilder lowercaseChars = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Bỏ qua chữ số để tập trung phân tích ký tự
            if (Character.isDigit(ch)) {
                continue;
            }

            allChars.append(ch);

            if (Character.isUpperCase(ch)) {
                uppercaseChars.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercaseChars.append(ch);
            } else {
                // Ký tự đặc biệt (Regex hoặc kiểm tra không phải chữ/số)
                specialChars.append(ch);
            }
        }

        charMap.put("allChars", allChars);
        charMap.put("uppercaseChars", uppercaseChars);
        charMap.put("lowercaseChars", lowercaseChars);
        charMap.put("specialChars", specialChars);

        return charMap;
    }
}
