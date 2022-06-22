package pkg0006;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Validation va  = new Validation();
        int length = va.checkInt();
        int[] array = new int[length];
        Controller.displayRandom(array, length);
        Controller.bubbleSort(array);
        Controller.displayArray(array);
        Controller.displaySearch(array);

    }
}
