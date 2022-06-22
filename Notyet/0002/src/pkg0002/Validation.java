
package pkg0002;

import java.util.Scanner;

public class Validation {
     Scanner sc = new Scanner(System.in);

    public int checkInt() {
        while (true) {
            System.out.print("Enter number of array: ");
            String raw = sc.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int num = Integer.parseInt(raw);
                    if (num > 1) {
                        return num;
                    } else {
                        System.err.println("You must enter in range 1");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must enter an integer ");
                }
            } else {
                System.err.println("Empty! ");
            }
        }
    }
}
