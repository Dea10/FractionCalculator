import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s;
        s = getOperation(new Scanner(System.in));
    }

                /* --- Methods --- */
    public static String getOperation(Scanner input) {
        String userInputOperation;
        boolean validUserInputOperation = true;

        do {
            System.out.print("Please enter an operation (+, -, /, *, =, or Q to quit): ");
            userInputOperation = input.nextLine();
            if (userInputOperation.contentEquals("+") || userInputOperation.contentEquals("-") || userInputOperation.contentEquals("/") || userInputOperation.contentEquals("*") || userInputOperation.toUpperCase().contentEquals("Q")) {
                validUserInputOperation = true;
            }else {
                validUserInputOperation = false;
            }
        }while(!validUserInputOperation);

        return userInputOperation;
    }

    public static boolean validFraction(String input) {

        String[] fraction = input.split("/");

        /*
         * one or two elements
         * b != 0
         * int elements*/

    }

    public static Fraction getFraction(Scanner input) {
        String userInputFraction;
        String[] fractionElements;
        boolean isValidFraction = true;

        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        userInputFraction = input.nextLine();

        while (validFraction(userInputFraction)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            userInputFraction = input.nextLine();
        }

        //build Fraction object
        fractionElements = userInputFraction.split("/");
        return new Fraction(Integer.valueOf(fractionElements[0]), fractionElements != null ? Integer.valueOf(fractionElements[1]) : 1);
    }
}
