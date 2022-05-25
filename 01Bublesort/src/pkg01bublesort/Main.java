package pkg01bublesort;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    private static int CheckInputInt() {
        while (true) {

            try {
                int Result = Integer.parseInt(in.nextLine().trim());
                if (Result > 0) {
                    return Result;

                } else {
                    System.err.println("Please enter number large than 0!");
                    System.out.print("Enter number of array: ");
                }

            } catch (Exception e) {
                System.err.println("Please input a number!");
                System.out.print("Enter number of array: ");
                
            }
        }
    }

    private static int inputSizeOfArray() {

        System.out.print("Enter number of array: ");
        int n = CheckInputInt();
        return n;

    }

    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(n);
        }
        return a;
    }

    private static void sortArrayByBubbleSort(int[] a) {
        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    private static void Print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");

        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int[] a = inputValueOfArray(n);
        sortArrayByBubbleSort(a);
        Print(a);
    }
// 4 4 0 5 1
/*
4 4 0 5 1
4 0 4 5 1
4 0 4 5 1 
4 0 4 1 5 
    
0 4 4 1 5
0 4 4 1 5
0 4 1 4 5
    
0 4 1 4 5 
0 1 4 4 5

0 1 4 4 5     
    
    
    */
}
