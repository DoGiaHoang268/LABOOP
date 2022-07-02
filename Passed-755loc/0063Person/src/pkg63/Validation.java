/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg63;

import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public double getSalary(String message) {
        double salary;
        System.out.print(message);
        while (true) {
            try {
                salary = Double.parseDouble(sc.nextLine().trim());
                if (salary > 0) {
                    break;
                } else {
                    System.err.println("Salary is equal or greater than 0");
                }
            } catch (Exception e) {
                System.err.print("You must input digit: ");
            }
        }
        return salary;
    }

   
    public String getString(String mess) {       
        while (true) {
            System.out.print(mess);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.err.println("Emtpy");
            } else {
                return s;
            }
        }
        
    }

    public String checkFormatName(String mess, String parternFomart) {
        String s;
        while (true) {
            System.out.print(mess);
            s = getString(mess);
            if (s.matches(parternFomart)) {
                break;
            } else {
                System.err.println("Wrong format !!");

            }
        }
        return s;
    }
}
