import java.util.ArrayList;
import java.util.HashMap;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

public class PS10_JSON{


    static String Q1(int a, int b, int c){
        // return a JSON String that is an array containing the values a, b, and c in that order.
    	JsonArray arr = new JsonArray();
    	arr.add(a);
    	arr.add(b);
    	arr.add(c);
        return arr.toString();
    }


    static String Q2(ArrayList<Integer> numbers){
        // return a JSON String that is an array containing the values of the input ArrayList in the same
        // order as they appear in the ArrayList.
    	JsonArray arr = new JsonArray();
    	for(int i : numbers){
    		arr.add(i);
    	}

        return arr.toString();
    }


    static String Q3(String key, int value){
        // return a JSON String that is an object containing the provided key-value pair
    	JsonObject obj = new JsonObject();
    	obj.add(key, value);
        return obj.toString();
    }


    static String Q4(String key, String value){
        // return a JSON String that is an object containing the provided key-value pair
    	JsonObject obj = new JsonObject();
    	obj.add(key, value);
        return obj.toString();
    }


    static String Q5(HashMap<String, Integer> input){
        // return a JSON String that is an object containing the same key-value pairs stored in the input HashMap
    	JsonObject obj = new JsonObject();
    	for(String key : input.keySet()){
    		obj.add(key, input.get(key));
    	}

        return obj.toString();
    }


    static String Q6(String json){
        // given a JSON object in the format {"title":"Fight Club","tagline":"Mischief. Mayhem. Soap.","year":1999},
        // return the value at the key "title" as a String

        return Json.parse(json).asObject().get("title").asString();
    }


    static String Q7(String json){
        // given a JSON object in the format {"title":"Fight Club","tagline":"Mischief. Mayhem. Soap.","year":1999},
        // return the value at the key "tagline" as a String

        return  Json.parse(json).asObject().get("tagline").asString();
    }


    static int Q8(String json){
        // given a JSON object in the format {"title":"Fight Club","tagline":"Mischief. Mayhem. Soap.","year":1999},
        // return the value at the key "year" as a int

        return  Json.parse(json).asObject().get("year").asInt();
    }


    static String Q9(String json){
        // given a JSON String that is an array in this format [5,"airplane","volunteer","nope"],
        // return data at index 2 as a String

        return  Json.parse(json).asArray().get(2).asString();
    }


    static ArrayList<String> Q10(String json){
        // given a JSON String that is an array containing an unknown number of Strings,
        // return all the values in the array in an ArrayList of Strings
    	ArrayList<String> ans = new ArrayList<String>();
    	
    	// quick question:
    	// this is very inefficient but why?
    	for(JsonValue j : Json.parse(json).asArray()){
    		ans.add(j.asString());
    	}
        return ans;
    }


    static String Q11(String json){
        // given a JSON String in the format
        // [{"title":"The Matrix","year":1999},{"title":"The Shawshank Redemption","year":1994}]
        // return the value at the key "title" of the second object in the array.
    	
    	// good example of method call chaining
        return Json.parse(json).asArray().get(1).asObject().get("title").asString();
    }


    static int Q12(String json){
        // given a JSON String in the format of an array of objects where each object is in the format
        // {"title":"Star Wars: Episode V - The Empire Strikes Back","year":1980}
        // return the number of ojects in the array.

        return Json.parse(json).asArray().size();
    }


    static ArrayList<Integer> Q13(String json){
        // given a JSON String in the format of an array of objects where each object is in the format
        // {"title":"Pulp Fiction","year":1994}
        // return the values at the key "year" for all objects in the array in an ArrayList of Integers
    	ArrayList<Integer> ans  = new ArrayList<Integer>();
    	JsonValue parsed = Json.parse(json);
    	for(JsonValue val : parsed.asArray()){
    		ans.add(val.asObject().get("year").asInt());
    	}
    	
        return ans;
    }


    static ArrayList<String> Q14(String json){
        // given a JSON String in the format of an array of objects where each object is in the format
        // {"title":"Inception","year":2010,"stars":["Leonardo DiCaprio","Joseph Gordon-Levitt","Ellen Page"]}
        // return all the values at the key "stars" for all objects in the array in an ArrayList of Strings.
        // The value stored at "stars" will be an array for each object.
    	ArrayList<String> ans  = new ArrayList<String>();
    	JsonValue parsed = Json.parse(json);
    	for(JsonValue val : parsed.asArray()){
    		JsonArray arr = val.asObject().get("stars").asArray();
    		for(JsonValue value : arr){
    			ans.add(value.asString());
    		}
    	}
    	

        return ans;
    }


    static String Q15(String json, String key, String value){
        // given a JSON String in the form of a JSON object, add the the provided key-value pair to this
        // object and return it as a JSON String.
    	

        return Json.parse(json).asObject().add(key, value).toString();
    }



    public static void main(String[] args){

    }
}
