import cse115.math.Polynomial;

public class LibrariesLecture2{


    // 5 points
    static Polynomial Q1(double constant, double xCoefficient, double xSquaredCoefficient) {
        // return a new Polynomial object with the provided coefficients. The polynomial should be in
        //  the form "constant + xCoefficient*x + xSquaredCoefficient*x^2"
        //
        // Note: There is a Polynomial constructor that will take any number of doubles as inputs for the coefficients
        //       in order of increasing magnitude starting with the constant. For example:
        //       new Polynomial(1.5, 2.5) will create a Polynomial object representing "1.5 + 2.5*x"
        //       new Polynomial(0.5, 0.0, 0.0, 3.0) will create a Polynomial object representing "0.5 + 2.5*x^3"


        return new Polynomial(constant, xCoefficient, xSquaredCoefficient);
    }


    public static void main(String[] args) {

    }

}