/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0001;

import java.util.Scanner;

/**
 * 22.04.2020
 *
 * @author SE05492
 */
public class Controller {

    private static final Scanner in = new Scanner(System.in);

    /**
     * 22.04.2020
     * check user input a number integer
     * @author SE05492
     */
    public int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                //check so nhap khac 0
                if (result == 0) {
                    System.err.println("Please input number");
                    System.out.print("Enter again: ");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                // thông báo lỗi
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * 22.04.2020
     * allow user input number of array
     * @author SE05492
     */
//
    public int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    /**
     * 22.04.2020
     * allow user input value of array
     * @author SE05492
     */
    //
    public int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { // vong lap tu dau cho den n-1
            System.out.print("Enter a[" + i + "]: ");
            a[i] = checkInputInt();
        }
        return a;
    }

    /**
     * Date 22.04.2020 
     * sort array by bubble sort
     * @author SE05492
     */
    public void sortArrayByBubbleSort(int[] a) {
        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) { // vong lap hien thi chuoi ban dau
            System.out.print(a[i] + " ");
        }
        // sap xep
        for (int i = 0; i < a.length; i++) { // vong lap 0 den n-2
            for (int j = 0; j < a.length - i - 1; j++) { // vong lap 0 den n - i - 1
                //thuat toan sap xep 2 so canh nhau
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("");
    }

    /**
     * 22.04.2020 
     * display array after sort
     *
     * @author SE05492
     */
    //display array after sort
    public void print(int[] a) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
