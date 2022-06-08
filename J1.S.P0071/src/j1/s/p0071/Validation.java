package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public String checkInputString(String mess) {

        while (true) {
            System.out.print(mess);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");

            } else {
                return result;
            }
        }
    }

     public int checkInt(String mess,int min, int max) {
        while (true) {
            System.out.print(mess);
            String raw = sc.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.err.println("You must enter in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must enter an integer ");
                }
            } else {
                System.err.println("Empty! ");
            }
        }
    }

     public String checkDate(String mess) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(mess);
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = sdf.parse(raw);
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        return result_str;
                    } else {
                        System.err.println("Please enter a right date! ");
                    }
                } catch (ParseException e) {
                    System.err.println("Date must in format dd-MM-yyyy! ");
                }
            } else {
                System.err.println("Date can not empty! ");
            }
        }
        
    }
  

    public double checkDouble(String mess, double min, double max) {
        double result;
        while (true) {
            System.out.print(mess);
            
            try {
                result = Double.parseDouble(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.println("Between " + min + " and " + max + ".");
                }

            } catch (NumberFormatException e) {

                System.err.println("Must enter a real number ");
            }
        }
        return result;
    }

    public double checkTime(String mess) {
        while (true) {
            double time = checkDouble(mess, 8.0, 17.5);
            if (time % 0.5 == 0) {
                return time;
            } else {
                System.err.println("tithes mustm be 0 or 5");
            }
        }
    }

    public Task isIdExists(ArrayList<Task> tasks, int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
