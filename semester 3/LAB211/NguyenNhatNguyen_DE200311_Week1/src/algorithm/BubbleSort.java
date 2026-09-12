
package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BubbleSort {
    public static int checkInputInt(){
        while (true){
            Scanner sc = new Scanner(System.in);
            try {
                int size = Integer.parseInt(sc.nextLine().trim());
                if(size>0){
                return size;
                }
                System.out.println("Please input a positive number!");
            } catch (NumberFormatException e) {
                System.out.println("Please input again!");
                System.out.println("Enter again: ");
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

    public static void main(String[] args) {
        System.out.println("Enter number of array:");
        int n = checkInputInt();
        int[] arr=generateRandomArray(n);
        System.out.println("Unsorted array: "+Arrays.toString(arr));
        sortArrayByBubbleSort(arr);
        System.out.println("Sorted array: "+Arrays.toString(arr));
        
    }
        
    
    
    
}
