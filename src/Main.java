import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String operation;
        Fraction fraction1;

        welcome();

        operation = getOperation(new Scanner(System.in));
        fraction1 = getFraction(new Scanner(System.in));
        System.out.println(fraction1.toString());
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

    private static boolean validFraction(String input) {
        String[] fractionString;
        boolean isValid = false;

        fractionString = input.split("/");

        try {
            switch (fractionString.length) {
                case 1:
                    isValid = isNumber(fractionString[0]);
                    break;
                case 2:
                    isValid = isNumber(fractionString[0]) && isNumber(fractionString[1]) && Integer.parseInt(fractionString[1]) != 0;
                    break;
                default:
                    isValid = false;
                    break;
            }
        }catch (Exception e){
            return isValid;
        }

        return isValid;
    }

    private static Fraction getFraction(Scanner input) {
        ArrayList<String> fractionArrayList = new ArrayList<String>();
        String userInputFraction;
        String[] fractionElements;
        int numerator;
        int denominator;

        fractionArrayList.add("1");
        fractionArrayList.add("1");

        System.out.print("Please enter a fraction (a/b) or integer (a): ");

        userInputFraction = input.nextLine();

        while (!validFraction(userInputFraction)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            userInputFraction = input.nextLine();
        }

        fractionElements = userInputFraction.split("/");
        for (int i = 0; i < fractionElements.length; i++){
            fractionArrayList.set(i, fractionElements[i]);
        }

        numerator = Integer.parseInt(fractionArrayList.get(0));
        denominator = Integer.parseInt(fractionArrayList.get(1));

        return new Fraction(numerator, denominator);
    }

    private static boolean isNumber(String input) {
        try {
            return Integer.valueOf(input) instanceof Integer;
        }catch (Exception e) {
            return false;
        }
    }

    private static void welcome() {
        System.out.println("This program is a fraction calculator" +
                "\nIt will add, substract, multiply and divide fraction until you type Q to quit." +
                "\nPlease enter yout fractions in the form a/b, where a and b are integers." +
                "\n-------------------------------------------------------------------------------");
    }
}
