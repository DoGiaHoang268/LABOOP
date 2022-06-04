/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testpassword;

import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class TestPassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("enter pass: ");
            String pass = s.nextLine().trim();
            String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*).{8,31}$";
            if (pass.isEmpty()) {
                System.err.println("Empty! try again");
                continue;
            }
            if (pass.matches(regex)) {
                break;
            } else {
                System.err.println("Wrong pass! enter again");
            }
        }

    }

}
