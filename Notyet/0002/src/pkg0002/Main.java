package pkg0002;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Validation va  = new Validation();
        int length = va.checkInt();
        int[] arr = new int[length];
        Main.displayRandom(arr, length);
        Main.seclectionSort(arr);
        Main.displayArr(arr);

    }

    public static void displayRandom(int[] arr, int length) {
        System.out.print("The array: ");
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(length);
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void seclectionSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void displayArr(int[] arr) {
        System.out.print("Sort array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
