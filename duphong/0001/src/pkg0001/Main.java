package pkg0001;

import java.util.Scanner;

/**
 * 22.04.2020
 * @author se05492
 * purpose: gọi các hàm xử lý bên Controller
 */
public class Main {

    public static void main(String[] args) {
        Controller  con = new Controller();
        int n = con.inputSizeOfArray();
        int[] a = con.inputValueOfArray(n);
        con.sortArrayByBubbleSort(a);
        con.print(a);
    }

}
