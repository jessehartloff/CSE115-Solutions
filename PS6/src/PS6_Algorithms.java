import java.util.ArrayList;
import java.util.HashMap;

import java.util.Collections;

public class PS6_Algorithms {

	static int Q1(ArrayList<Integer> input) {
		// return the minimum value in the input ArrayList

		return Collections.min(input);
	}

	static int Q2(ArrayList<Integer> input) {
		// return the maximum value in the input ArrayList

		return Collections.max(input);
	}

	static int Q3(ArrayList<Integer> input) {
		// return the index containing the maximum value in the input ArrayList
		int max = Collections.max(input);
		return input.indexOf(max);
	}

	static double Q4(ArrayList<Integer> input) {
		// return the average of all the values in the input ArrayList
		double total = 0.0;
		for (int number : input) {
			total = total + number;
		}
		return total / input.size();
	}

	static String Q5(HashMap<String, Integer> input) {
		// return the key corresponding to the maximum value in the input
		// HashMap
		int max = Collections.max(input.values());
		for (String test : input.keySet()) {
			if (input.get(test) == max) {
				return test;
			}
		}
		return "";
	}

	static double Q6(ArrayList<Double> input) {
		// return the range (max - min) of the values in the input ArrayList

		return Collections.max(input) - Collections.min(input);
	}

	static double Q7(ArrayList<Double> input) {
		// Return the rate of change of the values of the input ArrayList. The
		// rate of change is computed with the
		// first and last element of the list using the following formula: (last
		// - first)/first
		//
		// Note: This is similar to computing ROI in hw2
		double first = input.get(0);
		double last = input.get(input.size() - 1);
		Collections.sort(input);

		return (last - first) / first;
	}

	static int Q8(ArrayList<Integer> input) {
		// Return the 2nd highest value in the input ArrayList
		/**
		 * IMPORTANT NOTE: we can't use collections.max here and just take the
		 * second to last element take this list for example {0,2,3,3} if we do
		 * that we will give the result 3 instead of the intended value of 2.
		 */
		int max = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		int carryOut = 0;
		for (int item : input) {
			if (item > max) {
				carryOut = max;
				max = item;
			}else{
				carryOut = item;
			}
			
			
			if (carryOut > secondHighest && carryOut < max) {
				secondHighest = carryOut;
			}
		}
		return secondHighest;
	}

	static int Q9(ArrayList<ArrayList<Integer>> input) {
		// Return the minimum value in the input list of lists (matrix)
		int min = Integer.MAX_VALUE;
		for(ArrayList<Integer> a : input){
			int item = Collections.min(a);
			if(item< min){
				min = item;
			}
		}
		return min;
	}

	static String Q10(ArrayList<String> input) {
		// return the longest String in the input ArrayList. Ties can be broken
		// arbitrarily
		String max = "";
		for(String s : input){
			if(s.length() > max.length()){
				max = s;
			}
		}
		return max;
	}

	static double Q11(ArrayList<Integer> input1, ArrayList<Integer> input2) {
		// return the average of all the values in both input ArrayLists
		double total = 0.0;
		double sizes = input1.size() + input2.size();
		for (int item : input1) {
			total = total + item;
		}
		for (int item : input2) {
			total = total + item;
		}
		return total / sizes;
	}

	static double Q12(HashMap<String, ArrayList<Double>> input) {
		// return the maximum value contained in any of the ArrayLists in the
		// input HashMap.
		double max  = Double.NEGATIVE_INFINITY;
		for(ArrayList<Double> AL : input.values()){
			double item = Collections.max(AL);
			if(item > max){
				max = item;
			}
		}

		return max;
	}

	static void Q13(ArrayList<Integer> input) {
		// sort the input ArrayList in increasing order
		Collections.sort(input);
	}

	static double Q14(ArrayList<Integer> input) {
		// return the median value of the input ArrayList. If the size is even,
		// return the average of the two
		// elements closests to the median
		Collections.sort(input);
		
		if(input.size()%2 == 0){
			double ele1 = input.get((input.size()/2));
			double ele2 = input.get((input.size()/2) - 1);
			return (ele1 + ele2) / 2;
		}else{
			return input.get(((input.size()-1)/2));
		}

	}

	static int Q15(ArrayList<Integer> input) {
		// return the mode value of the input ArrayList. Ties can be broken
		// arbitrarily
		HashMap<Integer,Integer>seen = new HashMap<Integer,Integer>();
		for(int i : input){
			if(seen.containsKey(i)){
				seen.put(i, seen.get(i) + 1);
			}else{
				seen.put(i, 1);
			}
		}
		
		int max = Collections.max(seen.values());
		for (int test : seen.keySet()) {
			if (seen.get(test) == max) {
				return test;
			}
		}
		

		return 0;
	}

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(0);
		test.add(2);
		test.add(3);
		test.add(3);
		System.out.println(Q8(test));
	}

}