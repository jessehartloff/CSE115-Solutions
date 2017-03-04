public class ControlFlowLecture3 {



    // 5 points
    static void Q1(int n) {

        int hackNumber = n;
        // You are provided an int variable named hackNumber with an unknown value.
        //
        // TODO: print the numbers 0 through 50 to the screen (including 0 and 50), except
        //       if a number is equal to hackNumber print 1337 instead of the number. Your
        //       code must work for any value of hackNumber.
        //
        // Example: is hackNumber stores the value 44 you should print the
        //          numbers 0 through 50, except replace 44 with 1337

        for (int i = 0; i < 51; i++) {
        	if(i == hackNumber){
        		System.out.println("1337");
        	}else{
    			System.out.println(i);
        	}

		}


    }




    public static void main(String[] args) {

        // Call Q1 to test the output. We will explain this is more detail next week.
        // To test, right-click this file in the side bar to the left (in eclipse), click
        // "run-as", then "Java Application". Change the value inside the parentheses to
        // test different values of hackNumber
        Q1(10);

        // You can optionally use this main method to test your code without having to submit
        // This main method will not be graded

    }

}