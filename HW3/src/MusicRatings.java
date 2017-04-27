import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// All imports from the solution have been included. You can import more classes, though it is confirmed
// that the assignment can be completed with the above imports only. This includes the bonus question.

// The Song class and this MusicRatings class will both be in the default package during graded.



/**
 * The MusicRating class is a collection of methods used to process data from the music ratings API.
 *
 * API url: http://fury.cse.buffalo.edu/musicRatings
 */
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

	

    /**
     * 5 points
     *
     * Returns the average rating of the given Song object. This method assumes the Song class is
     * in the default package.
     *
     * @param song  A Song object
     * @return the average rating of the song
     */
    public static double averageRating(Song song){
    	double avg = 0.0;
    	for(double num : song.getRatings()){
    		avg += num;
    	}
        return avg/(double)song.getRatings().size();
    }



    /**
     * 5 points
     *
     * Converts a JSON Object into a Song object. This method assumes that the input is in the format:
     * {"title":"Lose Yourself", "artist":"Eminem", "ratings":[5,5,4,5], "youtubeID":"xFYQQPAOz7Y"}
     *
     * @param jsonSong  A song in JSON format
     * @return A Song object with the data from the JSON Value
     */
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


    /**
     * 10 points
     *
     * Return every song from the music ratings API as an ArrayList of Song objects.
     *
     * A JSON string containing the information for every rated song can be obtained with a GET
     * request to the url: http://fury.cse.buffalo.edu/musicRatings/getAllSongs
     * The format of the returned string is a JSON list of songs represented as JSON objects in the
     * same format as the input of the previous method. To see this format and the data you can paste
     * the url into a web browser.
     *
     * @return An ArrayList containing all the songs from the music ratings API
     */
    public static ArrayList<Song> getAllSongsFromAPI() {
    	String jsonString = getRequest("http://fury.cse.buffalo.edu/musicRatings/getAllSongs");
    	JsonArray upperObject = Json.parse(jsonString).asArray();
    	ArrayList<Song> songs = new ArrayList<Song>();
    	for(int i = 0; i < upperObject.size(); ++i){
    		songs.add(jsonToSong(upperObject.get(i).asObject()));
    	}
        return songs;
    }


    /**
     * 10 points
     *
     * Returns the song from the music ratings API that has been rated the most number of times as
     * a Song object. The rating of the songs should not be considered in this method, only the number
     * of times they have been rated. Ties can be broken arbitrarily.
     *
     * @return A Song with the most reviews
     */
    public static Song getMostRatedSong(){
    	int max = Integer.MIN_VALUE;
    	Song maxSong = null;
    	for(Song s : getAllSongsFromAPI()){
    		if(s.getRatings().size() > max){
    			max = s.getRatings().size();
    			maxSong = s;
    		}
    	}
        return maxSong;
    }

    
    public static double getAverage(ArrayList<Integer> data){
    	double total = 0.0;
    	for(int i : data){
    		total += i;
    	}
    	return total/(double)data.size();
    }

    /**
     * 10 points
     *
     * Returns an ArrayList containing all songs from the song ratings API with at least "minRating" average
     * rating and at least "minNumberOfRatings" number of ratings. The songs can be listed in any order.
     *
     * @param minRating  minimum rating of returned songs
     * @param minNumberOfRatings  minimum number of ratings of returned songs
     * @return all songs from the song ratings API with >= minRating and >= minNumberOfRatings
     *
     */
    public static ArrayList<Song> getPlaylist(double minRating, int minNumberOfRatings){
    	ArrayList<Song> songs = new ArrayList<Song>();
    	for(Song s : getAllSongsFromAPI()){
    		if(s.getRatings().size() >= minNumberOfRatings && getAverage(s.getRatings()) >= minRating){
    			songs.add(s);
    		}
    	}
        return songs;
    }
    
    
    
    public static Song getNext(HashMap<Song,Double> data){
    	double max  = Double.NEGATIVE_INFINITY;
    	Song maxSong = null;
    	for(Song s : data.keySet()){
    		if(data.get(s) > max){
    			max = data.get(s);
    			maxSong = s;
    		}
    	}
    	data.remove(maxSong);
    	return maxSong;
    }
    
    //challenge helper
    private static double RatingSummation(ArrayList<Integer> ratings){
    	double ans = 0.0;
    	for(int i : ratings){
    		ans += i;
    	}
    	return ans;
    }


    /**
     * Challenge Question
     * Bonus: 10 points
     *
     * Returns an ArrayList of the top k songs sorted by the bayesian average of their ratings.
     *
     * references:
     * https://en.wikipedia.org/wiki/Bayesian_average
     * http://fulmicoton.com/posts/bayesian_rating/
     *
     * For m use the average rating cast across all songs. Note that this is not the average of
     * all the average ratings, but the average of all individual ratings. For example if the API
     * contained only 2 songs with ratings [4,4,4] and [5] m would be 4.25.
     *
     * For C use the average number of ratings across all songs. In the example with 2 songs with
     * ratings [4,4,4] and [5] C would be 2.
     *
     * @return The k best songs based on the bayesian average of their ratings starting with
     *         the best song at index 0
     */
    public static ArrayList<Song> getBestPlaylist(int k){
        // Earning credit for this question will require self-learning. The concepts needed to complete
        // this method have not been covered in this course, or were only covered briefly.
    	HashMap<Song,Double> ranking = new HashMap<Song,Double>();
    	//num of reviews
    	//weighted avg of all reviews
    	double c = 0.0;
    	double m = 0.0;
    	ArrayList<Song> songs = getAllSongsFromAPI();
    	for(Song song : songs){
    		for(double i : song.getRatings()){
    			m += i;
    		}
    		
    		c += song.getRatings().size();
    		
    	}
    	m = m / c;
    	c = c / (double)songs.size();    	

    	for(Song song : songs){
    		Collections.sort(song.getRatings());
    		double rank = ((c*m) +RatingSummation(song.getRatings()))/(song.getRatings().size() + c);
    		ranking.put(song, rank);
    	}
    	
    	ArrayList<Song> done = new ArrayList<Song>();
    	for(int i = 0; i < k; ++i){
    		if(!ranking.isEmpty()){
    			done.add(getNext(ranking));
    		}
    		
    	}
        return done;
    }



    public static void main(String[] args) {
    	getBestPlaylist(20);
    }

}
