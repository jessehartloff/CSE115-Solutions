import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.ArrayList;



public class MusicRatings {

	public static String getRequest(String url) {
		String response = "";
		try {
			response = Request.Get(url).execute().returnContent().asString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public static String postRequest(String url, String params) {
		String response = "";
		try {
			response = Request.Post(url).bodyString(params, ContentType.APPLICATION_JSON).execute().returnContent()
					.asString();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return response;
	}

	



    public static Song jsonToSong(JsonObject jsonSong){
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	for(int i = 0; i < jsonSong.get("ratings").asArray().size(); ++i){
    		a.add(jsonSong.get("ratings").asArray().get(i).asInt());
    	}
    	Song ans = new Song();
    	ans.setArtist(jsonSong.get("artist").asString());
    	ans.setYoutubeID(jsonSong.get("youtubeID").asString());
    	ans.setRatings(a);
    	ans.setTitle(jsonSong.get("title").asString());
        return ans;
    }


    public static ArrayList<Song> getAllSongsFromAPI() {
    	String jsonString = getRequest("http://fury.cse.buffalo.edu/musicRatings/getAllSongs");
    	JsonArray upperObject = Json.parse(jsonString).asArray();
    	ArrayList<Song> songs = new ArrayList<Song>();
    	for(int i = 0; i < upperObject.size(); ++i){
    		songs.add(jsonToSong(upperObject.get(i).asObject()));
    	}
        return songs;
    }


    
    public static double getAverage(ArrayList<Integer> data){
    	double total = 0.0;
    	for(int i : data){
    		total += i;
    	}
    	return total/(double)data.size();
    }

    public static ArrayList<Song> getGoodSongs(double minRating, int minNumberOfRatings){
    	ArrayList<Song> songs = new ArrayList<Song>();
    	for(Song s : getAllSongsFromAPI()){
    		if(s.getRatings().size() >= minNumberOfRatings && getAverage(s.getRatings()) >= minRating){
    			songs.add(s);
    		}
    	}
        return songs;
    }
    
    
  



    public static void main(String[] args) {
    }

}
