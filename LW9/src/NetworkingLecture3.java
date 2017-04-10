import java.io.IOException;

import org.apache.http.client.fluent.Request;

public class NetworkingLecture3 {

	public static String getRequest(String url) {
		String response = "";
		try {
			response = Request.Get(url).execute().returnContent().asString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}
    // 5 points
    static String Q1(String tid) {
        // Send an HTTP GET request to http://fury.cse.buffalo.edu/api/question with query string arguments
        // of "lecture" and "tid" where the value of "lecture" is "3" and the value of "tid" is the value
        // provided as the input to this method
    	
        return getRequest("http://fury.cse.buffalo.edu/api/question?lecture=3&tid="+ tid);
    }


    public static void main(String[] args) {

    }

}