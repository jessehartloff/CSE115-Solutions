import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class DataStructuresLecture3 {


    // 2 points
    static int Q1(ArrayList<Integer> inputList) {

        // TODO: Return the sum (addition) of all the elements of inputList
    	int ans = 0;
    	for(int i = 0; i < inputList.size(); ++i){
    		ans = ans + inputList.get(i);
    	}

        return ans;
    }


    // 3 points
    static int Q2(HashMap<String, Integer> inputMap) {

        // TODO: Return the sum (addition) of all the values of inputMap
    	int ans = 0;
    	for(Integer i : inputMap.values()){
    		ans = ans + i;
    	}

        return ans;
    }


    static void checkResult(int result, int expected){
        if(result == expected){
            System.out.println("Correct!");
        }else{
            System.out.println("Result on numbers is " + result + ", should be "+ expected);
        }
    }

    public static void main(String[] args) {

        // Example testing code. Testing code will not always be provided as testing your own code is a very important
        // skill to learn. You should refer to this as an example of testing for future assignments. This code shows
        // several different ways to test a method with increasing complexity.


        // Standard way to test

        System.out.println("Testing Q1 with (4, 7, 3)");

        ArrayList<Integer> input0 = new ArrayList<Integer>();
        input0.add(4);
        input0.add(7);
        input0.add(3);

        int firstResult = Q1(input0);

        if(firstResult == 14){
            System.out.println("Correct!");
        }else{
            System.out.println("Result is " + firstResult + ", should be 14");
        }


        // Test using a method call to check the result. We also call Q1 inside the method call to avoid storing the
        // result in a variable

        System.out.println("\nTesting Q1 with (40, 60)");
        ArrayList<Integer> input1 = new ArrayList<Integer>();
        input1.add(40);
        input1.add(60);

        checkResult(Q1(input1), 100);


        // Initializing an ArrayList in one line for more compact code

        System.out.println("\nTesting Q1 with (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)");
        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        checkResult(Q1(input2), 55);


        // Full test in one line

        System.out.println("\nTesting Q1 with (-50, 70, -25, 5)");
        checkResult(Q1(new ArrayList<Integer>(Arrays.asList(-50, 70, -25, 5))), 0);


        // Test for Q2

        System.out.println("\nTesting Q2 with {nine=9, four=4, six=6, seven=7, ten=10, two=2, three=3, five=5, eight=8}");
        HashMap<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);

        int expected = 55;
        int result = Q2(numbers);

        if(result == expected){
            System.out.println("Correct!");
        }else{
            System.out.println("Result is " + result + ", should be "+ expected);
        }


        // More compact test for Q2

        System.out.println("\nTesting Q2 with {Q1=2, Q2=3}");

        HashMap<String, Integer> questionScores = new HashMap<String, Integer>();
        questionScores.put("Q1", 2);
        questionScores.put("Q2", 3);

        checkResult(Q2(questionScores), 5);


        // sample HashMap usage

        String sentence = "I lost one of my six birds so I have five now. I wish I had ten.";

        for(String word : numbers.keySet()){
            sentence = sentence.replace(word, numbers.get(word).toString());
        }

        System.out.println('\n' + sentence);
    }

}