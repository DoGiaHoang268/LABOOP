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

    public int checkInt(String mess, int min, int max) {
        int result;
        while (true) {
            System.out.print(mess);
            try {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    System.err.println("Out of range! please enter in range "
                            + "[" + min + "," + max + "] ");
                }
            } catch (NumberFormatException e) {
                System.err.println("Must enter a real number ");
            }

        }
        return result;
    }

    public String checkDate(String mess) {

        SimpleDateFormat formatIn = new SimpleDateFormat("dd-MM-yyyy");
        formatIn.setLenient(false);
        while (true) {
            System.out.print(mess);
            try {
                Date date = formatIn.parse(sc.nextLine().trim());
                SimpleDateFormat formatOut = new SimpleDateFormat("dd-MM-yyyy");
                String strDate = formatOut.format(date);
                return strDate;

            } catch (ParseException e) {
                System.err.println("Please input valid date (dd-MM-yyyy) ");
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
            double time = checkDouble(mess, 8, 17.5);
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
