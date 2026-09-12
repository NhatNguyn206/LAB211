package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BinarySearchAlgorithm {

    public static int checkInputInt(String prompt) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println(prompt);
                int size = Integer.parseInt(sc.nextLine().trim());
                if (size > 0) {
                    return size;
                }
                System.out.println("Please input a positive number!");
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
                System.out.println("Enter again: ");
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10) + 1;
        }
        return arr;
    }
    public static void sortArrayByBubbleSort(int[] arr){
    boolean swapped;
    for (int i = 0; i < arr.length-1; i++) { 
        swapped=false;
        for (int j = 0; j < arr.length-i-1; j++) {
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                swapped=true;
            }
            
        }
        if(!swapped){
            break;
        }
        
    }
           
}  
    public static int binarySearch(int[] arr, int value , int left , int right){
        if (left >right){
            return -1;
        }
        int middle = (left+right)/2;
        if (arr[middle]==value){
            return middle;
        }else if (arr[middle]>value){
            return binarySearch(arr,value,left,middle-1);

        }else{
            return binarySearch (arr,value,middle+1,right);
        }
    }
     
    
    public static void main(String[] args) {
        int n = checkInputInt("Enter number of array:");
        int[] arr=generateRandomArray(n);
        sortArrayByBubbleSort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
        int searchValue = checkInputInt("Enter search value:");


        int index = binarySearch(arr,searchValue,0,arr.length-1);
        if(index!=-1){
            System.out.println("Found "+searchValue+" at index: "+index);
        }else{
            System.out.println("Not found "+searchValue+" in the array.");
        }
    }
    

}
