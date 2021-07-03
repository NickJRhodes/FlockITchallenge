package challenge.rest.responses;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Province {
	
	@JsonAlias("nombre")
	private String name;
	
	@JsonAlias("centroide")
	private Centroide centroide;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Centroide getCentroide() {
		return centroide;
	}

	public void setCentroide(Centroide centroide) {
		this.centroide = centroide;
	}

}
