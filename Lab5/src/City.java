
public class City {

	private String countryCode; 
	private String cityName;
	private String region;
	
	
	public City(String countryCode, String cityName, String region) {
		this.countryCode = countryCode;
		this.cityName = cityName;
		this.region = region;
	}
	
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}


	@Override
	public String toString() {
		return "[" + countryCode + ", " + cityName + ", " + region + "]";
	}
	
	
}
