package pkg09fibo;

import java.util.Scanner;

public class Main {
    
    public static int fibonacci(int index) {
        if (index == 1) {
            return 0;
        } else if (index == 2) {
            return 1;
        } else {
            return fibonacci(index - 2) + fibonacci(index - 1);
        }
        
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 45; i++) {
            System.out.print(fibonacci(i)+",");
        }
        
    }
}
