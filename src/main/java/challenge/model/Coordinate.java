package challenge.model;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
public class Coordinate {
	
	private Double latitude;
	private Double longitude;
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("latitude: " + this.latitude)
			.append(" ")
			.append("longitude: " + this.longitude);
		
		return stringBuilder.toString();
	}

}
