import java.util.ArrayList;

public class DataStructuresLecture1 {


    // 2 points
    static boolean Q1(ArrayList<Double> inputList) {

        // TODO: Return true if inputList is empty, false otherwise


        return inputList.isEmpty();
    }


    // 3 points
    static ArrayList<Integer> Q2(int value) {

        // TODO: Return a new ArrayList containing value as its only element
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	ans.add(value);
    	
        return ans;
    }


    public static void main(String[] args) {


    }

}