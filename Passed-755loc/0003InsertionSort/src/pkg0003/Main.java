package pkg0003;

import java.util.Random;

/**
 *
 * @author Hoang Do Gia
 */
public class Main {

    public static void main(String[] args) {
        Validation va  = new Validation();
        int length = va.checkInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        Main m = new Main();
        System.out.print("Unsorted array: ");
        m.displayArray(array);
        System.out.println();
        m.insertionSort(array);
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

    public void insertionSort(int array[]) {
        int key;
        int i;
        // Compare key with each element on the left of it until an element smaller than
        // So sánh khóa với từng phần tử ở bên trái của nó cho đến khi một phần tử nhỏ hơn
        // it is found.
        //Nó được tìm thấy.
        // For descending order, change key<array[i] to key>array[i].
        // Đối với thứ tự giảm dần, đổi phím <array [i] thành key> array [i].
        for (int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            // Place key at after the element just smaller than it.
            // Đặt khóa sau phần tử nhỏ hơn nó.
            array[i + 1] = key;
        }
    }
}
