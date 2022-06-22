package pkg0006;

import java.util.Random;
import java.util.Scanner;

public class Controller {

    public static void displayRandom(int[] array, int length2) {
        System.out.print("The old array: [");
        for (int i = 0; i < length2; i++) {
            array[i] = new Random().nextInt(length2);
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void displaySearch(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter search value:");
        int search = scanner.nextInt();
        int size = array.length;
        int result = binarySearch(array, search, 0, size - 1);
        if (result == -1) {
            System.err.println("Not Found");
        } else {
            System.out.println("Found " + search + " at index: " + result);
        }

    }

    static int binarySearch(int[] array, int value, int left, int right) {
        int middle = (left + right) / 2;
        if (left > right) {
            return -1;
            // Nếu phần tử có ở chính giữ
        } else if (array[middle] == value) {
            
            return middle;
        } else if (array[middle] > value) {
            // Ngược lại, phần tử chỉ có thể có mặt
            // trong mảng con bên phải
            return binarySearch(array, value, left, middle - 1);
        } else {
            
            // Nếu phần tử nhỏ hơn giữa, thì nó chỉ có thể
            // hiện diện trong mảng con bên trái
            return binarySearch(array, value, middle + 1, right);
        }
//        if (right >= left) {
//            int middle = left + (right - left) / 2;
//            if (array[middle] == value) {
//                return middle;
//            } else if (array[middle] > value) {
//                return binarySearch(array, value, left, middle - 1);
//            }
//            return binarySearch(array, value, middle + 1, right);
//        }
//
//        return -1;
    }

    public static void displayArray(int[] arr) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void bubbleSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        //System.out.println("");
    }
}
