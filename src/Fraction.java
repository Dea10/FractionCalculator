public class Fraction {

    public int numerator;
    public int denominator;

            /* --- Constructors --- */

    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        try {
            if (denominator == 0){
                throw new IllegalArgumentException("Denominator can't be 0");
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }catch (IllegalArgumentException e){
            System.out.println("Exception: " + e.getMessage());
        }

        if (this.denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        }
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0);
    }

            /* --- Methods --- */
/*
    public int getNumerator() {}

    public int getDenominator() {}

    public String toString() {}

    public double toDouble() {}

    public Fraction add(Fraction other) {}

    public Fraction substract(Fraction other) {}

    public Fraction multiply(Fraction other) {}

    public Fraction divide(Fraction other) {}
*/
    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            if((double)((Fraction) other).numerator/(double)((Fraction) other).denominator != (double)this.numerator/(double)this.denominator){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

    public void toLowestTerms() {
        int numeratorTemp = this.numerator;
        this.numerator = this.numerator / gcd(numeratorTemp, this.denominator);
        this.denominator = this.denominator / gcd(numeratorTemp, this.denominator);
    }

    public static int gcd(int num, int den) {
        int remainder;
        while (num != 0 && den != 0) {
            remainder = num % den;
            num = den;
            den = remainder;
        }
        return num;
    }
}
