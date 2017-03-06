import java.util.ArrayList;
import java.util.Collections;

public class AlgorithmsLecture1 {


    // 5 points
    static double Q1(ArrayList<Double> input) {
        // return the minimum value in the input ArrayList
    	
    	//this is the fastest and most compact solution
        //return Collections.min(input);
    	double min = Double.POSITIVE_INFINITY;
    	for(Double d : input){
    		if(min > d){
    			min = d;
    		}
    	}
    	
    	return min;
    	
    }


    public static void main(String[] args) {

    }

}