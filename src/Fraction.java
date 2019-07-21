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

        System.out.println("Num: " + this.numerator);
        System.out.println("Den: " + this.denominator);
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0);
    }

            /* --- Methods --- */

    public int getNumerator() {}

    public int getDenominator() {}

    public String toString() {}

    public double toDouble() {}

    public Fraction add(Fraction other) {}

    public Fraction substract(Fraction other) {}

    public Fraction multiply(Fraction other) {}

    public Fraction divide(Fraction other) {}

    public boolean equals(Object other) {}

    public void toLowestTerms() {}

    public int gcd(int num, int den) {}
}
