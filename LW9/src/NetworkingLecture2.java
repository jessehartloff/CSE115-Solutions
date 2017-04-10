import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class NetworkingLecture2 {
	public static String postRequest(String url, String params){
	    String response = "";

	    try{
	        response = Request.Post(url)
	                .bodyString(params, ContentType.DEFAULT_TEXT)
	                .execute().returnContent().asString();
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }

	    return response;
	}

    // 5 points
    static String Q1() {
        // Send "lecture request" in the body of an HTTP POST request to http://fury.cse.buffalo.edu/api/lecture2
        // and return the server's response

		return postRequest("http://fury.cse.buffalo.edu/api/lecture2", "lecture request");
    }


    public static void main(String[] args) {
    	System.out.println(Q1());
    }

}