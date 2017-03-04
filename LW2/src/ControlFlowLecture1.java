public class ControlFlowLecture1 {



    // 2 points
    static boolean Q1(int input) {

        int number = input;
        // TODO: You are provided an int variable called number containing an unknown value.
        //       If the value of number is >= 20, return the boolean value true.
        //       If the value of number is < 20, return the boolean value false.
        //
        // Note: The value of number is provided through a parameter of a method call, but you can ignore this
        //       detail until we cover functions next week.



        return number >= 20;
    }



    // 3 points
    static String Q2(double input) {

        double number = input;
        String output = "";
        // TODO: You are provided a double variable called number containing an unknown value.
        //       If the value of number is < 5.0, set the value of output to "less than 5".
        //       If the value of number is >= 5.0 and <= 10.0, set the value of output to "between 5 and 10".
        //       If the value of number is > 10.0, set the value of output to "greater than 10".
        //
        // Note: The value of number is provided through a parameter of a method call, but you can ignore this
        //       detail until we cover functions next week.
        if(number < 5.0){
        	output = "less than 5";
        }
        if(number >= 5.0){
        	output = "between 5 and 10";
        }
        if(number > 10.0){
        	output = "greater than 10";
        }

        return output;
    }




    public static void main(String[] args) {

        // You can optionally use this main method to test your code without having to submit
        // This main method will not be graded

    }

}