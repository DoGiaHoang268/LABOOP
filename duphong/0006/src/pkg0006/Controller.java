package pkg0006;

import java.util.Random;
import java.util.Scanner;

/**
 * Date 28.04.2020
 * @author HungtdSE05492 
 * purpose : class xu ly
 */
public class Controller {
    /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị chương trình
     */
    public static void input() {
        while (true) { // vòng lặp nhập cho đến khi số nhập vào hợp lệ
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter number of array:");
                int length = scanner.nextInt(); // nhập số mảng từ bàn phím
                scanner.nextLine();
                int[] array = new int[length];
                if (length != 0) { // kiểm tra độ dài mảng
                    displayRandom(array, length);
                    bubbleSort(array); // gọi hàm sắp xếp mảng
                    displayArray(array); // hiển thị mảng đã sắp xếp       
                    displaySreach(array); // gọi hàm tìm kiếm phần tử trong mảng
                    System.out.println("");
                    break;
                } else {
                    System.err.println("please enter again");
                }
                //--------------------
            } catch (Exception e) {
                System.err.println("please enter again");
            }
        }
    }
         /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị giá trị đầu tiên mảng random 
     */
 public static void displayRandom(int[] array, int length2) {
                     System.out.print("The old array: [");
                    // vòng lặp tạo số random vào mảng
                    for (int i = 0; i < length2; i++) { // vòng lặp chạy từ 0 đến hết phần tử mảng
                        array[i] = new Random().nextInt(length2); // tạo số random
                        System.out.print(array[i]);
                        if (i < array.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.print("]");
 }
     /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị phần tử sreach sau khi sắp xếp
     */
    public static void displaySreach(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter search value:");
        int search = scanner.nextInt();  // nhập vào số cần tìm 
        int size = array.length;
        System.out.print("Found " + search + " at index: " + binarySearch(array,search,0,size-1));
        
//        boolean first = true;
//        for (int i = 0; i < size; i++) { // vòng lặp tìm vị trí
//            if (search == array[i]) { // so sánh số cần tìm với i trong mảng            
//                if(first){ // đánh dấu vị trí đầu tiên
//                    System.out.print(i);
//                    first = false;
//                }
//                else {
//                System.out.print(", ");
//                System.out.print(i);             
//                }
//            }
//        }
    }
      /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm tìm kiếm nhị phân 
     */
    static int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) { // không tìm thấy vị trì nào 
            return -1;
        }
        int middle = (left + right) / 2; // tìm vị trí ở giữa
        if (array[middle] == value) { // so sánh phần tử giữa mảng với giá trị cần tìm
            return middle; // trả về vị trí phần tử giữa mảng nếu = giá trị cần tìm
        } else if (array[middle] > value) { // lặp lại quá trình với mảng bên trái phần tử ở giữa nếu value < phần tử ở giữa
            return binarySearch(array, value, left, middle - 1); 
        } else { // lặp lại quá trình với mảng bên phải phần tử ở giữa nếu value > phần tử ở giữa
            return binarySearch(array, value, middle + 1, right);
        }
    }
    /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm hiển thị mảng ban đầu
     */
    public static void displayArray(int[] arr) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) { // vòng lặp chạy từ 0 đến hết mảng
            System.out.print(arr[i]); 
            if (i < arr.length - 1) {
                System.out.print(", "); // hiển thị dấu , sau mỗi số
            }
        }
        System.out.print("]");
    }

    /**
     * Date 28.04.2020
     * @author HungtdSE05492 
     * purpose: hàm sắp xếp mảng tăng dần sử dụng thuật
     * toán bubblesort
     */
    public static void bubbleSort(int[] a) {
        // sap xep
        for (int i = 0; i < a.length; i++) { // vong lap 0 den n-2
            for (int j = 0; j < a.length - i - 1; j++) { // vong lap 0 den n - i - 1
                //thuat toan sap xep 2 so canh nhau
                if (a[j] > a[j + 1]) { // so sánh 2 vị trí đầu tiên 
                    int temp = a[j];
                    a[j] = a[j + 1]; // chuyển về vị trí sau
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("");
    }
}
