import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class PS9_Networking {
	
	public static String getRequest(String url) {
		String response = "";
		try {
			response = Request.Get(url).execute().returnContent().asString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}
	
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

    static String Q1(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api and return the server's response
        // as a String
        //
        // Note: There will be very little feedback from Autolab for this assignment. You should run your code
        //       to verify that you are recieving a response from the server before sumbitting.

        return getRequest("http://fury.cse.buffalo.edu/api");
    }

    static String Q2(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_string and return the server's response
        // as a String

        return getRequest("http://fury.cse.buffalo.edu/api/get_string");
    }

    static int Q3(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_int and return the server's response
        // as an int. You may assume that the response is a well-formed integer

        return new Integer(getRequest("http://fury.cse.buffalo.edu/api/get_int"));
    }

    static String Q4(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/post and return the
        // server's response as a String

        return getRequest("http://fury.cse.buffalo.edu/api/post");
    }

    static String Q5(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params and return the
        // server's response as a String

        return getRequest("http://fury.cse.buffalo.edu/api/get_with_params");
    }

    static String Q6(){
        // Send the empty String (eg. "") in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.

        return postRequest("http://fury.cse.buffalo.edu/api/post", "");
    }

    static String Q7(){
        // Send "hello server" in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.

    	return postRequest("http://fury.cse.buffalo.edu/api/post", "hello server");
    }

    static String Q8(){
        // Send "how are you?" in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.

    	return postRequest("http://fury.cse.buffalo.edu/api/post", "how are you?");
    }

    static String Q9(String content){
        // Send the provided content in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.

    	return postRequest("http://fury.cse.buffalo.edu/api/post", content);
    }

    static String Q10(Integer value){
        // Send the provided int value in the body of an HTTP POST request to the url
        // http://fury.cse.buffalo.edu/api/post and return the server's response as a String. Use
        // DEFAULT_TEXT as the content type.

    	return postRequest("http://fury.cse.buffalo.edu/api/post", value.toString());
    }

    static String Q11(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "question" set to the value "11" and return the server's response as a String

        return getRequest("http://fury.cse.buffalo.edu/api/get_with_params?question=11");
    }

    static String Q12(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value "value" and return the server's response as a String

    	return getRequest("http://fury.cse.buffalo.edu/api/get_with_params?key=value");
    }

    static String Q13(String param){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value of the provided param and return the server's response as a String

    	return getRequest("http://fury.cse.buffalo.edu/api/get_with_params?key="+param);
    }

    static String Q14(){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "question" set to the value "14" and a parameter "key" set to the value "turtle" and return
        // the server's response as a String

    	return getRequest("http://fury.cse.buffalo.edu/api/get_with_params?key=turtle&question=14");
    }

    static String Q15(String param1, String param2){
        // Send an HTTP GET request to the url http://fury.cse.buffalo.edu/api/get_with_params with a
        // parameter "key" set to the value of param1 and a parameter "query" set to the value of param2
        // and return the server's response as a String

        return getRequest("http://fury.cse.buffalo.edu/api/get_with_params?key="+param1+"&query="+param2);
    }

    public static void main(String[] args) {

    }

}
