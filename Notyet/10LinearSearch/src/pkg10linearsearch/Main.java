/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg10linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    /**/
    public static void main(String[] args) {
        LinearSeach li = new LinearSeach();
        DataInput d = new DataInput();
        int size = d.checkInt("input size:",0,Integer.MAX_VALUE);
        int[] array = new int[size];
        
        int value=d.checkInt("Input value: ",0,Integer.MAX_VALUE);
        li.rvalue(array, size);
        System.out.println("Found " + value + " at index: "+li.Search(array, value));
        
    }
}
