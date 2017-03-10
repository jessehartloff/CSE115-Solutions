import java.util.ArrayList;

public class AlgorithmsLecture2 {


    // 5 points
    static boolean Q1(ArrayList<String> input, String toFind) {

        // return true if the input ArrayList contains a String with the same value as toFind, false otherwise
        // Note: you must use .equals to compare Strings for equal values, not ==
    	//this will solve the problem as well
    	//return input.contains(toFind);

    	for(String s: input){
    		if(s.equals(toFind)){
    			return true;
    		}
    	}
        return false;
    }


    public static void main(String[] args) {

    }

}