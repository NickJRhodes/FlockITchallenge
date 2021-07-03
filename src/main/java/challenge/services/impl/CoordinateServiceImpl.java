package challenge.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import challenge.exception.ProvincesResponseException;
import challenge.model.Coordinate;
import challenge.rest.responses.ProvincesResponse;
import challenge.services.CoordinateService;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@Service
public class CoordinateServiceImpl implements CoordinateService {

	private static final Logger logger = LoggerFactory.getLogger(CoordinateServiceImpl.class);

	@Value("${api.provinces.uri}")
	private String apiProvincesUri;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Coordinate getCoordinateByProvince(String province) {
		ProvincesResponse response = restTemplate.getForObject(apiProvincesUri, ProvincesResponse.class, province);

		return extractCoordinatesFromProvincesResponse(response);
	}

	private Coordinate extractCoordinatesFromProvincesResponse(ProvincesResponse response) {
		if (response.getProvinces().size() < 1) {
			throw new ProvincesResponseException("Unexpected api response, please check the province name.");
		}

		Coordinate coordinate = new Coordinate();
		coordinate.setLatitude(response.getProvinces().get(0).getCentroide().getLat());
		coordinate.setLongitude(response.getProvinces().get(0).getCentroide().getLon());

		logger.debug(coordinate.toString());

		return coordinate;
	}

}
