import java.util.ArrayList;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

public class JSONLecture3 {


    // 2 points
    static ArrayList<String> Q1(String inputJson){
        // given a JSON String in the format of an array of objects where each object is in the format
        // {"name":"String","number":147}
        // return the value of "name" for each object in an ArrayList
    	ArrayList<String> answer = new ArrayList<String>();
    	
    	for(JsonValue j : Json.parse(inputJson).asArray()){
    		answer.add(j.asObject().get("name").asString());
    	}

        return answer;
    }


    // 3 points
    static String Q2(String inputJson){
        // given a JSON String in the format of an array of objects where each object is in the format
        // {"name":"String","number":147}
        // return the value of "name" of the object with the largest value for "number"
    	int max = Integer.MIN_VALUE;
    	String maxName = "";
    	for(JsonValue j : Json.parse(inputJson).asArray()){
    		if(j.asObject().get("number").asInt() > max){
    			max = j.asObject().get("number").asInt();
    			maxName = j.asObject().get("name").asString();
    		}
    		
    	}


        return maxName;
    }



    public static void main(String[] args) {

    }

}