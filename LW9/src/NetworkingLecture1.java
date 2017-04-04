import java.io.IOException;

import org.apache.http.client.fluent.Request;

public class NetworkingLecture1 {

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
    static String Q1() {
        // Send an HTTP GET request to http://fury.cse.buffalo.edu/api/lecture1 and return the server's response

        return getRequest("http://fury.cse.buffalo.edu/api/lecture1");
    }


    public static void main(String[] args) {

    }

}
