
/**
 *
 * @author Hoang Do Gia
 */
public class Controller {
//Normal Caculator

    public void normalCaculator() {
        System.out.println("----- Normal Calculator -----");
        double firstNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        while (true) {
            String opertor = Validation.CheckOperator("Enter Operator: ");
            if (opertor.equalsIgnoreCase("=")) {
                System.out.println("Result= " + firstNumber);
                break;

            }
            double secondNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

            if (opertor.equalsIgnoreCase("+")) {
                firstNumber += secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            else if (opertor.equalsIgnoreCase("-")) {
                firstNumber -= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            else if (opertor.equalsIgnoreCase("/")) {
                while (secondNumber == 0) {
                    System.out.println("Cannot device for zero");
                    secondNumber = Validation.checkDouble("Enter number: ", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                }
                firstNumber /= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            else if (opertor.equalsIgnoreCase("*")) {
                firstNumber *= secondNumber;
                System.out.println("Memory:" + firstNumber);
            }
            else {
                firstNumber = Math.pow(firstNumber, secondNumber);
                System.out.println("Memory:" + firstNumber);
            }

        }

    }
    //bmiCaculator

    public void bmiCaculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = Validation.checkDouble("Enter Weight(kg):", 1, Double.POSITIVE_INFINITY);
        double height = Validation.checkDouble("Enter Height(cm)):", 1, Double.POSITIVE_INFINITY) / 100; //change cm -->m
        double bmi = weight / (height * height);
        System.out.println("BMI Number: " + bmi);
        if (bmi < 19) {
            System.out.println("BMI Status: Under-standard.");
        } else if (bmi < 25) {
            System.out.println("BMI Status: Standard.");
        } else if (bmi < 30) {
            System.out.println("BMI Status: Overweight.");
        } else if (bmi < 40) {
            System.out.println("BMI Status:Fat - should lose weight.");
        } else {
            System.out.print("BMI Status:Very fat - should lose weight immediately.");
        }
    }

}
