import com.eclipsesource.json.JsonObject;

public class JSONLecture1 {


    // 5 points
    static String Q1(String nameValue, String titleValue, int rankValue) {
        // return a String in the format of a JSON object containing three key-value pairs where the keys
        // are "name", "title", and "rank" and values are provided as parameters of this method.
    	JsonObject ans = new JsonObject();
    	ans.add("name",nameValue);
    	ans.add("title",titleValue);
    	ans.add("rank",rankValue);
        return ans.toString();
    }


    public static void main(String[] args) {

    }

}