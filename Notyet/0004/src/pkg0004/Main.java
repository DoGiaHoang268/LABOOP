/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0004;

import java.util.Random;

/**
 *
 * @author Hoang Do Gia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation va = new Validation();
        int length = va.checkInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        Main m = new Main();
        System.out.print("Unsorted array: ");
        m.displayArray(array);
        System.out.println();
        m.quickSort(array, 0, length - 1);
        System.out.print("Sorted array: ");
        m.displayArray(array);
        System.out.println("");
    }
    //display aray
    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    // method to find the partition position
    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
           // Look at until all values in left array are less than pivot
           //tìm kiếm đến khi tất cả giá trị trong mảng bên trái nhỏ hơn pivot
            while (arr[i] < pivot) {
                i++;
            }
            // Look at until all values in the right array are greater than pivot
            // Tìm kiếm cho đến khi tất cả các giá trị trong mảng bên phải lớn hơn pivot 
            while (arr[j] > pivot) {
                j--;
            }
            //swap
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
//qicksort
    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        
        if (left < index - 1) {
            // recursive call on the left of pivot
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            // recursive call on the right of pivot
            quickSort(arr, index, right);
        }
    }
}
