import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class JSONLecture2 {


    // 2 points
    static String Q1(String json){
        // given a JSON String that is an array in this format [4,"roy","guzzles","runny","prophecies"],
        // that is 5 elements consisting of an int then 4 Strings, return the data at index 3 as a String.

        return Json.parse(json).asArray().get(3).asString();
    }


    // 3 points
    static String Q2(String scores){
        // given a JSON object containing scores in the format {"home":0,"visiting":0}, that is
        // it has keys "home" and "visiting" with each storing an int value, return the key storing
        // the larger int value or "tie" if the values are the same.
    	JsonObject obj = Json.parse(scores).asObject();
    	if(obj.get("home").asInt() > obj.get("visiting").asInt()){
    		return "home";
    	}
    	if(obj.get("home").asInt() < obj.get("visiting").asInt()){
    		return "visiting";
    	}
        return "tie";
    }


    public static void main(String[] args) {
        
    }

}