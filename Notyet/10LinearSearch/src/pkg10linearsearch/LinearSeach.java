/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10linearsearch;

import java.util.Random;

/**
 *
 * @author Hoang Do Gia
 */
public class LinearSeach {

    public void Search(int[] array, int value) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                check = true;
                break;
            }
        }
        if (check == true) {
            System.out.print("Found " + value + " at index: ");
            for (int i = 0; i < array.length; i++) {
                if (value == array[i]) {
                    System.out.print(i);
                    if (i<array.length-1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println("");
        } else if (check == false) {
            System.err.println("Not Found!");
        }
    }

    public void rvalue(int[] array, int size) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(size);
            System.out.print(array[i]);
            if (i<array.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}
