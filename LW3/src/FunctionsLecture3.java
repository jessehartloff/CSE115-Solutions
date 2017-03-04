public class FunctionsLecture3 {



    // 2 points
    static boolean Q1(double m, double n) {

        // TODO: return true if m is more than double the value of n, false otherwise


        return m > n*2;
    }


    // 3 points
    static String Q2(int start, int stop) {

        // TODO: Return a String containing all the numbers from start to stop (including start and stop).
        //       Whitespace will be ignored during testing.
        //
        // Example: Q2(6, 10) should return "6 7 8 9 10" or "678910"
    	String ans = "";
    	for(int i = start; i <= stop;  ++i){
    		ans = ans + i;
    	}


        return ans;
    }




    public static void main(String[] args) {



    }

}