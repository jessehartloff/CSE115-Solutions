public class FunctionsLecture1 {


    // 2 points
    static double Q1(double inputNumber) {

        // You are provided a double variable named inputNumber as a parameter with an unknown value.
        //
        // TODO: Return the square root of the value stored in inputNumber


        return Math.sqrt(inputNumber);
    }

    // 3 points
    static boolean Q2(String address) {

        // You are provided a String variable named address as a parameter with an unknown value.
        //
        // TODO: Return true if address contains ".com", false otherwise.
        //
        // You do not have to check if ".com" is at the end of address, only if it's in address.


        return address.contains(".com");
    }


    public static void main(String[] args) {

        // To test, right-click this file in the side bar to the left (in eclipse), click
        // "run-as", then "Java Application". Change the values inside the parentheses to
        // test different inputs

        double inputQ1 = 16.0;
        double resultQ1 = Q1(inputQ1);
        System.out.println("Q1(" + inputQ1 + "); returned " + resultQ1);



        String trueInput = "http://stackoverflow.com";
        boolean resultQ2_1 = Q2(trueInput);
        System.out.println("Q2(" + trueInput + "); returned " + resultQ2_1);

        String falseInput = "http://wikipedia.org";
        boolean resultQ2_2 = Q2(falseInput);
        System.out.println("Q2(" + falseInput + "); returned " + resultQ2_2);

        // You can optionally use this main method to test your code without having to submit
        // This main method will not be graded

    }

}