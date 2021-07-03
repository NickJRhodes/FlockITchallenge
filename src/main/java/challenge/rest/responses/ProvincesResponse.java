package challenge.rest.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvincesResponse {
	
	@JsonAlias("provincias")
	private List<Province> provinces;

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

}
