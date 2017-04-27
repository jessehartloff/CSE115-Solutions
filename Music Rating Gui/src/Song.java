import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Song{

    // Instance variables
    private String youtubeID;
    private String title;
    private String artist;
    private ArrayList<Integer> ratings;

    // Default constructor
    public Song(){
        this("", "", "", new ArrayList<>());
    }

    // Constructor
    public Song(String youtubeID, String title, String artist, ArrayList<Integer> ratings){
        this.youtubeID = youtubeID;
        this.title = title;
        this.artist = artist;
        this.ratings = ratings;
    }


    // Getters and Setters

    public String getYoutubeID(){
        return youtubeID;
    }

    public void setYoutubeID(String youtubeID){
        this.youtubeID = youtubeID;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public ArrayList<Integer> getRatings(){
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings){
        this.ratings = ratings;
    }


    // toString for easier debugging when songs are printed
    @Override
    public String toString(){
        return "youtubeID=" + youtubeID + '\n' +
                "title=" + title + '\n' +
                "artist=" + artist + '\n' +
                "ratings=" + ratings;
    }



    // And a few methods just for fun. These are not required, but it is highly recommended
    // that you call these methods throughout the assignment.

    public void play(){
        if(Desktop.isDesktopSupported()){
            try{
                String url = "https://www.youtube.com/watch?v=" + this.getYoutubeID();
                Desktop.getDesktop().browse(new URI(url));
            }catch(IOException e){
                e.printStackTrace();
            }catch(URISyntaxException e){
                e.printStackTrace();
            }
        }
    }


    public static void playList(ArrayList<Song> songs){
        if(Desktop.isDesktopSupported()){
            try{
                String url = "https://www.youtube.com/watch_videos?video_ids=";
                if(!songs.isEmpty()){
                    url += songs.get(0).getYoutubeID();
                }
                for(int i=1; i<songs.size(); i++){
                    url += "," + songs.get(i).getYoutubeID();
                }
                Desktop.getDesktop().browse(new URI(url));
            }catch(IOException e){
                e.printStackTrace();
            }catch(URISyntaxException e){
                e.printStackTrace();
            }
        }
    }

}
