import java.util.HashMap;

public class DataStructuresLecture2 {


    // 2 points
    static boolean Q1(HashMap<Character, Integer> inputMap) {

        // TODO: Return true if inputMap has more than 2 key-value pairs, false otherwise


        return inputMap.size() > 2;
    }


    // 3 points
    static HashMap<String, Integer> Q2(String key, int value) {

        // TODO: Return a new HashMap containing the input value at the input key as its only key-value pair
    	
    	HashMap<String, Integer> ans = new HashMap<String, Integer>();
    	ans.put(key, value);
        return ans;
    }


    public static void main(String[] args) {


    }

}