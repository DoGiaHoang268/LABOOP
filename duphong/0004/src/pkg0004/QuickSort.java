package pkg0004;

import java.util.Random;
import java.util.Scanner;

 /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        input();
    } 
     /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị chương trình
     */
    public static void input(){
        while(true){
            try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length); // khởi tạo số random
        }
        QuickSort sorter = new QuickSort();
        
        System.out.print("Unsorted array: ");
        sorter.displayArray(array);
        
        System.out.println();
        
        sorter.quickSort(array, 0, length - 1);
        System.out.print("Sorted array: ");
        sorter.displayArray(array);
        return;
            } catch (Exception e) {
            }
       
        }
    }

 /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị mảng ban đầu
     */
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
 /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm swap phần tử 2 bên mảng
     */
    int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2]; // chọn phần tử ở giữa mảng là pivot 

        while (i <= j) {
            while (arr[i] < pivot) { // tìm vị trí của  phần tử bên trái mảng < pivot
                i++;
            }
            while (arr[j] > pivot) { // tìm vị trí của  phần tử bên phải mảng > pivot
                j--;
            }
            if (i <= j) { // đổi vị trí 2 phần tử cho nhau
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            } 
        };
        return i;// trả về vị trí giữa mảng đang tìm kiếm
    }
 /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm sắp xếp mảng tăng dần theo thuật toán quick sort
     */
    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // sắp xếp mảng bên trái của phần tử ở giữa
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // sắp xếp mảng bên phải của phần tử ở giữa
            quickSort(arr, index, right);
        }
    }
}
