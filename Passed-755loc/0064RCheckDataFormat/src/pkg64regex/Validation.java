package pkg64regex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hoang Do Gia
 */
class Validation {

    static Scanner sc = new Scanner(System.in);

    //check input empty or not 
    public static String checkInputString() {
        //loop until user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
            } else {
                return result;
            }
        }
    }
    // Check phone number with regex

    public static String checkInputPhone(String mess, String patern) {
        while (true) {
            System.out.print(mess);
            try {
                String phoneCheck = sc.nextLine().trim();
                if (phoneCheck.matches(patern)) {
                    return phoneCheck;
                } else {
                    System.err.println("Phone number must be 10 digits");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be number");
            }
        }

    }
    //check format date (dd/MM/yyy)

    public static String checkInputDate(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                String dateCheck = checkInputString();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                df.parse(dateCheck);
                return dateCheck;
                
            } catch (ParseException ex) {
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }
    //check email with regex

    public static String checkInputEmail(String mess, String patern) {
        while (true) {
            System.out.print(mess);
            String emailCheck = checkInputString();
            if (emailCheck.matches(patern)) {
                return emailCheck;
            } else {
                System.err.println("Email must be correct format");

            }
        }
    }
}
