import java.util.ArrayList;
import java.util.HashMap;

public class PS4_DataStructures {


    static int Q1(ArrayList<Integer> listOfNumbers){
        // return the number of integers in listOfNumbers

        return listOfNumbers.size();
    }

    static void Q2(ArrayList<String> input){
        // add the String "movie" to the end of the input list
    	input.add("movie");
    }

    static int Q3(ArrayList<Integer> input, int index){
        // return the element at index i from the input list
        // You can assume the input contains at least i+1 values

        return input.get(index);
    }

    static boolean Q4(ArrayList<Integer> input, int value){
        // return true if value is in the input list, false otherwise

        return input.contains(value);
    }

    static String Q5(ArrayList<String> words){
        // return a string containing every word of the input concatenated into a single String and separated by spaces
        // Example: If the input is ["war", "never", "changes"] the output is "war never changes"
    	String done = "";
    	for (int i = 0; i < words.size() - 1; i++) {
    		done = done + words.get(i) + " ";
			
		}
    	done = done + words.get(words.size() - 1);
        return done;
    }

    static ArrayList<Integer> Q6(){
        // Create and return an ArrayList of the integers 1 through 10 (including 1 and 10)
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 1; i <= 10; i++){
    		list.add(i);
    	}
        return list;
    }

    static ArrayList<String> Q7(){
        // create and return an ArrayList of Strings containing the strings "memory", "is", "the", "key" in that order
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("memory");
    	list.add("is");
    	list.add("the");
    	list.add("key");
        return list;
    }

    static void Q8(HashMap<String, Integer> input, String key, int value){
        // add an entry into the map with the the given key and value
    	input.put(key, value);
    }

    static boolean Q9(HashMap<Integer, Boolean> input, int key){
        // return the value in the input map at the given key

        return input.get(key);
    }

    static boolean Q10(HashMap<String, Integer> input, int value){
        // return true if value is in the input map as a value at any key, false otherwise

        return input.values().contains(value);
    }

    static int Q11(HashMap<String, Double> input){
        // return the number of entries in the input map

        return input.size();
    }

    static ArrayList<Integer> Q12(HashMap<String, Integer> input){
        // return a list of all values in the input map
        // Note: input.values() returns a Collection, but you must return an ArrayList
    	//    	ArrayList<Integer> list = new ArrayList<Integer>(input.values());
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i: input.values()) {
			list.add(i);
		}
        return list;
    }

    static ArrayList<String> Q13(HashMap<String, Integer> input){
        // return a list of all keys in the input map
        // Note: input.keySet() returns a Set, but you must return an ArrayList
//    	ArrayList<String> list = new ArrayList<String>(input.keySet());
    	ArrayList<String> list = new ArrayList<String>();
    	for(String k: input.keySet()){
        	list.add(k);
    	}
        return list;
    }

    static boolean Q14(HashMap<Integer, Integer> input, int key){
        // return true if key is a key in the input map, false otherwise

        return input.containsKey(key);
    }

    static int Q15(HashMap<Integer, Integer> input, int value){
        // return the number of times value is in the input map as a value
    	int total = 0;
    	for (int i: input.values()) {
			if(i == value){
				total++;
			}
		}
        return total;
    }


    public static void main(String[] args) {

    }


}