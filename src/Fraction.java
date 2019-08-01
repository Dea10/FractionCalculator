public class Fraction {

    private int numerator;
    private int denominator;

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

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        return this.numerator == 0 ? "0" : this.numerator == this.denominator ? "1" : this.numerator + "/" + this.denominator;
    }

    public double toDouble() {
        return (double) this.numerator / (double) this.denominator;
    }

    public Fraction add(Fraction other) {
        int num = this.numerator * other.denominator + this.denominator * other.numerator;
        int den = this.denominator * other.denominator;

        Fraction result = new Fraction(num, den);
        result.toLowestTerms();

        return result;
    }

    public Fraction substract(Fraction other) {
        int num = this.numerator * other.denominator - this.denominator * other.numerator;
        int den = this.denominator * other.denominator;

        if (this.equals(other)) {
            return new Fraction(0);
        }

        Fraction result = new Fraction(num, den);
        result.toLowestTerms();

        return result;
    }

    public Fraction multiply(Fraction other) {
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;

        Fraction result = new Fraction(num, den);
        result.toLowestTerms();

        return result;
    }

    public Fraction divide(Fraction other) {
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;

        Fraction result = new Fraction(num, den);
        result.toLowestTerms();

        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            if(((Fraction) other).toDouble() != this.toDouble()){
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
