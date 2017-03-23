public class Lab3{


    public static int numberOfPayments(double amountBorrowed, double interestRatePerPayment, double paymentAmount){

        // assumes interest is computed once per pay period

        double owed = amountBorrowed;
        int payments = 0;
        while(owed > 0){
            owed += interestRatePerPayment * owed;
            owed -= paymentAmount;
            payments++;
        }

        return payments;
    }


    // Part 1
    public static int totalPayments(double amountBorrowed, double apr, double monthlyPayment){
        // TODO return number of monthly payments to payoff the debt
        return numberOfPayments(amountBorrowed, apr / 12.0, monthlyPayment);
    }


    // Part 2 (Critical thinking question. Solution was not required if you made an honest attempt to write the method)
    public static double paymentAmount(double amountBorrowed, double apr, int numberOfMonths){
        // TODO return the monthly payment amount for this debt

        // The proper answer is to code the equation for monthly payments (http://www.1728.org/loanform.htm), but the
        // intent of this problem was to get you to think about a difficult problem and develop a potential solution.
        // Below is an approach that would be expected at this point of the course.

        // Estimates the monthly payment by repeatedly guessing the monthly payment amount and checking if
        // it would take approximately the right number of months. Starting guess must be enough to cover the interest
        // or the loop will be infinite. Exact starting guess and amount to increase the guess at each iteration are
        // somewhat arbitrary
        double monthlyRate = apr / 12.0;

        // Initial guess is slightly more than enough to cover the monthly interest
        double monthlyPaymentGuess = (1.0 + monthlyRate) * amountBorrowed * monthlyRate;
        while(totalPayments(amountBorrowed, apr, monthlyPaymentGuess) > numberOfMonths){
            // Increase the guess by 5%
            monthlyPaymentGuess *= 1.05;
        }
        return monthlyPaymentGuess;
    }


    public static void main(String[] args){
        double borrowedAmount = 20000.0;
        double apr = 0.05;

        double paymentAmount = 325.0;
        System.out.println("Number of payments: " + totalPayments(borrowedAmount, apr, paymentAmount));


        int numberOfPayments = 72;
        System.out.println("Payment amount: " + paymentAmount(borrowedAmount, apr, numberOfPayments));

    }

}
