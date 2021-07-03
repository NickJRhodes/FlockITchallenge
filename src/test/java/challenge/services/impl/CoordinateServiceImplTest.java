package challenge.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import challenge.beans.Beans;
import challenge.exception.ProvincesResponseException;
import challenge.rest.responses.Centroide;
import challenge.rest.responses.Province;
import challenge.rest.responses.ProvincesResponse;
import challenge.services.CoordinateService;

/**
 * Unit test for CoordinateServiceImpl class.
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Beans.class, RestTemplate.class, CoordinateServiceImpl.class})
@TestPropertySource(properties = "api.provinces.uri=A")
public class CoordinateServiceImplTest {
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Autowired
	private CoordinateService coordinateService;
	
	@Test
	public void successApiResponseTest() {
		ProvincesResponse dummyResponse = generteOneProvinceTestInstance();
		Mockito.when(restTemplate.getForObject("A", ProvincesResponse.class, "B"))
			.thenReturn(dummyResponse);
		
		Assertions.assertTrue(coordinateService.getCoordinateByProvince("B").getLatitude().equals(500D));
		Assertions.assertTrue(coordinateService.getCoordinateByProvince("B").getLongitude().equals(250D));
	}
	
	@Test
	public void zerProvincesApiResponseTest() {
		ProvincesResponse dummyResponse = generteZeroProvincesTestInstance();
		Mockito.when(restTemplate.getForObject("A", ProvincesResponse.class, "B"))
			.thenReturn(dummyResponse);
		
		Assertions.assertThrows(ProvincesResponseException.class, () -> coordinateService.getCoordinateByProvince("B"));
	}
	
	@Test
	public void manyProvincesIntoResponseTest() {
		ProvincesResponse dummyResponse = generteManyProvincesTestInstance();
		Mockito.when(restTemplate.getForObject("A", ProvincesResponse.class, "B"))
			.thenReturn(dummyResponse);
		
		Assertions.assertTrue(coordinateService.getCoordinateByProvince("B").getLatitude().equals(50D));
		Assertions.assertTrue(coordinateService.getCoordinateByProvince("B").getLongitude().equals(80D));
	}
	
	private ProvincesResponse generteZeroProvincesTestInstance() {
		ProvincesResponse response = new ProvincesResponse();
		response.setProvinces(new ArrayList<>());
		
		return response;
	}
	
	private ProvincesResponse generteOneProvinceTestInstance() {
		Centroide centroide = new Centroide();
		centroide.setLat(500D);
		centroide.setLon(250D);
		
		Province province = new Province();
		province.setCentroide(centroide);
		
		ProvincesResponse response = new ProvincesResponse();
		response.setProvinces(Arrays.asList(province));
		
		return response;
	}
	
	private ProvincesResponse generteManyProvincesTestInstance() {
		Centroide c1 = new Centroide();
		c1.setLat(50D);
		c1.setLon(80D);
		Centroide c2 = new Centroide();
		c2.setLat(500D);
		c2.setLon(250D);
		
		Province p1 = new Province();
		p1.setCentroide(c1);
		Province p2 = new Province();
		p2.setCentroide(c2);
		
		ProvincesResponse response = new ProvincesResponse();
		response.setProvinces(Arrays.asList(p1, p2));
		
		return response;
	}

}
