package algorithm;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterAndCharacterCount {

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordMap = new HashMap<>();

        if (input == null || input.trim().isEmpty()) {
            return wordMap;
        }

        String[] words = input.trim().split("\\s+");
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        return wordMap;
    }

    public static Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> charMap = new HashMap<>();

        if (input == null) {
            return charMap;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isWhitespace(c)) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        return charMap;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content:");
        String input = sc.nextLine();

        Map<String, Integer> wordMap = countWords(input);
        Map<Character, Integer> charMap = countCharacters(input);
        System.out.println(wordMap);
        System.out.println(charMap);
        sc.close();
    }
}

/*
*public class Letter_and_character_count {

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordMap = new HashMap<>();

        if (input == null || input.trim().isEmpty()) {
            return wordMap;
        }

        // Sử dụng StringTokenizer để tách từ theo đúng gợi ý trong đề bài
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        return wordMap;
    }

    public static Map<Character, Integer> countCharacters(String input) {
        Map<Character, Integer> charMap = new HashMap<>();

        if (input == null) {
            return charMap;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Bỏ qua khoảng trắng để kết quả đếm ký tự khớp với mẫu
            if (!Character.isWhitespace(c)) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
        }

        return charMap;
    }*/