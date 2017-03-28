
public class Location {

	private double latitude;
	private double longitude;
	
	public Location(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setLatitude(double newLatitude){
		this.latitude = newLatitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
	
	public void setLongitude(double newLongitude){
		this.longitude = newLongitude;
	}
	
	public double getLongitude(){
		return this.longitude;
	}

	@Override
	public String toString() {
		return "{latitude:" + latitude + ", longitude:" + longitude + "}";
	}

	
}
