/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg55;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Validation {
    Scanner sc = new Scanner(System.in);
    
   public int checkInt(String message, int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(message);
                number =Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) {
                    break;
                } else {
                 System.err.println("Please enter number from " + min + " to " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Number wrong format!");
            }
        }
        return number;
    }
    public boolean checkExistedDoctor(ArrayList<Doctor> list,String code){
        for (Doctor doctor : list) {
            return doctor.getCode().equals(code);
        }
        return false;
    
    }
}
