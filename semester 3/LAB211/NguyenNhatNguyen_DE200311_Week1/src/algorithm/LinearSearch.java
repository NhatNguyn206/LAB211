package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    public static int checkInputPositiveNumber() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                int size = Integer.parseInt(sc.nextLine());
                if (size > 0) {
                    return size;
                }
                System.out.println("Please input a positive number!");
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
                System.out.println("Enter again:");
            }
        }
    }

    public static int[] generateRandomArray (int size){
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=random.nextInt(10)+1;
        }
        return arr;
    }

    public static int linerSearch(int[] arr, int key) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

        public static void main (String[]args) {
            System.out.println("Enter number of array:");
            int n = checkInputPositiveNumber();
            int[] arr = generateRandomArray(n);
            System.out.println("The array: " + Arrays.toString(arr));
            System.out.println("Enter search value:");
            int value = checkInputPositiveNumber();
            int result = linerSearch(arr, value);
            if (result != -1) {
                System.out.println("Found " + value + " at index " + result);
            } else
                System.out.println("Not found " + value + " in the array.");
        }


}