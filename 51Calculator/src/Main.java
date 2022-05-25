
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller co = new Controller();
         while (true) {
               System.out.println("========= Calculator Program =========\n"
                + "1. Normal Calculator\n"
                + "2. BMI Calculator\n"
                + "3. Exit");
        int choice = Validation.checkInt("Please choice one option:", 1, 3);
            switch (choice) {
                case 1:
                    co.normalCaculator();
                    break;
                case 2:
                    co.bmiCaculator();
                    break;
                case 3:
                    return;

            }
        }
    }
    
}
