import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab5 {

    public static void getLocation(String countryCode, String cityName, String region){
        // Directory may need to be changed depending on where the cities files are stored
        String directory = "cities/";
        String filename = directory + countryCode + ".csv";
        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                String[] splits = line.split(",");
                if(splits[1].equals(cityName) && splits[2].equals(region)){
                    System.out.println("Lat: " + splits[3]);
                    System.out.println("Long: " + splits[4]);
                    return;
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        System.out.println("An error has occurred");
    }

    public static double getDistance(String countryCode0, String cityName0, String region0,
                                 String countryCode1, String cityName1, String region1){
        // Directory may need to be changed depending on where the cities files are stored
        String directory = "cities/";
        String filename0 = directory + countryCode0 + ".csv";
        String filename1 = directory + countryCode1 + ".csv";
        try {
            double lat0 = 0.0;
            double long0 = 0.0;
            for (String line : Files.readAllLines(Paths.get(filename0))) {
                String[] splits = line.split(",");
                if(splits[1].equals(cityName0) && splits[2].equals(region0)){
                    lat0 = new Double(splits[3]);
                    long0 = new Double(splits[4]);
                }
            }
            double lat1 = 0.0;
            double long1 = 0.0;
            for (String line : Files.readAllLines(Paths.get(filename1))) {
                String[] splits = line.split(",");
                if(splits[1].equals(cityName1) && splits[2].equals(region1)){
                    lat1 = new Double(splits[3]);
                    long1 = new Double(splits[4]);
                }
            }
            return LabLibrary.greaterCircleDistance(lat0, long0, lat1, long1);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return 0.0;
    }
    
    
    public static void main(String[] args){
        getLocation("us","rochester","ny");
        getLocation("us","buffalo","ny");

        System.out.print("\nDistance between Rochester and Buffalo: ");
        System.out.println(getDistance("us","rochester","ny","us","buffalo","ny") + "km");
        System.out.print("Distance between New Delhi and Buffalo: ");
        System.out.println(getDistance("in","new delhi","07","us","buffalo","ny") + "km");
    }
    
}

