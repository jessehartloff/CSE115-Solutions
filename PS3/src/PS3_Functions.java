import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class PS3_Functions {


    static String Q1(String name){

        // return "Hello <name>!"

        return "Hello " + name + "!";
    }

    static int Q2(String input){

        // return the length of the input

        return input.length();
    }

    static String Q3(String input){

        // return the input in all lowercase letters
        return input.toLowerCase();
    }

    static String Q4(String input){

        // return the input in all uppercase letters
        return input.toUpperCase();
    }

    static String Q5(String input){

        // return the reverse of the string
    	String reverse = "";
    	for(int i =input.length() - 1; i >= 0 ; i = i - 1){
    		reverse = reverse + input.toCharArray()[i];
    	}
        return reverse;
    }

    static int Q6(int input){
        // return input time 2
        return input * 2;
    }

    static double Q7(double input){
        // return input divided by 7
        return input /7;
    }

    static double Q8(int input){
        // return input times 1.05
        return input * 1.05;
    }

    static double Q9(double input){
        // return the cosine of input. The input is given in radians
        return Math.cos(input);
    }

    static boolean Q10(int input){
        // return true if the input is 21 or over, false otherwise
    	if(input >= 21){
    		return true;
    	}
        return false;
    }

    static int Q11(int input1, int input2){
        // return input1 minus input2
    	
        return input1 - input2;
    }

    static String Q12(String input, int times){
        // return the input concatenated times number of times
    	String ans = "";
    	for(int i = 0; i < times; i = i + 1){
    		ans = ans + input;
    	}
        return ans;
    }

    static double Q13(double input1, double input2){
        // return input1 raised to the input2 power
        return Math.pow(input1, input2);
    }

    static double Q14(String input, double number){
        // return the length of the input string times number
        return input.length() * number;
    }

    static String Q15(boolean bool, String input){
        // if bool is true, return the input in all lowercase letters
        // if bool is false, return the input in all uppercase letters
    	if(bool == true){
    		input = input.toLowerCase();
    	}else{
    		input = input.toUpperCase();
    	}
        return input;
    }


    public static void main(String[] args) {
        System.out.println(Q12("Beetlejuice.", 3));

        // You can use this main method to test your code without having to submit.
        // This main method will not be graded

    }

}
