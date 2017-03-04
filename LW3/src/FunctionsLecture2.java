public class FunctionsLecture2 {



    // 2 points
    static int Q1(int n) {

        // TODO: Return the input value multiplied by 3


        return n*3;
    }


    // 3 points
    static double Q2(double x) {

        // TODO: Return the input value minus 4.5


        return x - 4.5;
    }




    public static void main(String[] args) {

        // To test, right-click this file in the side bar to the left (in eclipse), click
        // "run-as", then "Java Application". Change the values inside the parentheses to
        // test different inputs

        int inputQ1 = 4;
        int expectedOutputQ1 = 12;
        int resultQ1 = Q1(inputQ1);
        System.out.println("-- Q1 --");
        System.out.println("input: " + inputQ1);
        System.out.println("expected output : " + expectedOutputQ1);
        System.out.println("Q1 returned     : " + resultQ1);

        double inputQ2 = 10.8;
        double expectedOutputQ2 = 6.3;
        double resultQ2 = Q2(inputQ2);
        System.out.println("\n-- Q2 --");
        System.out.println("input: " + inputQ2);
        System.out.println("expected output : " + expectedOutputQ2);
        System.out.println("Q2 returned     : " + resultQ2);


    }

}