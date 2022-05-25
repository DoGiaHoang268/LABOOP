
package pkg52country;

import Entity.EastAsianCountry;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
public class Validation {

    Scanner sc = new Scanner(System.in);
    //check data type int in this case is choice
    public int checkInt(String mess, int min, int max) {
        int number;
        while (true) {
            System.out.print(mess);
            try {
                number = Integer.parseInt(sc.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Number must in rage " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! ");
            }
        }

    }

    //check data type float in this case is area data
    public float checkFloat(String mess, float min, float max) {
        float number;
        while (true) {
            System.out.println(mess);
            try {
                number = Float.parseFloat(sc.nextLine().trim());
                if (number > min && number <= max) {
                    return number;
                } else {
                    System.err.println("Number must in rage " + min + " to " + max);
                }
            } catch (NumberFormatException e) {
                System.err.println("Must is number format!Please! ");
            }
        }
    }
    //check data type String empty or not
    public String checkString(String mess) {
        String s;
        while (true) {

            System.out.println(mess);
            s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Your input is Empty! ");

            } else {
                return s;
            }
        }

    }
    
}
