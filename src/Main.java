public class Main {

    public static void main(String[] args) {
        Fraction myFrac = new Fraction(105, 147);
        Fraction otherFrac = new Fraction(5, 7);

        System.out.println("Num: " + myFrac.numerator);
        System.out.println("Den: " + myFrac.denominator);

        System.out.println("Equals: " + myFrac.equals(4));
        System.out.println("Equals: "+ myFrac.equals(otherFrac));

        myFrac.toLowestTerms();

        System.out.println("tlt Num: " + myFrac.numerator);
        System.out.println("tlt Den: " + myFrac.denominator);
    }
}
